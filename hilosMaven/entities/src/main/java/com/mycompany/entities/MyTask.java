/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author ANDERSON
 */
public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Inicio");
        
        System.out.println("Termino");
    }
    
}
