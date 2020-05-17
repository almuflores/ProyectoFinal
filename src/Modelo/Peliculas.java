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
public class Peliculas {
    String titulo, resumen;
    int anio;
    double duracion;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public int getAnio() {
        return anio;
    }

    public double getDuracion() {
        return duracion;
    }
    
    
}
