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
public class Square {
    // my own work
    int x, y;
    Castle castle;
    
    public Square(int y, int x){
        this.x = x;
        this.y = y;
        castle = Castle.NONE;
    }
    
    public Square(int x, int y, Castle castle){
        this(x, y);
        this.castle = castle;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public Castle getCastleType(){
        return castle;
    }
    // end of own work
}
