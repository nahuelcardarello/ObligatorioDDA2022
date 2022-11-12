package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {

    private String estado;

    private LocalDate fechaInicio;

    private LocalTime horaInicio;

    private LocalDate fechaFin;

    private LocalTime horaFin;

    private String descripcion;

    private String numeroLlamada;
    
    private int ultimoNumeroLlamada;

    private float costoTotal;

    private Cliente cliente;

    private Puesto puesto;

    private Trabajador trabajador;
    
    private final int costoPorSegundo=1;

    public void finalizarLlamada(String descripcion) {

    }

    public float calcularCostoLlamada() {
        return 0;
    }

    public int calcularDuracionLlamada() {
        return 0;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
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

    public String getNumeroLlamada() {
        return numeroLlamada;
    }

    public void setNumeroLlamada(String numeroLlamada) {
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

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}
