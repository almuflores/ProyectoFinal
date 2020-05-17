/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.Conexion;
import static Modelo.Conexion.getConexion;
import Vista.JFActores;
import Vista.JFPeliculas;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author almudenaflores
 */
public class ActoresDAO extends Conexion{
    
    //Conexion Conexion;
    
    public ActoresDAO(){
       // Conexion=new Conexion();
    }
    
    /**
     * Metodo para listar los actores
     * @return 
     */
    public DefaultTableModel getTablaActores()
    {
      DefaultTableModel tablemodel = new DefaultTableModel();
      int registros = 0;
      String[] columNames = {"ID","Nombre","Apellidos","AñoNacimiento","Nacionalidad"};
      //obtenemos la cantidad de registros existentes en la tabla y se almacena en la variable "registros"
      //para formar la matriz de datos
      try{
         PreparedStatement pstm = Conexion.getConexion().prepareStatement( "SELECT count(*) as total FROM Actores");
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
         PreparedStatement pstm = Conexion.getConexion().prepareStatement("SELECT * FROM Actores");
         ResultSet res = pstm.executeQuery();
         int i=0;
         while(res.next()){
                data[i][0] = res.getString( "id_actores" );
                data[i][1] = res.getString( "Nombre" );
                data[i][2] = res.getString( "Apellidos" );
                data[i][3] = res.getString( "AñoNacimiento" );
                data[i][4] = res.getString( "Nacionalidad" );
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
    
    /**
     * Metodo para validar datos
     */
   private boolean valida_datos(String nombre , String apellidos, String anio, String nacionalidad ){
       
       
       if( nombre.length() > 0 && apellidos.length()>0 &&anio.length()>0 && nacionalidad.length()>0){
            return true;
        }
        else  
           return false;
    }
    /**
     * Metodo para registrar un actor nuevo
     * @param nombre
     * @param apellidos
     * @param anio
     * @param nacionalidad
     * @return 
     */
    public boolean registrar(String nombre, String apellidos, String anio, String nacionalidad) 
    {
     
        if( valida_datos(nombre, apellidos, anio, nacionalidad))
        {
           
            //Se hace la consulta
            String q=" INSERT INTO Actores (Nombre , Apellidos, AñoNacimiento, Nacionalidad) "
                    + "VALUES ('" + nombre + "', '" + apellidos+ "','" + anio + "','" + nacionalidad + "' ) ";
            //se ejecuta la consulta
            
            try {
                PreparedStatement pstm = Conexion.getConexion().prepareStatement(q);
                pstm.execute();
                pstm.close();
                return true;
            }catch(SQLException e){
                System.err.println( e.getMessage() );
            }
            return false;
        }else
        
         return false;
    

        
    }
    /**
     * Metodo para modificar Actores
     */
    public boolean modificar(Actores act){
        PreparedStatement ps=null;
        com.mysql.jdbc.Connection con= getConexion();
        
        String sql="UPDATE Actores SET Nombre=?, Apellidos=?, AñoNacimiento=?, Nacionalidad=?  WHERE id_Actores=?";
        
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, act.getNombre());
            ps.setString(2, act.getApellidos());
            ps.setInt(3, act.getAnio());
            ps.setString(4, act.getNacionalidad());
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    /** Elimina un registro dado su ID*/
    public boolean EliminarActor( String id_actores )
    {
         boolean res=false;
        //se arma la consulta
        String q = "DELETE FROM `Actores` WHERE `Actores`.`id_actores` = "+ id_actores+"";
        
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
    
    /**
     * Metodo para buscar
     */
    public boolean buscar(String id_actores){
       Conexion con=new Conexion();
        
        JFActores jfP=new JFActores();
        PreparedStatement ps;
        ResultSet res = null;
        
        try {
           //hacemos la conexión y la consulta en la que selccionamos los datos del id que metamos
            ps=Conexion.getConexion().prepareStatement("SELECT * FROM Actores WHERE id_actores=? ");
            
            ps.setString(1,jfP.txtId.getText()); 
           String p=jfP.txtId.getText();
            
            res=ps.executeQuery();
            
            if(res!=null){
                //jfP.textField5.setText(res.getString("id_peliculas"));
                //JOptionPane.showMessageDialog(null, "n");
                JOptionPane.showMessageDialog(null, p);
                jfP.txtNombre.setText(res.getString("Nombre"));
                jfP.txtApellidos.setText(res.getString("Apellidos"));
                jfP.txtAño.setText(res.getString("AñoNacimiento"));
                jfP.txtNacionalidad.setText(res.getString("Nacionalidad"));
                return true;
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
            }
                
        }catch(SQLException e){
            return false;
        }
        return false;

    }
 



}
