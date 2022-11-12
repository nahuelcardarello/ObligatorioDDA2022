package Logica;

import Modelo.Llamada;
import Excepciones.LlamadaException;
import Modelo.Cliente;
import Modelo.Puesto;
import Modelo.Sector;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class SistemaLlamadas {

    private ArrayList<Sector> sectores;

    private ArrayList<Llamada> llamadas;
    private ArrayList<Llamada> llamadasFinalizadas;
    private final int cantidadLlamadas = 5;
    private int cantidadLlamadasIniciadas;

    public SistemaLlamadas() {
        this.sectores = new ArrayList<Sector>();
        this.llamadas = new ArrayList<Llamada>();
        this.llamadasFinalizadas = new ArrayList<Llamada>();
    }
    
    //Se comprueba que existe lugar para comenzar una llamada
    public boolean iniciarLlamada() throws LlamadaException {
        if (llamadas.size() < 5) {
            cantidadLlamadasIniciadas++;
            return true;
        } else {
            throw new LlamadaException("Comuníquese más tarde...");
        }
    }

    public boolean finalizarLlamada() {
        return false;
    }
    
    //Seguir aca
    public Puesto altaLlamada(Cliente uncliente, Sector unSector, LocalDate fechaInicio, LocalTime horaInicio){
        Puesto unPuesto=null;

        return unPuesto;
    }

}
