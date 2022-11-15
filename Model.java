/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjs2w6chessf21;

import java.util.ArrayList;

/**
 *
 * @author matthewschutz
 */
public class Model {
    
    // my own work
    public Board board;
    private Piece currentPiece;
    boolean wKingCaptured;
    boolean bKingCaptured;
    
    public Model(){
        
        board = new Board();
        wKingCaptured = false;
        bKingCaptured = false;
        
    }
    
    public boolean isSquareOccupied(int y, int x)
    {
        if(board.getPiece(y, x) == null) return false;
        return true;
    }
    
    public Player getPlayer(int y, int x){
        return board.getPiece(y, x).getPlayer();
    }
    
    public Type movePiece(Square newSquare){
        Piece piece = currentPiece;
        piece = board.movePiece(piece.getY(), piece.getX(), newSquare.getY(), newSquare.getX(), newSquare.getCastleType());
        board.incTurn();
        return piece.getType();
    }
    
    public boolean wKingCaptured(){
        return wKingCaptured;
    }
    
    public boolean bKingCaptured(){
        return bKingCaptured;
    }
    
    public ArrayList<Square> pieceClicked(int y, int x){
        ArrayList<Square> moves = null;
        currentPiece = board.getPiece(y, x);
        if(currentPiece != null){
            if(currentPiece.getPlayer() != board.whoseTurn()) return null;
            moves = board.getMoves(currentPiece);
        }
        return moves;
    }
    
    public boolean whiteCheckmate()
    {
        return board.isWhiteCheckmate();
    }
    
    public boolean blackCheckmate()
    {
        return board.isBlackCheckmate();
    }
    
    public boolean isStalemate()
    {
        return board.isStalemate();
    }
    
    public boolean isEnPass()
    {
        return board.lastEnPass +1 == board.getTurnCounter();
    }
    
    public boolean isUpgrade()
    {
        return board.getTurnCounter() == board.lastUpgrade + 1;
    }
    
    public int enPassOffset()
    {
        if(board.getTurnCounter() %2 == 1)
        {
            return 1;
        }
        return -1;
    }
    // end of own work
}
