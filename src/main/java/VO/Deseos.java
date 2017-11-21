/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Alejandro
 */
public class Deseos {
    private int id_deseos;
    private int id_libro;
    private String nombre_libro;
    private int precio;

    public Deseos() {
    }

    public Deseos(int id_deseos, int id_libro, String nombre_libro, int precio) {
        this.id_deseos = id_deseos;
        this.id_libro = id_libro;
        this.nombre_libro = nombre_libro;
        this.precio = precio;
    }

    public int getId_deseos() {
        return id_deseos;
    }

    public void setId_deseos(int id_deseos) {
        this.id_deseos = id_deseos;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
    
}
