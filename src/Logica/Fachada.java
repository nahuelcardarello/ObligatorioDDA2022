package Logica;

import java.util.ArrayList;
import Observer.Observable;

import Modelo.Puesto;
import Modelo.Trabajador;
import Modelo.Cliente;
import Modelo.Sector;

public class Fachada extends Observable {

    private SistemaTrabajadores sistemaTrabajadores;

    private SistemaLlamadas sistemaLlamadas;

    private SistemaClientes sistemaClientes;

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

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
