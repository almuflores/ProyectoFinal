/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Modelo.*;
import Vista.*;
import Controlador.*;
/**
 *
 * @author almudenaflores
 */
public class Main {
    
    
    public static void main(String [] args){
         
        
        Inicio inic=new Inicio();
        ControladorInicio cI=new ControladorInicio(inic);
        
        cI.iniciar();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
       
        
    }
}
