
/*

This is Cell class which works as basic cell container 
The Cell role is to hold a number or a bomb
The Cell is initially unexposed but it can be exposed during the game 
The Cell value depending on how many if the surrounding cells are bombs 

*/



package myminesweeper;


public class Cell {
    
    /*
Cell Class contain the basic needed fields that is common between all the cells 
    and simple consturctor , Setters and Getters 
    increament method for increamenting the cell depending on the surrounding cells 

*/
    
    private boolean isBomb ; 
    private boolean isExposed;
    private int cellValue ; 

    public Cell() {
        cellValue = 0 ;
        isBomb=false ; 
        isExposed=false ;
    }
    
   public void incCellValue (){
   cellValue ++ ; 
   } 

    public boolean isBomb() {
        return isBomb;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public int getCellValue() {
        return cellValue;
    }

    public void setIsBomb() {
        this.isBomb = true;
        cellValue = -1 ;
    }


    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public void setIsExposed() {
        this.isExposed = true;
    }
   
    
   
}
