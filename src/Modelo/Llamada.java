package Modelo;

import java.time.Duration;
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
    
    private Sector sector;

    private final int costoPorSegundo=1;

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }


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
        this.descripcion = descripcion;
        this.fechaFin = LocalDate.now();
        this.horaFin = LocalTime.now();
        this.estado = EstadoLlamada.finalizada;
    }

    public float calcularCostoLlamada() {
        return 0;
    }

    public int calcularDuracionLlamada() {
        return (int)Duration.between(horaInicio,horaFin).toSeconds();
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
