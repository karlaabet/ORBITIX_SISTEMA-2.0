package com.mycompany.orbitix.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private String codigo;
    private Date fecha;
    private double total;
    private Usuario usuario; 
    private Pago pago;
    private List<Pasaje> pasajes; 

    public Compra(String codigo, Usuario usuario) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.fecha = new Date();
        this.pasajes = new ArrayList<>();
        this.total = 0;
    }

    public void agregarPasaje(Pasaje pasaje) {
        if (pasaje != null) {
            pasajes.add(pasaje);
            this.total += (pasaje.getPrecio() + pasaje.getRecargo());
        }
    }

    public void recalcularTotal() {
        this.total = 0;
        for (Pasaje p : pasajes) {
            this.total += (p.getPrecio() + p.getRecargo());
        }
    }

    public boolean confirmarCompra() {
        return pago != null && !pasajes.isEmpty();
    }


    public String getCodigo(){
        return codigo;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public double getTotal(){
        return total;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public List<Pasaje> getPasajes(){
        return pasajes;
    }
    
    public Pago getPago(){
        return pago;
    }
    
    public void setPago(Pago pago){
        this.pago = pago;
    }
}