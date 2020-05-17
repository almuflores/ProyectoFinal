/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Modelo.*;
import Vista.*;
import com.mysql.jdbc.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author almudenaflores
 */
public class PeliculasDAO extends Conexion{
    public PeliculasDAO(){}
    
    
    public DefaultTableModel getTablaPeliculas()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      
      int registros = 0;
      String[] columNames = {"id_peliculas","Título","Año","Duración","Resumen"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = Conexion.getConexion().prepareStatement( "SELECT count(*) as total FROM Películas");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][5];
      try{
          //realizamos la consulta sql y llenamos los datos en la matriz "Object[][] data"
         PreparedStatement pstm = Conexion.getConexion().prepareStatement("SELECT * FROM Películas");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "id_peliculas" );
                data[i][1] = res.getString( "Titulo" );
                data[i][2] = res.getString( "Año" );
                data[i][3] = res.getString( "Duración" );
                data[i][4] = res.getString( "Resumen" );
            i++;
         }
         res.close();
         //se añade la matriz de datos en el DefaultTableModel
         tablemodel.setDataVector(data, columNames );
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return tablemodel;
    }
    
        /** Registra un nuevo producto */
    public boolean registrar(String titulo, String año , String duracion, String resumen)
    {
        if( valida_datos(titulo, año, duracion, resumen)  )
        {
            //se reemplaza "," por "."
            duracion = duracion.replace(",", ".");
            //Creamos la consulta
            String q=" INSERT INTO Películas ( Titulo , Año , Duración, Resumen  ) "
                    + "VALUES ( '" + titulo + "','" + año + "', '" + duracion + "','" + resumen + "' ) ";
            //se ejecuta la consulta
            try {
                try (PreparedStatement pstm = Conexion.getConexion().prepareStatement(q)) {
                    pstm.execute();
                }
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }
        else
         return false;
    }

/** Elimina un registro dado su ID*/
    public boolean EliminarPelicula( String id_peliculas )
    {
         boolean res=false;
        //se arma la consulta
        String q = "DELETE FROM `Películas` WHERE `Películas`.`id_peliculas` = "+ id_peliculas+"";
        
        //se ejecuta la consulta
         try {
            PreparedStatement pstm = Conexion.getConexion().prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){
            System.err.println( e.getMessage() );
        }
        return res;
    }

    /** Metodo para validar datos */
    private boolean valida_datos(String titulo, String año , String duracion, String resumen)
    {
        if(titulo.length() > 0 && resumen.length() >0)
        {
            return true;
        }
        else  return false;
    }
    /**
     * Metodo para buscar películas mediante su ID
     * @param id_peliculas
     * @return 
     */
    public boolean buscar(String id_peliculas){
        Conexion con=new Conexion();
        
        JFPeliculas jfP=new JFPeliculas();
        PreparedStatement ps;
        ResultSet res = null;
        
        try {
           //hacemos la conexión y la consulta en la que selccionamos los datos del id que metamos
            ps=Conexion.getConexion().prepareStatement("SELECT * FROM Películas WHERE id_peliculas=? ");
            ps.setString(1,jfP.txtID.getText()); 
           String p=jfP.txtID.getText();
            
            res=ps.executeQuery();
            
            if(res.next()){
                
                //JOptionPane.showMessageDialog(null, "n");
                JOptionPane.showMessageDialog(null, p);
                jfP.txtTitulo.setText(res.getString("Titulo"));
                jfP.txtAño.setText(res.getString("Año"));
                jfP.txtDuracion.setText(res.getString("Duración"));
                jfP.txtResumen.setText(res.getString("Resumen"));
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Error al buscar.");
            }
                
        }catch(SQLException e){
            return false;
        }
        return false;
    }
    /**
     * método para modificar peliculas
     * @param id_peliculas
     * @return 
     */
    public boolean modificarP(String id_peliculas){
        
        Conexion con=new Conexion();
        Connection con1=null;
        JFPeliculas jfP=new JFPeliculas();
        
        try {
            con1=getConexion();
            //creamos la consulta
            PreparedStatement ps=con1.prepareStatement("UPDATE Película SET Titulo=?, Año=?, Duración=?, Resumen=?");
            ps.setString(1, jfP.txtTitulo.getText());
            ps.setString(2, jfP.txtTitulo.getText());
            ps.setString(3, jfP.txtTitulo.getText());
            ps.setString(4, jfP.txtTitulo.getText());
            
            int res=ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            return false;
        }
           
        
       
    }
    
}
