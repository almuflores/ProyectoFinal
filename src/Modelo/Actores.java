/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author almudenaflores
 */
public class Actores {
    /**
     * Atributos de la clase Actores
     */
    
    String nombre, apellidos,nacionalidad;
    int anio, id_actores;
    
    public Actores(){
    id_actores=id_actores;
    nombre="";
    apellidos="";
    anio = anio;
    nacionalidad="";
}

    
    
    public int getId_actores() {
        return id_actores;
    }

    /**
     * Getters y setters
     * @param id_actores
     * @param nombre
     * @param apellidos
     * @param nacionalidad
     * @param anio
     */
    public void setId_actores(int id_actores) {
        this.id_actores = id_actores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getAnio() {
        return anio;
    }

    /**
     * To String
    */
    public String toString() {
        return "Actores{" + "Nombre=" + nombre + ", Apellidos=" + apellidos + ", Año=" + anio + ", Nacionalidad=" + nacionalidad + '}';
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}