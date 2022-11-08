package Logica;

import java.util.ArrayList;
import Observer.Observable;

public class Fachada extends Observable {

	private SistemaTrabajadores sistemaTrabajadores;

	private SistemaLlamadas sistemaLlamadas;

	private SistemaClientes sistemaClientes;


	public Puesto login(String CI, String contrasena) {
		return null;
	}

	public void salirDeAplicacion(Trabajador unT) {

	}

	public boolean iniciarLlamada() {
		return false;
	}

	public Cliente getCliente(String ci) {
		return null;
	}

	public ArrayList<Sector> getSectores() {
		return null;
	}

}
