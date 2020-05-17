/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import Controlador.*;
import static Modelo.Conexion.getConexion;
import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author almudenaflores
 */



public class ControladorActores implements ActionListener{
    /**
     * Instancia a nuestra interfaz de usuario
     */
    JFActores jfActores;
    /**
     * Instancia a nuestro modelo
     */
    ActoresDAO actoresDAO=new ActoresDAO();
    
   // Inicio inicio;
    /**
     * 
     * @param e 
     
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public enum Accion{
        guardar,
        listar,
        asociar,
        modificar,
        atras,
        eliminar,
        buscar,
    }
    
   /**
    * Constructor de la clase
     * @param jfActores
    */
    public ControladorActores(JFActores jfActores){
        this.jfActores=jfActores;
    }
    
    public void iniciar(){
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfActores.btnGuardar.setActionCommand("guardar");
        this.jfActores.btnGuardar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfActores.btnListar.setActionCommand("listar");
        this.jfActores.btnListar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfActores.btnModificar.setActionCommand("modificar");
        this.jfActores.btnModificar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfActores.btnAsociar.setActionCommand("asociar");
        this.jfActores.btnAsociar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfActores.btnAtras.setActionCommand("atras");
        this.jfActores.btnAtras.addActionListener(this);
        
        this.jfActores.btnBuscar.setActionCommand("buscar");
        this.jfActores.btnBuscar.addActionListener(this);
        
        this.jfActores.btnEliminar.setActionCommand("eliminar");
        this.jfActores.btnEliminar.addActionListener(this);

        //añade e inicia el jtable con un DefaultTableModel vacio
        //this.jfActores.jTable.addMouseListener((MouseListener) this);
        //this.jfActores.jTable.setModel( new DefaultTableModel() );
        
    }
    
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.jfActores.jTable.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.jfActores.txtNombre.setText( String.valueOf( this.jfActores.jTable.getValueAt(fila, 0) ));
                this.jfActores.txtApellidos.setText( String.valueOf( this.jfActores.jTable.getValueAt(fila, 1) ));
                this.jfActores.txtAño.setText( String.valueOf( this.jfActores.jTable.getValueAt(fila, 2) ));
                this.jfActores.txtNacionalidad.setText( String.valueOf( this.jfActores.jTable.getValueAt(fila, 3) ));
             }
        }
    }
    
   
    
    
    public void actionPerformed(ActionEvent e){
        switch ( Accion.valueOf( e.getActionCommand() ) ){
            case guardar:
                iniciar();
               
                
              //añade un nuevo registro
            
            if ( this.actoresDAO.registrar(
                    this.jfActores.txtNombre.getText(),
                    this.jfActores.txtApellidos.getText() ,
                    this.jfActores.txtAño.getText(),
                    this.jfActores.txtNacionalidad.getText() ) )
            {
                this.jfActores.jTable.setModel( this.actoresDAO.getTablaActores() );
                    JOptionPane.showMessageDialog(jfActores,"Exito: Nuevo registro agregado.");
                    this.jfActores.txtNombre.setText("");
                    this.jfActores.txtApellidos.setText("") ;
                    this.jfActores.txtAño.setText("");
                    this.jfActores.txtNacionalidad.setText("") ;
            }else //ocurrio un error
                JOptionPane.showMessageDialog(jfActores,"Error: Los datos son incorrectos.");
            break;
                
            case listar:
                this.jfActores.jTable.setModel( this.actoresDAO.getTablaActores() );
                break;
            
            case atras:
                jfActores.dispose();
                Inicio inic=new Inicio();
                ControladorInicio inicio=new ControladorInicio(inic);
                inicio.iniciar();
                inic.setVisible(true);
                inic.setLocationRelativeTo(null);
               break;
            case eliminar:
                if ( this.actoresDAO.EliminarActor(this.jfActores.txtId.getText()) )
                {
                    this.jfActores.jTable.setModel( this.actoresDAO.getTablaActores() );
                    JOptionPane.showMessageDialog(jfActores,"Exito: Registro eliminado.");
                    this.jfActores.txtNombre.setText("");
                    this.jfActores.txtApellidos.setText("") ;
                    this.jfActores.txtAño.setText("");
                    this.jfActores.txtNacionalidad.setText("") ;
                }
                break; 
                
            case buscar:
                this.actoresDAO.buscar(this.jfActores.txtAño.getText());
                break;
        }
                
        
    }
        
}
