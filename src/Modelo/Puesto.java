package Modelo;

import Observer.Observable;
import Observer.Observador;

public class Puesto extends Observable {

    private int numero;

    private int cantidadLlamadas;

    private int tiempoPromedio;

    private Trabajador trabajador;

    private Sector sector;

    private Llamada llamada;
    
    private static int numeroAcumulativo = 1;

    private int ultimaDuracionLlamada;
    
    private float ultimoCosto;
    
    private float ultimoSaldo;


    public float getUltimoSaldo() {
        return ultimoSaldo;
    }
    
    public Puesto(int cantidadLlamadas, int tiempoPromedio, Trabajador trabajador, Sector sector, Llamada llamada) {
        this.numero = numeroAcumulativo;
        numeroAcumulativo++;
        this.cantidadLlamadas = cantidadLlamadas;
        this.tiempoPromedio = tiempoPromedio;
        this.trabajador = trabajador;
        this.sector = sector;
        this.llamada = llamada;
    }

    public int getUltimaDuracionLlamada() {
        return ultimaDuracionLlamada;
    }

    public float getUltimoCosto() {
        return ultimoCosto;
    }

    public int calcularTiempoPromedio() {
        return 0;
    }
    /*tema guardar varias llamadas, calcular tiempo promedio*/
    
    
    public void finalizarLlamada(String descripcion) {
        this.llamada.finalizarLlamada(descripcion, this);
        ultimaDuracionLlamada = llamada.calcularDuracionLlamada();
        ultimoCosto = llamada.calcularCostoLlamada();
        ultimoSaldo = llamada.getSaldoCliente();
        tiempoPromedio = (tiempoPromedio + ultimaDuracionLlamada) / cantidadLlamadas;
        this.llamada.setEstado(Llamada.EstadoLlamada.finalizada);
        this.llamada = null;
        avisar(Observador.Eventos.FINALIZAR_LLAMADA);
        sector.emitirEventoLlamadaFinalizada();
        
        sector.asignarLlamadaEnEspera(this);
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

    
    public void agregarLlamada(Llamada llamada) {
        this.llamada = llamada;
        cantidadLlamadas++;
        this.avisar(Observador.Eventos.INICIAR_LLAMADA);
    }
}
