package Logica;

import java.util.ArrayList;
import Observer.Observable;

import Modelo.Puesto;
import Modelo.Trabajador;
import Modelo.Cliente;
import Modelo.Sector;
import Modelo.TrabajadorException;

public class Fachada extends Observable {

    private static Fachada instancia;

    private SistemaTrabajadores sistemaTrabajadores;

    private SistemaLlamadas sistemaLlamadas;

    private SistemaClientes sistemaClientes;

    public synchronized static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        sistemaClientes = new SistemaClientes();
        sistemaLlamadas = new SistemaLlamadas();
        sistemaTrabajadores = new SistemaTrabajadores();
    }

    public Puesto login(String CI, String contrasena) throws TrabajadorException {
        return sistemaTrabajadores.login(CI, contrasena);
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

    public void AgregarTrabajador(Trabajador t) {
        sistemaTrabajadores.agregarTrabajador(t);
    }

    void AgregarCliente(Cliente c) {
        sistemaClientes.agregar(c);
    }

    void AgregarSector(Sector s) {
        sistemaTrabajadores.agregarSector(s);
    }
}
