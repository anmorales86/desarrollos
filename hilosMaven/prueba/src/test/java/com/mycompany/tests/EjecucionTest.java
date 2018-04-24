/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tests;

import com.mycompany.service.Proceso;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author ANDERSON
 */
public class EjecucionTest extends TestCase {
    
    private Proceso proceso;
    
    public EjecucionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    
    public void testLlamadasMas10() {
        try {
            proceso = new Proceso();
            int numeroLlamadas = 20;
            int cantOperador = 6;
            int cantSupervisor = 3;
            int cantDirector = 1;
            proceso.llamarProceso(numeroLlamadas,
                                  cantOperador,
                                  cantSupervisor,
                                  cantDirector);
        } catch (Exception ex) {
            Logger.getLogger(EjecucionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
