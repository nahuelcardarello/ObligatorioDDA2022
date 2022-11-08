package Modelo;

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

	public void finalizarLlamada(String descripcion) {

	}

	public float calcularCostoLlamada() {
		return 0;
	}

	public int calcularDuracionLlamada() {
		return 0;
	}

}
