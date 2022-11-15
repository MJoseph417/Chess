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
public interface BoardAction {
    // my own work
    Piece getPiece(int y, int x);
    Player whoseTurn();
    // end of my own work
}
