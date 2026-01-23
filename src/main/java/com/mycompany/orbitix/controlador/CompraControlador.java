/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orbitix.controlador;

/**
 *
 * @author karla
 */
import com.mycompany.orbitix.modelo.Compra;
import com.mycompany.orbitix.datos.RepositorioDatos;
import com.mycompany.orbitix.modelo.Usuario;
import com.mycompany.orbitix.util.GenerarFactura;
import com.mycompany.orbitix.vista.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CompraControlador implements ActionListener {

    private VistaCompra vista;
    private Compra compra;

    public CompraControlador (VistaCompra vista, Usuario usuario) {
        this.vista = vista;
        this.compra = new Compra(vista.getCodigo(), usuario);
        vista.addBtnPagarListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        confirmar();
    }

    private void confirmar() {
        if (compra.confirmarCompra()) {
            JOptionPane.showMessageDialog(vista, 
                "Compra confirmada\nTotal: $" + compra.getTotal());
        } else {
            JOptionPane.showMessageDialog(vista, 
                "Debe seleccionar pasajes y un método de pago");
        }
    }
}