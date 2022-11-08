package Logica;

import Observer.Observable;

public class Puesto extends Observable {

	private int numero;

	private int cantidadLlamadas;

	private int tiempoPromedio;

	private Trabajador trabajador;

	private Sector sector;

	private Llamada llamada;

	public int calcularTiempoPromedio() {
		return 0;
	}

	public boolean finalizarLlamada(String descripcion) {
		return false;
	}

}
