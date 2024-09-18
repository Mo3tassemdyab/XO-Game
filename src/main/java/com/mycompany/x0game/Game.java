/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.x0game;

import java.util.Scanner;


public class Game {
    private Board b = new Board();
    private Player p1 = new Player();
    private Player p2 = new Player();
    private int count = 0;
    Scanner cin = new Scanner(System.in);
    
    public void readPlayerData(){
        System.out.println("Enter P1 Name: ");
        String n = cin.next();
        p1.setName(n);
        
        System.out.println("Enter P1 Op: ");
        char op = cin.next().charAt(0);
        p1.setOp(op);
        
         System.out.println("Enter P2 Name: ");
         n = cin.next();
         p2.setName(n);


         if (p1.getOp() == 'x') 
            p2.setOp('o');
         else
            p2.setOp('x');
    
         System.out.println("P2 op is = " + p2.getOp());
    }
    
    public void play(){
        
        readPlayerData();
        b.draw();
        
        while(!b.isFull()){
            Player cp = p1;
            if (count % 2 == 1) cp = p2;
             
            while (true) {                
                int pos;
                System.out.println("Enter a pos 1:9 :");
                pos= cin.nextInt();
                if (b.repChar(pos, cp))
                    break; 
            }
            
            b.draw();
            
            if (b.isWin(cp)){
                System.out.println("Winner is " + cp.getName());
                break;
            }
              
            count++;
        }
        if (b.isFull()) {
            System.out.println("Game is Draw");
        }
        
    }
    
    
    

}
