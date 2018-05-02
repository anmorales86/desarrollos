/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 * Clase del director
 * 
 * @author ANDERSON
 */
public class Director extends Employee
{
    
    /**
     * Metodo constructor
     * 
     * @param nombre    Nombre de la persona
     * @param cargo     Cargo que tiene la persona
     * @param ocupado   Si la persona esta ocupada o no
     */
    public Director(String nombre, String cargo, boolean ocupado) { 
        super(nombre,cargo, ocupado);
        
    }
    
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCargo(String cargo) {
        super.setCargo(cargo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCargo() {
        return super.getCargo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOcupado(boolean ocupado) {
        super.setOcupado(ocupado); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOcupado() {
        return super.isOcupado(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
}
