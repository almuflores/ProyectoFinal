/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import Controlador.*;
import Conexion.*;
import java.awt.event.ActionEvent;
        
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author almudenaflores
 */
public class ControladorPeliculas implements ActionListener, MouseListener{
    
    /**
     * Instancia a nuestra interfaz de usuario
     */
    JFPeliculas jfPeliculas;
    /**
     * Instancia a nuestro modelo
     */
    PeliculasDAO pelDAO=new PeliculasDAO();

    @Override
    public void mousePressed(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum Accion{
        atras,
        guardar,
        listar,
        asociar,
        modificar,
        eliminar,
        buscar,
    }
    /**
     * Constructor de la clase
     * @param jfPeliculas
     */
    public ControladorPeliculas(JFPeliculas jfPeliculas){
        this.jfPeliculas=jfPeliculas;
    }
    
    public void iniciar()
    {

        //declara una acción y añade un escucha al evento producido por el componente
        this.jfPeliculas.btnGuardar.setActionCommand( "guardar" );
        this.jfPeliculas.btnGuardar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfPeliculas.btnAsociar.setActionCommand( "asociar" );
        this.jfPeliculas.btnAsociar.addActionListener(this);
        //declara una acción y añade un escucha al evento producido por el componente
        this.jfPeliculas.btnAtras.setActionCommand( "atras" );
        this.jfPeliculas.btnAtras.addActionListener(this);

        this.jfPeliculas.btnListar.setActionCommand( "listar" );
        this.jfPeliculas.btnListar.addActionListener(this);
        
        this.jfPeliculas.btnModificar.setActionCommand( "modificar" );
        this.jfPeliculas.btnModificar.addActionListener(this);
        
        this.jfPeliculas.btnEliminar.setActionCommand( "eliminar" );
        this.jfPeliculas.btnEliminar.addActionListener(this);
        //añade e inicia el jtable con un DefaultTableModel vacio
        this.jfPeliculas.jTable1.addMouseListener(this);
        this.jfPeliculas.jTable1.setModel( new DefaultTableModel() );
        
        this.jfPeliculas.btnBuscar.setActionCommand( "buscar" );
        this.jfPeliculas.btnBuscar.addActionListener(this);
    }
        //Eventos que suceden por el mouse
    public void mouseClicked(MouseEvent e) {
        if( e.getButton()== 1)//boton izquierdo
        {
             int fila = this.jfPeliculas.jTable1.rowAtPoint(e.getPoint());
             if (fila > -1){                
                this.jfPeliculas.txtTitulo.setText( String.valueOf( this.jfPeliculas.jTable1.getValueAt(fila, 0) ));
                this.jfPeliculas.txtAño.setText( String.valueOf( this.jfPeliculas.jTable1.getValueAt(fila, 1) ));
                this.jfPeliculas.txtDuracion.setText( String.valueOf( this.jfPeliculas.jTable1.getValueAt(fila, 2) ));
                this.jfPeliculas.txtResumen.setText( String.valueOf( this.jfPeliculas.jTable1.getValueAt(fila, 3) ));
             }
        }
    }
    
    public void actionPerformed(ActionEvent e) {

    switch ( Accion.valueOf( e.getActionCommand() ) ){
            case listar:
                /*obtiene del modelo los registros en un DefaultTableModel y lo asigna en la vista*/
                this.jfPeliculas.jTable1.setModel( this.pelDAO.getTablaPeliculas() );
                break;
                
            case guardar:
                //añade una nueva pelicula
               
                if ( this.pelDAO.registrar(
                      
                        this.jfPeliculas.txtTitulo.getText(),
                        this.jfPeliculas.txtAño.getText(),
                        this.jfPeliculas.txtDuracion.getText(),
                        this.jfPeliculas.txtResumen.getText() ) )
                {
                    this.jfPeliculas.jTable1.setModel( this.pelDAO.getTablaPeliculas() );
                    JOptionPane.showMessageDialog(jfPeliculas,"Exito: Nuevo registro agregado.");
                    this.jfPeliculas.txtTitulo.setText("");
                    this.jfPeliculas.txtAño.setText("") ;
                    this.jfPeliculas.txtDuracion.setText("");
                    this.jfPeliculas.txtResumen.setText("") ;
                }
                else //ocurrio un error
                    JOptionPane.showMessageDialog(jfPeliculas,"Error: Los datos son incorrectos.");
                break;
            case atras:
                jfPeliculas.dispose();
                Inicio inic=new Inicio();
                ControladorInicio inicio=new ControladorInicio(inic);
                inicio.iniciar();
                inic.setVisible(true);
                inic.setLocationRelativeTo(null);
                break;
            case eliminar:
                
                if ( this.pelDAO.EliminarPelicula(this.jfPeliculas.txtID.getText()) )
                {
                    this.jfPeliculas.jTable1.setModel( this.pelDAO.getTablaPeliculas() );
                    JOptionPane.showMessageDialog(jfPeliculas,"Exito: Registro eliminado.");
                    //dejamos los campos vacíos
                    this.jfPeliculas.txtTitulo.setText("");
                    this.jfPeliculas.txtAño.setText("") ;
                    this.jfPeliculas.txtDuracion.setText("");
                    this.jfPeliculas.txtResumen.setText("") ;
                }
                break; 
                
            case modificar:
                //se modifica con los datos metidos
               
                if ( this.pelDAO.modificarP(
                        this.jfPeliculas.txtID.getText()
                        ))
                {
                    this.jfPeliculas.jTable1.setModel( this.pelDAO.getTablaPeliculas() );
                    JOptionPane.showMessageDialog(jfPeliculas,"Exito: Pelicula modificada");
                    this.jfPeliculas.txtTitulo.setText("");
                    this.jfPeliculas.txtAño.setText("") ;
                    this.jfPeliculas.txtDuracion.setText("");
                    this.jfPeliculas.txtResumen.setText("") ;
                }
                else 
                    //panel de error
                    JOptionPane.showMessageDialog(jfPeliculas,"Error: No existe la película.");
                break;
            case buscar:
                if(this.pelDAO.buscar(this.jfPeliculas.txtID.getText())){
                    
                    JOptionPane.showMessageDialog(null, "Exito");
                    
                }
                break;
        }
    }
}
