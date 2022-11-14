package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import Excepciones.LlamadaException;

public class Sector {

    private String nombre;

    private int numero;

    private int cantidadPuestos;

    private ArrayList<Trabajador> trabajadores;

    private ArrayList<Puesto> puestos;

    private ArrayList<Llamada> llamadas;
    
    private ArrayList<Llamada> llamadasEnEspera;

    public Sector() {
        this.puestos = new ArrayList<Puesto>();
        this.trabajadores = new ArrayList<Trabajador>();
    }
    
    public Puesto altaPuestoTrabajo(Trabajador unT) {
        Puesto puesto = puestoDisponible();
        if (puesto == null && puestos.size() < cantidadPuestos) {
            Puesto puestoNuevo = new Puesto(0, 0, unT, this, null);
            puesto = puestoNuevo;
            puestos.add(puesto);
        }
        return puesto;

    }

    public Puesto iniciarLlamada(Cliente uncliente, LocalDate fechaInicio, LocalTime horaInicio) throws Excepciones.LlamadaException {
        if (puestos.size() > 0) {
            Puesto p = puestoParaAtender();
            if (p!=null) {
                Llamada llamada = new Llamada(Llamada.EstadoLlamada.enCurso, fechaInicio, horaInicio, uncliente, p, p.getTrabajador());
                p.agregarLlamada(llamada);
                return p;
            } else if (p == null) {
                Llamada llamada = new Llamada(Llamada.EstadoLlamada.enEspera, fechaInicio, horaInicio, uncliente, p, p.getTrabajador());
                llamadasEnEspera.add(llamada);
                return p;
            }else{
                return null;
            }
        } else {
            throw new Excepciones.LlamadaException("Sector no disponible");
        }
    }
    @Override
    public String toString() {
        return this.nombre;
    }
    public Puesto puestoDisponible() {
        Puesto puesto = null;
        int i = 0;
        while (i < puestos.size() && puesto == null) {
            Puesto p = puestos.get(i);
            if (p.getTrabajador() !=  null) {
                puesto = p;
            }
            i++;
        }
        return puesto;
    }
    
    public Puesto puestoParaAtender(){
        Puesto puesto=null;
        
        for (Puesto p : puestos) {
            if (p.getLlamada()==null && p.getTrabajador()!=null) {
                puesto=p;
            }
        }
        
        return puesto;
    }
    
    public int cantidadDeLlamadasASerAtendido(){
        int cantLlamadasEnEspera=0;
        
        for (Llamada Ll : llamadas) {
            if (Ll.getEstado().equals("enEspera")) {
                cantLlamadasEnEspera++;
            }
        }
        return cantLlamadasEnEspera;
    }
    
    public int cantidadDeMinutosDeEspera(){
        int cantMinutos=0;
        
        if (cantidadDeLlamadasASerAtendido()>0) {
            cantMinutos= this.cantidadDeLlamadasASerAtendido()*this.tiempoPromedioAtencionSector();
        }
        
        return cantMinutos;
    }
    
    public int tiempoPromedioAtencionSector(){
        int cantMinutos=0;
        
        for (Puesto p : puestos) {
            cantMinutos+=(p.getTiempoPromedio()/60);
        }
        cantMinutos*=puestos.size();
        
        return cantMinutos;
    }

    public boolean bajaPuestoTrabajo(Trabajador unT) {
        return false;
    }

    public int calcularTiempoPromedio() {
        return 0;
    }

    public String obtenerNumeroLlamada() {
        return null;
    }

    public void hay() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public void setCantidadPuestos(int cantidadPuestos) {
        this.cantidadPuestos = cantidadPuestos;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(ArrayList<Puesto> puestos) {
        this.puestos = puestos;
    }

    public ArrayList<Llamada> getLlamadasEnEspera() {
        return llamadasEnEspera;
    }

    public void setLlamadasEnEspera(ArrayList<Llamada> llamadasEnEspera) {
        this.llamadasEnEspera = llamadasEnEspera;
    }
    
    

}
