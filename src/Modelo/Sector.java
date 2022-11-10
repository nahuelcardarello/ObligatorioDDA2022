package Modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Sector {

    private String nombre;

    private int numero;

    private int cantidadPuestos;

    private ArrayList<Trabajador> trabajadores;

    private ArrayList<Puesto> puestos;
    
    

    public Sector(String nombre, int numero, int cantidadPuestos, ArrayList<Trabajador> trabajadores, ArrayList<Puesto> puestos) {
        this.nombre = nombre;
        this.numero = numero;
        this.cantidadPuestos = cantidadPuestos;
        this.trabajadores = new ArrayList<Trabajador>();
        this.puestos = new ArrayList<Puesto>();
    }

    public Puesto altaPuestoTrabajo(Trabajador unT) {
        Puesto puesto = puestoDisponible();
        if(puesto == null && puestos.size() < cantidadPuestos) {
            Puesto puestoNuevo = new Puesto(0,0,unT,this,null);
            puesto = puestoNuevo;
        }
        return puesto;
        
    }
    public Puesto puestoDisponible() {
        Puesto puesto = null;
        int i = 0;
        while(i < puestos.size() && puesto == null) {
            Puesto p = puestos.get(i);
            if(p.getTrabajador() == null)
                puesto = p;
            i++;
        }
        return puesto;
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

}
