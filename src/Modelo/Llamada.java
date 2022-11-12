package Modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {

    private boolean enCurso;

    private LocalDate fechaInicio;

    private LocalTime horaInicio;

    private LocalDate fechaFin;

    private LocalTime horaFin;

    private String descripcion;

    private String numeroLlamada;

    private float costo;

    private Cliente cliente;

    private Puesto puesto;

    private Trabajador trabajador;

    public void finalizarLlamada(String descripcion,Puesto p) {
        this.descripcion  = descripcion;
        this.horaFin = LocalTime.now();
        this.fechaFin = LocalDate.now();
        this.trabajador = p.getTrabajador();
    }

    public float calcularCostoLlamada() {
        return 0;
    }

    public int calcularDuracionLlamada() {
        Duration diff = Duration.between(horaFin,horaInicio);
        int segundosLlamada = (int)diff.toSeconds();
        return segundosLlamada;
    }

    public boolean isEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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
