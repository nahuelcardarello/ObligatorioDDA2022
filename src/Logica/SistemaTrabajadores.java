package Logica;

import Excepciones.LlamadaException;
import Modelo.Cliente;
import Modelo.Llamada;
import java.util.Collection;
import java.util.ArrayList;
import Modelo.Trabajador;
import Modelo.Sector;
import Modelo.Puesto;
import Modelo.TrabajadorException;
import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaTrabajadores {

    private ArrayList<Trabajador> trabajadores;

    private ArrayList<Sector> sectores;

    private int cantidadLlamadas;

    public SistemaTrabajadores() {
        this.sectores = new ArrayList<Sector>();
        this.trabajadores = new ArrayList<Trabajador>();
    }
       public boolean iniciarLlamada() throws LlamadaException {
        if (cantidadLlamadas < 5) {
            cantidadLlamadas++;
            return true;
        } else {
            throw new LlamadaException("Comuníquese más tarde...");
        }
    }
       
    public Llamada altaLlamada(Cliente uncliente, Sector unSector, LocalDate fechaInicio, LocalTime horaInicio, LocalTime horaComienzoLlamada) throws LlamadaException {
            //preguntar a matias y nahuel si no tiene sentido establecer fecha y hora al inicialixar llamada
            try {
                Llamada llamada = unSector.iniciarLlamada(uncliente, fechaInicio, horaInicio, horaComienzoLlamada);
                return llamada;
            } catch (LlamadaException llamadaEx) {
                cantidadLlamadas--;
                throw llamadaEx;
            }
    }

    private Trabajador buscarTrabajador(String CI) {
        Trabajador trabajador = null;
        int i = 0;
        while (i < trabajadores.size() && trabajador == null) {
            Trabajador t = trabajadores.get(i);
            if (t.getCI().equalsIgnoreCase(CI)) {
                trabajador = t;
            }
            i++;
        }
        return trabajador;
    }

    public Puesto login(String CI, String contrasena) throws TrabajadorException {
        Puesto puesto = null;
        Trabajador t = buscarTrabajador(CI);
        if (t != null && t.contrasenaValida(contrasena)) {
            puesto = t.getSector().altaPuestoTrabajo(t);
            if (puesto == null) {
                throw new TrabajadorException("No hay puestos disponibles");
            }
        } else {
            throw new TrabajadorException("Acceso denegado");
        }

        return puesto;
    }

    public boolean salirDelSistema(Trabajador unT) {
        return false;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    void agregarTrabajador(Trabajador t) {
        if (t != null) {
            trabajadores.add(t);
        }
    }

    void agregarSector(Sector s) {
        if (s != null) {
            sectores.add(s);
        }
    }

}
