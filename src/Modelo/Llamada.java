package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {

    public enum EstadoLlamada {
        enCurso,
        enEspera,
        finalizada
        
    }
    private EstadoLlamada estado;

    private LocalDate fechaInicio;

    private LocalTime horaInicio;

    private LocalDate fechaFin;

    private LocalTime horaFin;

    private String descripcion;

    private int numeroLlamada;
    
    private static int ultimoNumeroLlamada;

    private float costoTotal;

    private Cliente cliente;

    private Puesto puesto;

    private Trabajador trabajador;
    
    private final int costoPorSegundo=1;
    

    public Llamada(EstadoLlamada estado, LocalDate fechaInicio, LocalTime horaInicio, Cliente cliente, Puesto puesto, Trabajador trabajador) {
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.horaInicio = horaInicio;
        this.numeroLlamada = ultimoNumeroLlamada;
        ultimoNumeroLlamada++;
        this.cliente = cliente;
        this.puesto = puesto;
        this.trabajador = trabajador;
    }

    
    
    public void finalizarLlamada(String descripcion,Puesto p) {

    }

    public float calcularCostoLlamada() {
        return 0;
    }

    public int calcularDuracionLlamada() {
        return 0;
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
