/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Modelo.Cliente;
import Modelo.Llamada;
import Excepciones.LlamadaException;
import Modelo.Puesto;
import Modelo.Sector;
import iuEscritorio.IVistaSimularLlamada;
import iuEscritorio.VistaSimularLlamadaImpl;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaSimularLlamada {

    private IVistaSimularLlamada vista;
    private Fachada fachada;

    public ControladorVistaSimularLlamada(VistaSimularLlamadaImpl vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
    }

    //Se comprueba que existe lugar para comenzar una llamada
    public boolean inicializar() throws LlamadaException {
        return Fachada.getInstancia().iniciarLlamada();
    }

    public Puesto altaLlamada(Cliente uncliente, String numeroSector, LocalDate fechaInicio, LocalTime horaInicio) {
        Sector unSector = getSector(numeroSector);

        Puesto unPuesto = Fachada.getInstancia().altaLlamada(uncliente, unSector, fechaInicio, horaInicio);;

        return unPuesto;
    }

    public Cliente ingresarUsuario(String ci) {
        Cliente unC;
        unC = Fachada.getInstancia().buscarCliente(ci);
        if (unC != null) {
            return unC;
        }
        return null;
    }

    public ArrayList<Sector> getSectores() {
        return Fachada.getInstancia().getSectores();
    }

    public void reset() {

    }

    public boolean validaCI(String CI) {
        String str = CI;
        boolean isNumeric = str.matches("[+-]?\\d*(\\.\\d+)?");
        return (CI.length() == 7 || CI.length() == 8) && isNumeric;
    }

    public Sector getSector(String numero) {
        ArrayList<Sector> sectores = getSectores();
        Sector unSector = null;
        int i = 1;
        for (Sector s : sectores) {
            if (Integer.toString(i).equals(numero)) {
                unSector = s;
            }
            i++;
        }
        return unSector;
    }
}
