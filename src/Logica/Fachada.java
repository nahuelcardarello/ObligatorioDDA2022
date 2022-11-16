package Logica;

import java.util.ArrayList;
import Observer.Observable;

import Modelo.Puesto;
import Modelo.Trabajador;
import Modelo.Cliente;
import Excepciones.LlamadaException;
import Modelo.Llamada;
import Modelo.Sector;
import Modelo.TrabajadorException;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public void finalizarLlamada() {
        //sistemaTrabajadores.finalizarLlamada();
    }
    //Se comprueba que existe lugar para comenzar una llamada
    public boolean iniciarLlamada()  throws LlamadaException {
        return sistemaTrabajadores.iniciarLlamada();
    }
    
    public Llamada altaLlamada(Cliente uncliente, Sector unSector, LocalDate fechaInicio, LocalTime horaInicio, LocalTime horaComienzoLlamada) throws LlamadaException{
        return sistemaTrabajadores.altaLlamada(uncliente, unSector, fechaInicio, horaInicio, horaComienzoLlamada);
    }

    public Cliente getCliente(String ci) {
        return null;
    }

    public ArrayList<Sector> getSectores() {
        return sistemaTrabajadores.getSectores();
    }

    public void AgregarTrabajador(Trabajador t) {
        sistemaTrabajadores.agregarTrabajador(t);
    }

    public void AgregarCliente(Cliente c) {
        sistemaClientes.agregarCliente(c);
    }
    
    public Cliente buscarCliente(String CI){
        return sistemaClientes.buscarCliente(CI);
    }

    public void AgregarSector(Sector s) {
        sistemaTrabajadores.agregarSector(s);
    }
}
