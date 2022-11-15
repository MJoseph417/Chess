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
public class Queen extends Piece{
    // my own work
    Type type;
    
    public Queen(int y, int x, Player player){
        super(y, x, player);
        type = Type.QUEEN;
    }
    
    @Override
    public Type getType(){
        return Type.QUEEN;
    }
    // end of own work
}
