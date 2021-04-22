/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

/**
 *
 * @author montaser
 */
public class MyMineSweeper {

    public static void main(String[] args) {

        Board gameBoard = new Board(100, 100, 500);

        Game newGame = new Game(gameBoard);
        gameBoard.printBoardValues();

        newGame.GamePlay();
    }

}
