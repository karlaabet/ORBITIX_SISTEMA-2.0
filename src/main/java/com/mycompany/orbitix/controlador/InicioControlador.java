/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orbitix.controlador;
import com.mycompany.orbitix.vista.VistaInicio;
import com.mycompany.orbitix.vista.VistaLogin;
import com.mycompany.orbitix.vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class InicioControlador implements ActionListener {

    private VistaInicio vista;

    public InicioControlador(VistaInicio vista) {
        this.vista = vista;

        this.vista.addBtnIniciarSesionListener(this);
        this.vista.addBtnCrearCuentaListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getBtnIniciarSesion()) {
            JOptionPane.showMessageDialog(vista, "Ir a Login");
        }

        if (e.getSource() == vista.getBtnCrearCuenta()) {
            JOptionPane.showMessageDialog(vista, "Ir a Registro");
        }
    }
}
