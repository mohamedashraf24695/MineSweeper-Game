/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.util.Scanner;

/**
 *
 * @author montaser
 */
public class Game {
    
    private boolean gameContinuity ; 
    private Board gameBoard ; 

    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
        gameContinuity = true ;
        gameBoard.settingBombs();
        gameBoard.settingSurroundingCellsValues();
    }
    
    private void onePlay(){
    
            Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Your play as row,column "); 
 int inputRow ; 
 int inputColumn ; 
        
        try{
         String input = scanner.nextLine();
    String [] parts = input.split(",");
     inputRow=Integer.parseInt(parts[0]);
     inputColumn=Integer.parseInt(parts[1]);
        
        
        }
        catch (Exception e) {
		inputRow = -1 ;
                inputColumn=-1;
		}
        
        
   

    gameRunning(inputRow,inputColumn);
    
    }
   
   
    private void  gameRunning(int inputRow , int inputColumn ){
    
        if( inputRow == -1 || inputColumn ==-1 ||inputRow > gameBoard.getBoardRows()-1 ||inputColumn>gameBoard.getBoardColumns()-1 ){
                System.out.println("Enter Valid row and column format like below "); 
                 System.out.println("for example: 2,2");

        }
        else {
        
        gameBoard.exposeCertainCell(inputRow, inputColumn);
    
    if(gameBoard.getBoardCell(inputRow, inputColumn).isBomb() == true){
        
    gameContinuity = false ;
        gameBoard.getBoardCell(inputRow, inputColumn).setIsExposed();

    
    } 
    
    else if(gameBoard.getBoardCell(inputRow, inputColumn).getCellValue() == 0) {
           gameBoard.getBoardCell(inputRow, inputColumn).setIsExposed();
          gameBoard.ExpandingSurrZeros(inputRow, inputColumn);
    
    }
    
    else {
    gameBoard.getBoardCell(inputRow, inputColumn).setIsExposed();
    }
    
    gameBoard.calcRemainingUnexposedCells();
    
    gameBoard.printBoardDemo();
        }
        
    
    
    }
    
    
    public void GamePlay(){
    
    while(gameContinuity==true && gameBoard.getRemainingUnexposedCells() > gameBoard.getBombNumber()){
    
    onePlay();
    System.out.println("The number of Rem. Cells is :"+gameBoard.getRemainingUnexposedCells());
    System.out.println("The number of Rem. Bombs is :"+gameBoard.getBombNumber());

    if(gameContinuity == false){
    System.out.println("Game Over !");
    gameBoard.printBoardValues();

    }
    if(gameBoard.getRemainingUnexposedCells()==gameBoard.getBombNumber()){
    System.out.println("You Win the game!");
    }
    
    }
        
        
    }
    
}
