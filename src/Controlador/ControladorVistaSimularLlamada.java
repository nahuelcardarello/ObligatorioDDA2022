/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.CIException;
import Logica.Fachada;
import Modelo.Cliente;
import Modelo.Llamada;
import Excepciones.LlamadaException;
import Modelo.Puesto;
import Modelo.Sector;
import Observer.Observable;
import Observer.Observador;
import iuEscritorio.IVistaSimularLlamada;
import iuEscritorio.VistaSimularLlamadaImpl;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaSimularLlamada implements Observador {

    private IVistaSimularLlamada vista;
    private Fachada fachada;
    private LocalDate fechaInicio;
    private LocalTime horaComienzoLlamada;
    private LocalTime horaInicio;
    private boolean estaCiIngresada = false;
    private String ci = "";
    private Cliente unCliente = null;
    private Puesto puesto;

    public ControladorVistaSimularLlamada(VistaSimularLlamadaImpl vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();

    }

    //Se comprueba que existe lugar para comenzar una llamada
    public boolean inicializar() throws LlamadaException {
        boolean inicio = false;
        if (Fachada.getInstancia().iniciarLlamada()) {
            inicio = true;
        }
        return Fachada.getInstancia().iniciarLlamada();
    }

    public void finalizarLlamada() {
        String descripcionLlamada = puesto.getLlamada().getDescripcion();
        puesto.finalizarLlamada(descripcionLlamada);
        puesto = null;
    }

    public Llamada altaLlamada(String numeroSector) throws LlamadaException {
        Sector unSector = getSector(numeroSector);
        this.setHoraComienzoLlamada((LocalTime.now()));
        Llamada llamada = fachada.altaLlamada(this.unCliente, unSector, this.fechaInicio, this.horaComienzoLlamada, this.horaInicio);
        Puesto p = llamada.getPuesto();
        if (p != null) {
            puesto = p;
            p.agregarObservador(this);
        } else {
            llamada.agregarObservador(this);
        }
        /*Sector unSector = getSector(numeroSector);
        Puesto unPuesto = Fachada.getInstancia().altaLlamada(this.unCliente, unSector, this.fechaInicio, this.horaInicio).get;
        if (unPuesto != null && llamada != null) {
            unPuesto.agregarObservador(this);
            llamada.agregarObservador(this);
        }*/
        return llamada;

    }

    public void ingresarUsuario() throws CIException {
        Cliente unC;
        unC = Fachada.getInstancia().buscarCliente(ci);
        if (unC != null) {
            this.unCliente = unC;
        } else {
            throw new CIException("Cliente no registrado");
        }

    }

    public ArrayList<Sector> getSectores() {
        return Fachada.getInstancia().getSectores();
    }

    public void reset() {

    }

    public void resetDatos() {
        fechaInicio = null;
        horaInicio = null;
        horaComienzoLlamada = null;
        vaciarCi();
        estaCiIngresada = false;
        unCliente = null;
    }

    public boolean validaCI() throws CIException {
        boolean isNumeric = ci.matches("[+-]?\\d*(\\.\\d+)?");
        if ((ci.length() == 7 || ci.length() == 8) && isNumeric) {
            return true;
        } else {
            throw new CIException("Formato de CI no valido");
        }
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

    @Override
    public void actualizar(Object evento, Observable origen) {
        Eventos e = (Eventos) evento;
        if (e == Eventos.FINALIZAR_LLAMADA) {
            Puesto p = (Puesto) origen;
            p.quitarObservador(this);
            fachada.finalizarLlamada();
            vista.finalizarLlamada(p.getUltimaDuracionLlamada(), p.getUltimoCosto(), p.getUltimoSaldo());
        } else if (e == Eventos.QUITAR_DE_ESPERA) {
            Llamada llamada = (Llamada) origen;
            Puesto p = llamada.getPuesto();
            llamada.quitarObservador(this);
            p.agregarObservador(this);
            this.puesto = p;
            vista.mostrarDatosLlamada(p);
        }
    }

    public boolean getEstaCiIngresada() {
        return estaCiIngresada;
    }

    public void setEstaCiIngresada(boolean ingresada) {
        this.estaCiIngresada = ingresada;
    }

    public String getCi() {
        return ci;
    }

    public void agregarNumeroCi(String ci) {
        this.ci += ci;
    }

    public void vaciarCi() {
        this.ci = "";
    }

    /*seguir en atender llamadas, implementar finalixar*/
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraComienzoLlamada() {
        return horaComienzoLlamada;
    }

    public void setHoraComienzoLlamada(LocalTime horaComienzoLlamada) {
        this.horaComienzoLlamada = horaComienzoLlamada;
    }
    
    
}
