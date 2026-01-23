/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.orbitix;

import com.mycompany.orbitix.controlador.InicioControlador;
import com.mycompany.orbitix.datos.RepositorioArchivos;
import com.mycompany.orbitix.datos.RepositorioDatos;
import com.mycompany.orbitix.modelo.*;
import com.mycompany.orbitix.vista.VistaInicio;
import java.util.List;
import java.util.Scanner;



public class ORBITIX {

    public static void main(String[] args) {
       
        javax.swing.SwingUtilities.invokeLater(() -> {
            RepositorioArchivos repo = new RepositorioArchivos();
            VistaInicio vista = new VistaInicio();
            new InicioControlador(vista);
            vista.setVisible(true);
        });
        
        
    }
}