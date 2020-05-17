/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.event.*;
import Controlador.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author almudenaflores
 */
public class ControladorInicio implements ActionListener{
    
    Inicio inicio;
    JFActores jfActores;
    JFPeliculas jfPeliculas;
    //ActoresDAO actDAO;
   
    public enum Accion{
        actores,
        peliculas,
        salir,
    }
    public ControladorInicio(Inicio inicio){
        this.inicio=inicio;
        
    }
    
    public void iniciar(){
        this.inicio.irActores.setActionCommand( "actores" );
        this.inicio.irActores.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.inicio.btnSalir.setActionCommand( "salir" );
        this.inicio.btnSalir.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.inicio.irPeliculas.setActionCommand( "peliculas" );
        this.inicio.irPeliculas.addActionListener(this);

        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==inicio.irActores){
            //iniciamos el JF de Actores
            jfActores=new JFActores();
            ControladorActores contA=new ControladorActores(jfActores);
            contA.iniciar();
            jfActores.setVisible(true);
            jfActores.setLocationRelativeTo(inicio);
            inicio.dispose();
        }
        else if(e.getSource()==inicio.btnSalir){
            //cerramos la pantalla
            inicio.dispose();
        }
        else if(e.getSource()==inicio.irPeliculas){
            //iniciamos el JF de Peliculas
           jfPeliculas=new JFPeliculas();
           ControladorPeliculas contP=new ControladorPeliculas(jfPeliculas);
           contP.iniciar();
            jfPeliculas.setVisible(true);
            jfPeliculas.setLocationRelativeTo(inicio);
            inicio.dispose();
            
        
        }
    }

    
    
    
}
