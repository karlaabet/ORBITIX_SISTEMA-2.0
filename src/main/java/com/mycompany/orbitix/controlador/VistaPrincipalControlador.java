/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orbitix.controlador;

import com.mycompany.orbitix.datos.RepositorioArchivos;
import com.mycompany.orbitix.modelo.Usuario;
import com.mycompany.orbitix.modelo.Vuelo;
import com.mycompany.orbitix.vista.VistaMapaAsientos;
import com.mycompany.orbitix.vista.VistaPrincipal;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaPrincipalControlador {

    private VistaPrincipal vista;
    private Usuario usuario;
    private RepositorioArchivos repo;
    private List<Vuelo> vuelos;

    public VistaPrincipalControlador(VistaPrincipal vista, Usuario usuario) {
        this.vista = vista;
        this.usuario = usuario;
        this.repo = new RepositorioArchivos();
        this.vuelos = repo.cargarVuelos();

        inicializar();
        eventos();
    }

    private void inicializar() {
        vista.setVisible(true);
    }

    private void eventos() {
        vista.getBtnBuscarVuelos().addActionListener(e -> buscarVuelos());
        vista.getBtnSelecComprar().addActionListener(e -> seleccionarVuelo());
        vista.getBtnSalir().addActionListener(e -> salir());
    }

    private void buscarVuelos() {
        String origen = vista.getCbselorigen().getSelectedItem().toString();
        String destino = vista.getCbseldestino().getSelectedItem().toString();

        DefaultTableModel modelo =
                (DefaultTableModel) vista.getTablaVuelos().getModel();
        modelo.setRowCount(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Vuelo v : vuelos) {
            if (v.getRuta().getOrigen().equals(origen)
                    && v.getRuta().getDestino().equals(destino)) {

                modelo.addRow(new Object[]{
                        v.getCodigo(),
                        sdf.format(v.getFecha()),
                        v.getRuta().getOrigen() + " -> " + v.getRuta().getDestino(),
                        "$" + String.format("%.2f", v.getPrecio()),
                        v.getRuta().getDuracionFormateada(),
                        v.getAsientosDisponibles()
                });
            }
        }
    }

    private void seleccionarVuelo() {
        int fila = vista.getTablaVuelos().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un vuelo primero.");
            return;
        }

        String codigo = vista.getTablaVuelos().getValueAt(fila, 0).toString();

        Vuelo seleccionado = vuelos.stream()
                .filter(v -> v.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);

        if (seleccionado != null) {
            new VistaMapaAsientos(vista, seleccionado, usuario).setVisible(true);
            vista.setVisible(false);
        }
    }

    private void salir() {
        int confirm = JOptionPane.showConfirmDialog(
                vista,
                "¿Está seguro que desea salir?",
                "Orbitix",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
