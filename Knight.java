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
public class Knight extends Piece {
    
    // my own work
    Type type;
    
    public Knight(int y, int x, Player player){
        super(y, x, player);
        type = Type.KNIGHT;
    }
    
    @Override
    public Type getType(){
        return Type.KNIGHT;
    }
    // end of own work
}
