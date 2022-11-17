package Modelo;

import Observer.Observable;
import Observer.Observador;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada extends Observable {

    public enum EstadoLlamada {
        enCurso,
        enEspera,
        finalizada

    }
    private int duracion;

    private EstadoLlamada estado;

    private LocalDate fechaInicio;

    private LocalTime horaInicio;

    private LocalDate fechaFin;

    private LocalTime horaFin;

    private LocalTime horaComienzoEspera;

    private LocalTime horaComienzoLlamada;

    private String descripcion;

    private int numeroLlamada;

    private static int ultimoNumeroLlamada;

    private float costoTotal;

    private Cliente cliente;

    private Puesto puesto;

    private Trabajador trabajador;

    private final int costoPorSegundo = 1;

    public Llamada(EstadoLlamada estado, LocalDate fechaInicio, LocalTime horaInicio, LocalTime horaComienzoLlamada, Cliente cliente, Puesto puesto, Trabajador trabajador) {
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.horaComienzoLlamada = horaComienzoLlamada;
        this.numeroLlamada = ultimoNumeroLlamada;
        ultimoNumeroLlamada++;
        this.cliente = cliente;
        this.puesto = puesto;
        this.trabajador = trabajador;
    }

    public int getDuracion() {
        return duracion;
    }

    public LocalTime getHoraComienzoEspera() {
        return horaComienzoEspera;
    }

    public LocalTime getHoraComienzoLlamada() {
        return horaComienzoLlamada;
    }

    public static int getUltimoNumeroLlamada() {
        return ultimoNumeroLlamada;
    }

    public int getCostoPorSegundo() {
        return costoPorSegundo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setHoraComienzoEspera(LocalTime horaComienzoEspera) {
        this.horaComienzoEspera = horaComienzoEspera;
    }

    public void setHoraComienzoLlamada(LocalTime horaComienzoLlamada) {
        this.horaComienzoLlamada = horaComienzoLlamada;
    }

    public static void setUltimoNumeroLlamada(int ultimoNumeroLlamada) {
        Llamada.ultimoNumeroLlamada = ultimoNumeroLlamada;
    }

    public EstadoLlamada getEstado() {
        return estado;
    }

    public void setEstado(EstadoLlamada estado) {
        this.estado = estado;
    }

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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public float getSaldoCliente() {
        return cliente.getSaldo();
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroLlamada() {
        return numeroLlamada;
    }

    public void setNumeroLlamada(int numeroLlamada) {
        this.numeroLlamada = numeroLlamada;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costo) {
        this.costoTotal = costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public void setPuesto(Puesto p) {
        puesto = p;
        if (this.estado.equals(EstadoLlamada.enEspera)) {
            this.estado = EstadoLlamada.enCurso;
            avisar(Observador.Eventos.QUITAR_DE_ESPERA);
        }
    }

    public void finalizarLlamada(String descripcion, Puesto p) {
        this.descripcion = descripcion;
        this.fechaFin = LocalDate.now();
        this.horaFin = LocalTime.now();
        this.estado = EstadoLlamada.finalizada;
        this.duracion = calcularDuracionLlamada();
        if (this.estado == EstadoLlamada.enCurso) {
            this.costoTotal = calcularCostoLlamada();
            this.cliente.sumarCosto(this.costoTotal);
        }

    }

    public boolean unMinutoDeTiempoDeEspera() {
        if (horaComienzoEspera != null && horaComienzoLlamada != null) {
            int duracion = (int) Duration.between(horaComienzoEspera, horaComienzoLlamada).toSeconds();

            if (duracion >= 60) {
                return true;
            }
        }

        return false;
    }

    public int cantSegundosEnEspera() {
        if (horaComienzoEspera != null && horaComienzoLlamada != null) {
            return (int) Duration.between(horaComienzoEspera, horaComienzoLlamada).toSeconds();
        } else {
            return 0;
        }
    }

    public float calcularCostoLlamada() {
        return cliente.calculoDeCostos(this);
    }

    public int calcularDuracionLlamada() {
        if (horaComienzoLlamada != null && horaFin != null) {
            return (int) Duration.between(horaComienzoLlamada, horaFin).toSeconds();
        }
        return 0;
    }
}
