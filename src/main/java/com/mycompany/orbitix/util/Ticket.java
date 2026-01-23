/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.orbitix.util;

import com.mycompany.orbitix.modelo.Pasaje;
import com.mycompany.orbitix.modelo.Pasajero;
import com.mycompany.orbitix.modelo.Vuelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author karla
 */

public class Ticket {

    public static String generarBoardingPass(Pasaje p) {
        if (p == null) return "Ticket inválido.";

        Vuelo v = p.getVuelo();
        Pasajero pa = p.getPasajero();

        String aerolinea = "ORBITIX AIR";
        String codigoVuelo = (v != null) ? v.getCodigo() : "N/D";
        String fecha = (v != null && v.getFecha() != null)
                ? new SimpleDateFormat("dd/MM/yyyy").format(v.getFecha())
                : "N/D";

        String origen = (v != null && v.getRuta() != null) ? v.getRuta().getOrigen() : "N/D";
        String destino = (v != null && v.getRuta() != null) ? v.getRuta().getDestino() : "N/D";

        
        String hora = "N/D";

        String pasajero = (pa != null) ? (pa.getNombre() + " " + pa.getApellido()) : "N/D";
        String cedula = (pa != null) ? pa.getCedula() : "N/D";

        String asiento = (p.getAsiento() != null) ? p.getAsiento() : "N/D";
        String clase = (p.getClase() != null) ? p.getClase().toString() : "N/D";

        
        String codigoTicket = obtenerCodigoTicket(p);

        
        String gate = "G" + asiento.substring(0, 1); 
        String boarding = "N/D";

        String emitido = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());

        return ""
            + "=================================================\n"
            + "            BOARDING PASS - " + aerolinea + "\n"
            + "=================================================\n"
            + "PASAJERO : " + pasajero + "\n"
            + "ID       : " + cedula + "\n"
            + "-------------------------------------------------\n"
            + "VUELO    : " + codigoVuelo + "\n"
            + "RUTA     : " + origen + "  ->  " + destino + "\n"
            + "FECHA    : " + fecha + "   HORA: " + hora + "\n"
            + "-------------------------------------------------\n"
            + "ASIENTO  : " + asiento + "     CLASE: " + clase + "\n"
            + "GATE     : " + gate + "        BOARDING: " + boarding + "\n"
            + "-------------------------------------------------\n"
            + "CÓD. TICKET: " + codigoTicket + "\n"
            + "Emitido: " + emitido + "\n"
            + "=================================================\n";
    }

    private static String obtenerCodigoTicket(Pasaje p) {
        
        try {
            Object r = Pasaje.class.getMethod("getCodigoTkt").invoke(p);
            if (r != null) return r.toString();
        } catch (Exception ignored) {}

        try {
            Object r = Pasaje.class.getMethod("getCodigo").invoke(p);
            if (r != null) return r.toString();
        } catch (Exception ignored) {}

        return "N/D";
    }
}
