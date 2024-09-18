/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.x0game;

/**
 *
 * @author Moatasem
 */
public class Board implements BoardInterface{
    char [][]arr;

    public Board() {
        this.arr = new char[][]{{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    }
    
    public int getRow(int ind){
        return (ind - 1) / 3; 
    }
    public int getCol(int ind){
        return (ind - 1) % 3; 
    }
    
    public boolean isEmp(int ind){
        if (ind < 1 || ind > 9 )return false;
            
        int r = getRow(ind);
        int c= getCol(ind);
        
        if(arr[r][c] == 'x' || arr[r][c] == 'o')
            return false;
        
        return true;
    }
    
    public boolean repChar(int ind, Player p){
        if (isEmp(ind)) {
          int r = getRow(ind);
          int c= getCol(ind);
          
          arr[r][c] = p.getOp();
          return true;
        }
        return false;
    }
    
    public void draw(){
        for(int i = 0; i < 3; i++ ){
            System.out.println("-----------------");
            for(int j = 0; j< 3; j++){
                System.out.print(" | " + arr[i][j] + " ");
            }
            System.out.println(" | ");
        }
            System.out.println("-----------------");
    }
    
    public boolean isFull(){
        int count = 0;
        for(int i = 1; i <=9; i++){
            if (isEmp(i)) {
                count++;
            }
        }
         if (count == 0)return true;
         return false;  
    }
    
    @Override
    public boolean isWin(Player p){
        if(arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] ) 
            return true;
        if(arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] ) 
            return true;
        if(arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] ) 
           return true;
         if(arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] ) 
            return true;
        if(arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] ) 
            return true;
        if(arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] ) 
            return true;
        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] ) 
            return true;
        if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] ) 
            return true;
        
        return false;
    }
}
