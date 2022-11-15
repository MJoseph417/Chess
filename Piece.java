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
public abstract class Piece {
    
    // my own work
    private int x, y;
    private Player player; 
    
    
    public Piece(int y, int x, Player player){
        this.x = x;
        this.y = y;
        this.player = player;
    }
    
    public Player getPlayer(){
        return player;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public abstract Type getType();
    // end of own work
}
