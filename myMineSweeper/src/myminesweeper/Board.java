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
public class Board {

    private Cell boardCells[][];
    private int boardRows;
    private int boardColumns;
    private int bombNumber;
    private int remainingUnexposedCells;

    public Board(int r, int c, int b) {
        boardRows = r;
        boardColumns = c;
        bombNumber = b;
        remainingUnexposedCells = r * c;
        InitiateCells();
    }

    private void InitiateCells() {

        boardCells = new Cell[boardRows][boardColumns];
        for (int x = 0; x < boardRows; x++) {

            for (int y = 0; y < boardColumns; y++) {

                boardCells[x][y] = new Cell();

            }
        }

    }

    public void printBoardDemo() {
        System.out.print("   ");
        for (int x = 0; x < boardColumns; x++) {
            System.out.print("(" + x + ")");
        }
        System.out.print("\n");

        for (int x = 0; x < boardRows; x++) {
            System.out.print("(" + x + ")");
            for (int y = 0; y < boardColumns; y++) {

                if (boardCells[x][y].isExposed() == true) {
                    if (boardCells[x][y].isBomb() == true) {
                        System.out.print(" " + "*" + " ");
                    } else if (boardCells[x][y].getCellValue() == 0) {

                        System.out.print(" " + " " + " ");
                    } else {
                        System.out.print(" " + boardCells[x][y].getCellValue() + " ");
                    }

                } else {
                    System.out.print(" X ");
                }
            }
            System.out.print("\n");
        }

    }

    public void printBoardValues() {
        System.out.print("   ");
        for (int x = 0; x < boardColumns; x++) {
            System.out.print("(" + x + ")");
        }
        System.out.print("\n");

        for (int x = 0; x < boardRows; x++) {
            System.out.print("(" + x + ")");
            for (int y = 0; y < boardColumns; y++) {

                if (boardCells[x][y].isBomb() == true) {
                    System.out.print(" " + "*" + " ");
                } else if (boardCells[x][y].getCellValue() == 0) {

                    System.out.print(" " + " " + " ");
                } else {
                    System.out.print(" " + boardCells[x][y].getCellValue() + " ");

                }

            }
            System.out.print("\n");
        }

    }

    public void settingBombs() {
        for (int x = 0; x < bombNumber; x++) {

            int randomRow = (int) Math.round(Math.random() * (boardRows - 1));
            int randomCol = (int) Math.round(Math.random() * (boardColumns - 1));

            if (boardCells[randomRow][randomCol].isBomb() == false) {
                boardCells[randomRow][randomCol].setIsBomb();
            } else {
                x--;
            }

        }

    }

    public void settingSurroundingCellsValues() {

        for (int x = 0; x < boardRows; x++) {

            for (int y = 0; y < boardColumns; y++) {

                if (boardCells[x][y].isBomb() == true) {

                    for (int j = x - 1; j <= x + 1; j++) {

                        for (int k = y - 1; k <= y + 1; k++) {

                            if (j >= 0 && k >= 0 && j < boardRows && k < boardColumns) {
                                boardCells[j][k].incCellValue();

                            }

                        }
                    }

                }
            }
        }

    }

    public void exposeCertainCell(int r, int c) {
        boardCells[r][c].setIsExposed();
    }

    public void calcRemainingUnexposedCells() {
        int unExposedCells = 0;
        for (int x = 0; x < boardRows; x++) {
            for (int y = 0; y < boardColumns; y++) {
                if (boardCells[x][y].isExposed() == true) {
                    unExposedCells++;
                }
            }
        }

        remainingUnexposedCells = boardRows * boardColumns - unExposedCells;

    }

    public Cell getBoardCell(int r, int c) {
        return boardCells[r][c];
    }

    public int getRemainingUnexposedCells() {
        if (remainingUnexposedCells < 0) {
            remainingUnexposedCells = 0;
        }
        return remainingUnexposedCells;
    }

    public int getBombNumber() {
        return bombNumber;
    }

    public void ExpandingSurrZeros(int currentRow, int currentColumn) {

        for (int j = currentRow - 1; j <= currentRow + 1; j++) {

            for (int k = currentColumn - 1; k <= currentColumn + 1; k++) {

                if (j >= 0 && k >= 0 && j < boardRows && k < boardColumns) {

                    if (boardCells[j][k].getCellValue() == 0) {

                        boardCells[j][k].setIsExposed();

                    }
                }

            }

        }

    }

    public int getBoardRows() {
        return boardRows;
    }

    public int getBoardColumns() {
        return boardColumns;
    }
    
    
    
    
    
    

}
