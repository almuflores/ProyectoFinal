/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import static Conexion.prueba.CONTRASEÑA;
import static Conexion.prueba.URL;
import static Conexion.prueba.USERNAME;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;


/**
 *
 * @author almudenaflores
 */

public class Conexion{
    
    
     /**
     * URL de la base de datos
     */
    public static final String URL="jdbc:mysql://79.148.236.236:3306/aflores_Proyecto?noAccessToProcedureBodies=true";
    public static final String USERNAME="aflores";
    public static final String CONTRASEÑA="Nervion1**";
    
    private void Conexion(){ 
     try {
           java.sql.Connection con=null; 
             getConexion();
             
             PreparedStatement ps;
             ResultSet rs;
             ps=con.prepareStatement("SELECT * FROM Actores");
             rs=ps.executeQuery();
             
             if(rs.next()){
                 JOptionPane.showMessageDialog(null, rs.getString("Nombre")+" "+ rs.getString("Apellidos")+ " " + rs.getString("Año de nacimiento")+" "+rs.getString("Nacionalidad"));
             }else{
                 JOptionPane.showMessageDialog(null, "No hay datos");
             }
             con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }                                       

    /**
     *
     */
    public static Connection getConexion(){
        java.sql.Connection con=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL, USERNAME, CONTRASEÑA);
            //JOptionPane.showMessageDialog(null, "Conectado");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return (Connection) con;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
  private void Conexion(){                                        
        try {
           java.sql.Connection con=null; 
             getConexion();
             
             PreparedStatement ps;
             ResultSet rs;
             ps=con.prepareStatement("SELECT * FROM Actores");
             rs=ps.executeQuery();
             
             if(rs.next()){
                 JOptionPane.showMessageDialog(null, rs.getString("Nombre")+" "+ rs.getString("Apellidos")+ " " + rs.getString("Año de nacimiento")+" "+rs.getString("Nacionalidad"));
             }else{
                 JOptionPane.showMessageDialog(null, "No hay datos");
             }
             con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
  }  
    
    public static Connection getConexion(){
        Connection con=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection(URL, USERNAME, CONTRASEÑA);
            //JOptionPane.showMessageDialog(null, "Conectado");
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
         
   
   
    




    public static void main(String[] args ){
        Conexion con=new Conexion();
        
    }
*/
}

