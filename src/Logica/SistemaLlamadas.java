package Logica;

import Modelo.Llamada;
import Modelo.LlamadaException;
import Modelo.Sector;
import java.util.ArrayList;
import java.util.Collection;

public class SistemaLlamadas {

    private ArrayList<Sector> sectores;

    private ArrayList<Llamada> llamadas;
    private ArrayList<Llamada> llamadasFinalizadas;

    public SistemaLlamadas() {
        this.sectores = new ArrayList<Sector>();
        this.llamadas = new ArrayList<Llamada>();
        this.llamadasFinalizadas = new ArrayList<Llamada>();
    }

    public boolean iniciarLlamada() throws LlamadaException {
        if(llamadas.size() < 5) {
           return true;
        } else {
            throw new LlamadaException("Comuníquese más tarde...");
        }
    }

    public boolean finalizarLlamada() {
        return false;
    }

}
