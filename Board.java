package mjs2w6chessf21;

import java.util.ArrayList;

/**
 *
 * @author matthewschutz
 */
public class Board implements BoardAction{
    
    
    // my own work
    public ArrayList<ArrayList<Piece>> boardGrid;
    private int turnCounter;
    private boolean wKMoved;
    private boolean wRAMoved;
    private boolean wRHMoved ;
    private boolean bKMoved;
    private boolean bRAMoved;
    private boolean bRHMoved;
    private boolean whiteCheckmate;
    private boolean blackCheckmate;
    private boolean stalemate;
    private int wKingX;
    private int wKingY;
    private int bKingX;
    private int bKingY;
    private ArrayList<Integer> wEnPass;
    private ArrayList<Integer> bEnPass;
    public int lastEnPass;
    public int lastUpgrade;
    
    
    public Board(){
        boardGrid = new ArrayList<ArrayList<Piece>>(8);
        turnCounter = 0;
        wKMoved = false;
        wRAMoved = false;
        wRHMoved = false;
        bKMoved = false;
        bRAMoved = false;
        bRHMoved = false;
        whiteCheckmate = false;
        blackCheckmate = false;
        wKingX = 4;
        wKingY = 7;
        bKingX = 4;
        bKingY = 0;
        lastEnPass = -2;
        lastUpgrade = -2;
        stalemate = false;
        initPieces();
        initEnPass();
    }
    
    @Override
    public Piece getPiece(int y, int x){
        return boardGrid.get(y).get(x);
    }
    
    @Override
    public Player whoseTurn(){
        if(turnCounter % 2 == 0) return Player.WHITE; 
        return Player.BLACK;
    }
    
    public void incTurn()
    {
        turnCounter++;
    }
    
    private void printBoard()
    {
        for(int i = 0; i < 8; i++)
        {
            System.out.print((i+1 + ":"));
            for(int j = 0; j < 8; j++)
            {
                Piece p = boardGrid.get(i).get(j);
                if(p == null) System.out.print(" X :");
                else{
                    switch(p.getType())
                    {
                        case PAWN:
                            System.out.print(" P :");
                            break;
                        case KNIGHT:
                            System.out.print(" N :");
                            break;
                        case BISHOP:
                            System.out.print(" B :");
                            break;
                        case ROOK:
                            System.out.print(" R :");
                            break;
                        case QUEEN:
                            System.out.print(" Q :");
                            break;
                        case KING:
                            System.out.print(" K :");
                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.println("");
        }
    }
    
    public Piece movePiece(int fromY, int fromX, int toY, int toX, Castle castleType)
    {
        checkEnPassPossPiece(fromY, fromX, toY);
        checkEnPass(fromY,fromX,toY, toX);
        Piece p = getPiece(fromY, fromX);
        setCastleStatus(p, fromY, fromX);
        if(castleType != Castle.NONE) castle(castleType);
        boardGrid.get(fromY).set(fromX, null);
        boardGrid.get(toY).set(toX, p);
        p.setX(toX);
        p.setY(toY);
        if(p.getType() == Type.PAWN && ((p.getPlayer() == Player.BLACK && p.getY() == 7) || (p.getPlayer() == Player.WHITE && p.getY() == 0))){
            p = upgradePawn(p);
        }
        if(p.getType() == Type.KING){
            updateKingLoc(p,toY,toX);
        }
        updateCheck(p);
        stalemate();
        return p;
    }
    
    private Piece upgradePawn(Piece p)
    {
        printBoard();
        System.out.println("Y = " + p.getY() + " : X = " + p.getX());
        Piece newQueen = new Queen(p.getY(), p.getX(), p.getPlayer());
        boardGrid.get(p.getY()).set(p.getX(), newQueen);
        lastUpgrade = turnCounter;
        printBoard();
        return newQueen;
    }
    
    public ArrayList<Square> getMoves(Piece p)
    {
        switch (p.getType()) {
                        case PAWN:
                            return pawnMoves(p.getY(), p.getX(), p);
                        case KNIGHT:
                            return knightMoves(p.getY(), p.getX(), p);
                        case BISHOP:
                            return bishopMoves(p.getY(), p.getX(), p);
                        case ROOK:
                            return rookMoves(p.getY(), p.getX(), p);
                        case QUEEN:
                            return queenMoves(p.getY(), p.getX(), p);
                        case KING:
                            return kingMoves(p.getY(), p.getX(), p);
                        default:
                            break;
                    }
        return null;
    }
    
    public void checkEnPass(int fromY, int fromX, int toY, int toX)
    {
        Piece p = getPiece(fromY, fromX);
        if(p != null && p.getType() == Type.PAWN && fromX != toX && getPiece(toY, toX) == null)
        {
            boardGrid.get(fromY).set(toX, null);
            lastEnPass = turnCounter;
        }
    }
    
    private void checkEnPassPossPiece(int fromY, int x, int toY)
    {
        Piece p = getPiece(fromY, x);
        if(p != null && p.getType() == Type.PAWN)
        {
            if(p.getPlayer() == Player.WHITE && fromY == 6 && toY == 4)
            {
                wEnPass.set(x, turnCounter);
                return;
            }
            if(p.getPlayer() == Player.BLACK && fromY == 1 && toY == 3)
            {
                bEnPass.set(x, turnCounter);
            }
        }
    }
    
    private void updateCheck(Piece p)
    {
        if(p.getPlayer() == Player.WHITE)
        {
            Piece king = boardGrid.get(bKingY).get(bKingX);
            if(isSquareInCheck(bKingY, bKingX, king)){
                if(kingMoves(bKingY, bKingX, king).isEmpty())
                    if(checkmate(king)) whiteCheckmate = true;
            }
        }
        else{
            Piece king = boardGrid.get(wKingY).get(wKingX);
            if(isSquareInCheck(wKingY, wKingX, king)){
                if(kingMoves(wKingY, wKingX, king).isEmpty())
                    if(checkmate(king)) blackCheckmate = true;
            }
        }
    }
    
    private boolean checkmate(Piece king)
    {
        for(int i = 0; i < 8; ++i)
        {
            for(int j = 0; j < 8; ++j)
            {
                Piece p = boardGrid.get(i).get(j);
                if(p != null && p.getPlayer() == king.getPlayer())
                {
                    ArrayList<Square> moves2 = null;
                    moves2 = getMoves(p);
                    if(!moves2.isEmpty()) {
                        return false;
                    }
                }
            }
        }
        System.out.println("Checkmate");
        return true;
    }
    
    private boolean stalemate()
    {
        Player team = Player.WHITE;
        if(turnCounter%2 == 0) team = Player.BLACK;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Piece p = getPiece(i, j);
                if(p != null && p.getPlayer() == team)
                {
                    ArrayList<Square> moves = getMoves(p);
                    if(!moves.isEmpty()) return false;
                }
            }
        }
        stalemate = true;
        return true;
    }
    
    private void updateKingLoc(Piece p,int toY, int toX)
    {
        if(p.getPlayer() == Player.WHITE)
        {
            wKingX = toX;
            wKingY = toY;
        }
        else{
            bKingX = toX;
            bKingY = toY;
        }
    }
    
    private void castle(Castle castleType)
    {
        if(castleType == Castle.WA)
        {
            Piece p = getPiece(7,0);
            p.setX(3);
            p.setY(7);
            boardGrid.get(7).set(3, p);
            boardGrid.get(7).set(0, null);
            return;
        }
        if(castleType == Castle.WH)
        {
            Piece p = getPiece(7,7);
            p.setX(5);
            p.setY(7);
            boardGrid.get(7).set(5, p);
            boardGrid.get(7).set(7, null);
            return;
        }
        if(castleType == Castle.BA)
        {
            Piece p = getPiece(0,0);
            p.setX(3);
            p.setY(0);
            boardGrid.get(0).set(3, p);
            boardGrid.get(0).set(0, null);
            return;
        }
        if(castleType == Castle.BH)
        {
            Piece p = getPiece(0,7);
            p.setX(5);
            p.setY(0);
            boardGrid.get(0).set(5, p);
            boardGrid.get(0).set(0, null);
            return;
        }
    }
    
    private ArrayList<Square> checkMoves(ArrayList<Square> moves, Piece p, int y, int x)
    {
        int kingY, kingX;
        if(p.getPlayer() == Player.WHITE) {
            kingY = wKingY;
            kingX = wKingX;
        }
        else{
            kingY = bKingY;
            kingX = bKingX;
        }
        ArrayList<Square> newMoves = new ArrayList<>(moves);
        for(Square s : moves)
        {
            Piece oldPiece = boardGrid.get(s.getY()).get(s.getX());
            boardGrid.get(y).set(x, null);
            boardGrid.get(s.getY()).set(s.getX(), p);
            if(isSquareInCheck(kingY, kingX, p)){
                newMoves.remove(s);
            }
            boardGrid.get(y).set(x, p);
            boardGrid.get(s.getY()).set(s.getX(), oldPiece);
        }
        return newMoves;
    }
    
    public ArrayList<Square> pawnMoves(int y, int x, Piece currentPiece){
        
        ArrayList<Square> possibleSquares = new ArrayList();
        
        int offset = 1;
        if(currentPiece.getPlayer() == Player.WHITE) offset = -1;
        if(validSquare(y+offset, x) && getPiece(y+offset,x) == null) possibleSquares.add(new Square(y+offset,x));
        if(validSquare(y+offset, x+1) && getPiece(y+offset, x+1) != null && getPiece(y+offset, x+1).getPlayer() != currentPiece.getPlayer()) possibleSquares.add(new Square(y+offset, x+1));
        if(validSquare(y+offset, x-1) && getPiece(y+offset, x-1) != null && getPiece(y+offset, x-1).getPlayer() != currentPiece.getPlayer()) possibleSquares.add(new Square(y+offset, x-1));
        
        if(offset == -1 && y == 6 && getPiece(y-2, x) == null && getPiece(y-1, x) == null) possibleSquares.add(new Square(y-2, x));
        if(offset == 1 && y == 1 && getPiece(y+2, x) == null && getPiece(y+1, x) == null) possibleSquares.add(new Square(y+2, x));
        
        Square left = attackEnPass(currentPiece, y, x, offset, -1);
        if(left != null) possibleSquares.add(left);
        Square right = attackEnPass(currentPiece, y, x, offset, +1);
        if(right != null) possibleSquares.add(right);
        
        return checkMoves(possibleSquares, currentPiece, y, x);
    }
    
    private Square attackEnPass(Piece currentPiece, int y, int x, int yOffset, int xOffset)
    {
        if(validSquare(y, x+xOffset)){
            Piece p = getPiece(y, x+xOffset);
            if(p != null && p.getPlayer() != currentPiece.getPlayer() && p.getType() == Type.PAWN)
            {
                if(yOffset == 1 && wEnPass.get(x+xOffset) == turnCounter-1)
                {
                    return new Square(y+yOffset, x+xOffset);
                }
                else if(yOffset == -1 && bEnPass.get(x+xOffset) == turnCounter-1)
                {
                    return new Square(y+yOffset, x+xOffset);
                }
            }
        }
        return null;
    }
    
    public ArrayList<Square> knightMoves(int y, int x, Piece currentPiece){
        
        ArrayList<Square> possibleSquares = new ArrayList();
        Square s;
        
        s = knightMovesWorker(y+2,x+1,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y+2,x-1,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y-2,x+1,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y-2,x-1,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y+1,x+2,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y+1,x-2,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y-1,x+2,currentPiece);
        if(s != null) possibleSquares.add(s);
        s = knightMovesWorker(y-1,x-2,currentPiece);
        if(s != null) possibleSquares.add(s);
        
        return checkMoves(possibleSquares,currentPiece, y, x);
    }
    
    private Square knightMovesWorker(int y, int x, Piece currentPiece)
    {
        if(validSquare(y, x) == false) return null;
        try{
            if(getPiece(y, x).getPlayer() == currentPiece.getPlayer()) return null;
            return new Square(y,x);
        }
        catch(NullPointerException e){
            return new Square(y,x);
        }
    }
    
    public ArrayList<Square> bishopMoves(int y, int x, Piece currentPiece){
        
        ArrayList<Square> possibleSquares = new ArrayList();
        possibleSquares.addAll(bishopMovesWorker(y,x,1,1,currentPiece));
        possibleSquares.addAll(bishopMovesWorker(y,x,1,-1,currentPiece));
        possibleSquares.addAll(bishopMovesWorker(y,x,-1,1,currentPiece));
        possibleSquares.addAll(bishopMovesWorker(y,x,-1,-1,currentPiece));
        possibleSquares = checkMoves(possibleSquares, currentPiece, y, x);
        return possibleSquares;
    }
    
    private ArrayList<Square> bishopMovesWorker(int y, int x, int yOffset, int xOffset, Piece currentPiece)
    {
        ArrayList<Square> squareList = new ArrayList<Square>();
        boolean clearPath = true;
        while(Math.abs(xOffset) < 8 && clearPath)
        {
            if(validSquare(y+yOffset, x+xOffset))
            {
                if(getPiece(y+yOffset, x+xOffset) == null) squareList.add(new Square(y+yOffset, x+xOffset));
                else{
                    if(getPiece(y+yOffset, x+xOffset).getPlayer() != currentPiece.getPlayer()) squareList.add(new Square(y+yOffset, x+xOffset));
                    clearPath = false;
                }
            }
            else clearPath = false;
            if(xOffset > 0) xOffset++;
            else xOffset--;
            if(yOffset > 0) yOffset++;
            else yOffset--;
        }
        
        return squareList;
    }
    
    public ArrayList<Square> rookMoves(int y, int x, Piece currentPiece){
        
        ArrayList<Square> possibleSquares = new ArrayList();
        
        possibleSquares.addAll(rookMovesWorker(y,x,1,0,currentPiece));
        possibleSquares.addAll(rookMovesWorker(y,x,-1,0,currentPiece));
        possibleSquares.addAll(rookMovesWorker(y,x,0,1,currentPiece));
        possibleSquares.addAll(rookMovesWorker(y,x,0,-1,currentPiece));
        
        return checkMoves(possibleSquares, currentPiece, y ,x);
    }
    
    private ArrayList<Square> rookMovesWorker(int y, int x, int yOffset, int xOffset, Piece currentPiece)
    {
        ArrayList<Square> squareList = new ArrayList<Square>();
        boolean clearPath = true;
        while(Math.abs(xOffset) < 8 && Math.abs(yOffset) < 8 && clearPath)
        {
            if(validSquare(y+yOffset, x+xOffset))
            {
                if(getPiece(y+yOffset, x+xOffset) == null) squareList.add(new Square(y+yOffset, x+xOffset));
                else{
                    if(getPiece(y+yOffset, x+xOffset).getPlayer() != currentPiece.getPlayer()) squareList.add(new Square(y+yOffset, x+xOffset));
                    clearPath = false;
                }
            }
            else clearPath = false;
            if(xOffset > 0) xOffset++;
            if(xOffset < 0) xOffset--;
            if(yOffset > 0) yOffset++;
            if(yOffset < 0) yOffset--;
        }
        
        return squareList;
    }
    
    public ArrayList<Square> queenMoves(int y, int x, Piece currentPiece)
    {
        ArrayList<Square> straightMoves = rookMoves(y, x, currentPiece);
        ArrayList<Square> diagonalMoves = bishopMoves(y, x, currentPiece);
        straightMoves.addAll(diagonalMoves);
        return straightMoves;
    }
    
    public ArrayList<Square> kingMoves(int y, int x, Piece currentPiece){
        
        ArrayList<Square> possibleSquares = new ArrayList();
        boardGrid.get(y).set(x, null);
        if(validSquare(y, x+1)){
            if(getPiece(y, x+1) == null || getPiece(y, x+1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y, x+1, currentPiece)) possibleSquares.add(new Square(y, x+1));
            }
        }
        if(validSquare(y, x-1)){
            if(getPiece(y, x-1) == null || getPiece(y, x-1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y, x-1, currentPiece)) possibleSquares.add(new Square(y, x-1));
            }
        }
        if(validSquare(y+1, x+1)){
            if(getPiece(y+1, x+1) == null || getPiece(y+1, x+1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y+1, x+1, currentPiece)) possibleSquares.add(new Square(y+1, x+1));
            }
        }
        if(validSquare(y+1, x-1)){
            if(getPiece(y+1, x-1) == null || getPiece(y+1, x-1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y+1, x-1, currentPiece)) possibleSquares.add(new Square(y+1, x-1));
            }
        }
        if(validSquare(y-1, x+1)){
            if(getPiece(y-1, x+1) == null || getPiece(y-1, x+1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y-1, x+1, currentPiece)) possibleSquares.add(new Square(y-1, x+1));
            }
        }
        if(validSquare(y-1, x-1)){
            if(getPiece(y-1, x-1) == null || getPiece(y-1, x-1).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y-1, x-1, currentPiece)) possibleSquares.add(new Square(y-1, x-1));
            }
        }
        if(validSquare(y+1, x)){
            if(getPiece(y+1, x) == null || getPiece(y+1, x).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y+1, x, currentPiece)) possibleSquares.add(new Square(y+1, x));
            }
        }
        if(validSquare(y-1, x)){
            if(getPiece(y-1, x) == null || getPiece(y-1, x).getPlayer() != currentPiece.getPlayer()){
                if(!isSquareInCheck(y-1, x, currentPiece)) possibleSquares.add(new Square(y-1, x));
            }
        }
        boardGrid.get(y).set(x, currentPiece);
        ArrayList<Square> castleSquares = castleSquares(currentPiece);
        if(castleSquares.size() != 0) possibleSquares.addAll(castleSquares);
        return possibleSquares;
    }
    
    ArrayList<Square> castleSquares(Piece currentPiece)
    {
        ArrayList<Square> squares = new ArrayList<>();
        if(currentPiece.getPlayer() == Player.WHITE)
        {
            if(!wKMoved && !wRHMoved && !isSquareInCheck(7, 4,currentPiece) && !isSquareInCheck(7, 5, currentPiece) && !isSquareInCheck(7, 6,currentPiece)
            && getPiece(7,5) == null && getPiece(7,6) == null && getPiece(7,7) != null && getPiece(7,7).getPlayer() == Player.WHITE) squares.add(new Square(7, 6, Castle.WH));
            if(!wKMoved && !wRAMoved && !isSquareInCheck(7, 4,currentPiece) && !isSquareInCheck(7, 3, currentPiece) && !isSquareInCheck(7, 2,currentPiece)
            && getPiece(7,1) == null && getPiece(7,2) == null && getPiece(7,3) == null  && getPiece(7,0) != null && getPiece(7,0).getPlayer() == Player.WHITE) squares.add(new Square(7, 2, Castle.WA));
        }
        if(currentPiece.getPlayer() == Player.BLACK)
        {
            if(!bKMoved && !bRAMoved && !isSquareInCheck(0, 4,currentPiece) && !isSquareInCheck(0, 3, currentPiece) && !isSquareInCheck(0, 2,currentPiece)
            && getPiece(0, 1) == null && getPiece(0,2) == null && getPiece(0,3) == null  && getPiece(0,7) != null && getPiece(0,7).getPlayer() == Player.BLACK) squares.add(new Square(0, 2, Castle.BA));
            if(!bKMoved && !bRHMoved && !isSquareInCheck(0, 4,currentPiece) && !isSquareInCheck(0, 5, currentPiece) && !isSquareInCheck(0, 6,currentPiece)
            && getPiece(0, 5) == null && getPiece(0,6) == null  && getPiece(0,0) != null && getPiece(0,0).getPlayer() == Player.BLACK) squares.add(new Square(0, 6, Castle.BH));
        }
        return squares;
    }
    
    static boolean validSquare(int y, int x)
    {
        return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }
    
    private boolean isSquareInCheck(int y, int x, Piece currentPiece)
    {
        if(straightLines(y, x, currentPiece)) return true;
        if(diagonalLines(y, x, currentPiece)) return true;
        if(adjacentKing(y, x, currentPiece)) return true;
        return attackingKnight(y, x, currentPiece);
    }
    
    private boolean attackingKnight(int y, int x, Piece currentPiece)
    {
        if(isEnemyKnight(y+2, x+1, currentPiece)) return true;
        if(isEnemyKnight(y+2, x-1, currentPiece)) return true;
        if(isEnemyKnight(y-2, x+1, currentPiece)) return true;
        if(isEnemyKnight(y-2, x-1, currentPiece)) return true;
        if(isEnemyKnight(y+1, x+2, currentPiece)) return true;
        if(isEnemyKnight(y+1, x-2, currentPiece)) return true;
        if(isEnemyKnight(y-1, x+2, currentPiece)) return true;
        return isEnemyKnight(y-1, x-2, currentPiece);
    }
    
    private boolean isEnemyKnight(int y, int x, Piece currentPiece)
    {
        if(validSquare(y,x) && getPiece(y, x) != null){
            if(getPiece(y, x).getType() == Type.KNIGHT && getPiece(y, x).getPlayer() != currentPiece.getPlayer()) return true;
        }
        return false;
    }
    
    private boolean adjacentKing(int y, int x, Piece currentPiece)
    {
        if(isEnemyKing(y+1,x,currentPiece)) return true;
        if(isEnemyKing(y+1,x+1,currentPiece)) return true;
        if(isEnemyKing(y,x+1,currentPiece)) return true;
        if(isEnemyKing(y-1,x+1,currentPiece)) return true;
        if(isEnemyKing(y-1,x,currentPiece)) return true;
        if(isEnemyKing(y-1,x-1,currentPiece)) return true;
        if(isEnemyKing(y,x-1,currentPiece)) return true;
        if(isEnemyKing(y+1,x-1,currentPiece)) return true;
        return false;
    }
    
    private boolean isEnemyKing(int y, int x, Piece currentPiece)
    {
        if(validSquare(y,x) && getPiece(y, x) != null){
            if(getPiece(y, x).getType() == Type.KING && getPiece(y, x).getPlayer() != currentPiece.getPlayer()) return true;
        }
        return false;
    }
    
    private boolean diagonalLines(int y, int x, Piece currentPiece)
    {
        if(diagonalLinesWorker(y+1, x+1, currentPiece, 1, 1)) return true;
        if(diagonalLinesWorker(y+1, x-1, currentPiece, 1, -1)) return true;
        if(diagonalLinesWorker(y-1, x+1, currentPiece, -1, 1)) return true;
        if(diagonalLinesWorker(y-1, x-1, currentPiece, -1, -1)) return true;
        return false;
    }
    
    private boolean diagonalLinesWorker(int y, int x, Piece currentPiece, int yOffset, int xOffset)
    {
        for(int i = 0; i < 7; ++i)
        {
            if(validSquare(y+i*yOffset,x+i*xOffset))
            {
                Piece p = getPiece(y+i*yOffset,x+i*xOffset);
                if(p != null)
                {
                    if(p.getPlayer() != currentPiece.getPlayer() && (p.getType() == Type.BISHOP || p.getType() == Type.QUEEN || 
                    (i == 0 && p.getType() == Type.PAWN && ((p.getPlayer() == Player.WHITE && yOffset > 0) || (p.getPlayer() == Player.BLACK && yOffset < 0))))) return true;
                    return false;
                }
            }
            else return false;
        }
        return false;
    }
    
    private boolean straightLines(int y, int x, Piece currentPiece)
    {
        if(straightLinesWorker(y, x+1, currentPiece, 0, 1)) return true;
        if(straightLinesWorker(y+1, x, currentPiece, 1, 0)) return true;
        if(straightLinesWorker(y, x-1, currentPiece, 0, -1)) return true;
        if(straightLinesWorker(y-1, x, currentPiece, -1, 0)) return true;
        
        return false;
    }
    
    private boolean straightLinesWorker(int y, int x, Piece currentPiece, int yOffset, int xOffset)
    {
        for(int i = 0; i < 7; ++i)
        {
            if(validSquare(y+i*yOffset, x+i*xOffset))
            {
                Piece p = getPiece(y+i*yOffset, x+i*xOffset);
                if(p != null)
                {
                    if(p.getPlayer() != currentPiece.getPlayer() && (p.getType() == Type.ROOK || p.getType() == Type.QUEEN)) return true;
                    return false;
                }
            }
            else return false;
        }
        return false;
    }
    
    private void setCastleStatus(Piece p, int y, int x)
    {
//        System.out.println("B.SCS : p.Y = " + p.getY() + " : p.X = " + p.getX() + " : y = " + y + ": x = " + x);
        if(p.getPlayer() == Player.WHITE && p.getType() == Type.ROOK && y == 7 && x == 0) wRAMoved = true;
        if(p.getPlayer() == Player.WHITE && p.getType() == Type.ROOK && y == 7 && x == 7) wRHMoved = true;
        if(p.getPlayer() == Player.WHITE && p.getType() == Type.KING && y == 7 && x == 4) wKMoved = true;
        if(p.getPlayer() == Player.BLACK && p.getType() == Type.ROOK && y == 0 && x == 0) bRAMoved = true;
        if(p.getPlayer() == Player.BLACK && p.getType() == Type.ROOK && y == 0 && x == 7) bRHMoved = true;
        if(p.getPlayer() == Player.BLACK && p.getType() == Type.KING && y == 0 && x == 4) bKMoved = true;
    }
    
    public boolean isWhiteCheckmate()
    {
        return whiteCheckmate;
    }
    
    public boolean isBlackCheckmate()
    {
        return blackCheckmate;
    }
    
    public boolean isStalemate()
    {
        return stalemate;
    }
    
    private void initPieces(){
        for(int k = 0; k < 8; k++)
        {
            boardGrid.add(new ArrayList<Piece>());
        }
        
        for(int i = 2; i < 6; ++i)
        {
            for(int j = 0; j < 8; j++)
            {
                boardGrid.get(i).add(null);
            }
        }
        
        boardGrid.get(0).add(new Rook(0,0,Player.BLACK));
        boardGrid.get(0).add(new Knight(0,1,Player.BLACK));
        boardGrid.get(0).add(new Bishop(0,2,Player.BLACK));
        boardGrid.get(0).add(new Queen(0,3,Player.BLACK));
        boardGrid.get(0).add(new King(0,4,Player.BLACK));
        boardGrid.get(0).add(new Bishop(0,5,Player.BLACK));
        boardGrid.get(0).add(new Knight(0,6,Player.BLACK));
        boardGrid.get(0).add(new Rook(0,7,Player.BLACK));
        
        boardGrid.get(1).add(new Pawn(1,0,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,1,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,2,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,3,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,4,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,5,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,6,Player.BLACK));
        boardGrid.get(1).add(new Pawn(1,7,Player.BLACK));
        
        boardGrid.get(6).add(new Pawn(6,0,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,1,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,2,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,3,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,4,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,5,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,6,Player.WHITE));
        boardGrid.get(6).add(new Pawn(6,7,Player.WHITE));
        
        boardGrid.get(7).add(new Rook(7,0,Player.WHITE));
        boardGrid.get(7).add(new Knight(7,1,Player.WHITE));
        boardGrid.get(7).add(new Bishop(7,2,Player.WHITE));
        boardGrid.get(7).add(new Queen(7,3,Player.WHITE));
        boardGrid.get(7).add(new King(7,4,Player.WHITE));
        boardGrid.get(7).add(new Bishop(7,5,Player.WHITE));
        boardGrid.get(7).add(new Knight(7,6,Player.WHITE));
        boardGrid.get(7).add(new Rook(7,7,Player.WHITE));
    }
    
    private void initEnPass()
    {
        wEnPass = new ArrayList<>();
        bEnPass = new ArrayList<>();
        for(int i = 0; i < 8; i++)
        {
            wEnPass.add(-1);
            bEnPass.add(-1);
        }
    }
    
    public int getTurnCounter()
    {
        return turnCounter;
    }
    // my own work
}
