/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mjs2w6chessf21;

/**
 *
 * @author matthewschutz
 */
public class Rook extends Piece{
    // my own work
    Type type;
    
    public Rook(int y, int x, Player player){
        super(y, x, player);
        type = Type.ROOK;
    }
    
    @Override
    public Type getType(){
        return Type.ROOK;
    }
    // end of own work
}
