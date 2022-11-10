package Modelo;

import Observer.Observable;

public class Puesto extends Observable {

    private int numero;

    private int cantidadLlamadas;

    private int tiempoPromedio;

    private Trabajador trabajador;

    private Sector sector;

    private Llamada llamada;

    public Puesto(int numero, int cantidadLlamadas, int tiempoPromedio, Trabajador trabajador, Sector sector, Llamada llamada) {
        this.numero = numero;
        this.cantidadLlamadas = cantidadLlamadas;
        this.tiempoPromedio = tiempoPromedio;
        this.trabajador = trabajador;
        this.sector = sector;
        this.llamada = llamada;
    }

    public int calcularTiempoPromedio() {
        return 0;
    }

    public boolean finalizarLlamada(String descripcion) {
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidadLlamadas() {
        return cantidadLlamadas;
    }

    public void setCantidadLlamadas(int cantidadLlamadas) {
        this.cantidadLlamadas = cantidadLlamadas;
    }

    public int getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(int tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Llamada getLlamada() {
        return llamada;
    }

    public void setLlamada(Llamada llamada) {
        this.llamada = llamada;
    }
}
