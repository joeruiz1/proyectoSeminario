/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Juan Manuel
 */
public class ComprasOnline {
    
   private int idCompra;
   private  String nombreCliente;
   private String libro1;
   private int telefono;
   private int idLi1;
   private String direccion;  

   private int precio;
   private int tarjeta;
   
   
   
      public ComprasOnline(String nombreCliente, String libro1, int idLi1, int idCompra, int precio, int tarjeta, int telefono, String direccion) {
        this.nombreCliente = nombreCliente;
        this.libro1 = libro1;
      this.direccion=direccion;
        this.idLi1 = idLi1;
        this.telefono=telefono;
        this.idCompra=idCompra;
        
        this.precio = precio;
        this.tarjeta = tarjeta;
    }

    public int getIdLi1() {
        return idLi1;
    }

    public void setIdLi1(int idLi1) {
        this.idLi1 = idLi1;
    }

   
      
 

    public String getLibro1() {
        return libro1;
    }

    public void setLibro1(String libro1) {
        this.libro1 = libro1;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   
    public ComprasOnline() {
    }
    

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreLi() {
        return libro1;
    }

    public void setNombreLi(String nombreLi) {
        this.libro1 = nombreLi;
    }

    public int getIdLi() {
        return idLi1;
    }

    public void setIdLi(int idLi) {
        this.idLi1 = idLi;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }
   
   
   
   
    
}
