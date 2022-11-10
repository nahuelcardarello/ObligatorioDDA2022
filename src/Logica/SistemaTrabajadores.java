package Logica;

import java.util.Collection;
import java.util.ArrayList;
import Modelo.Trabajador;
import Modelo.Sector;
import Modelo.Puesto;
import Modelo.TrabajadorException;

public class SistemaTrabajadores {

    private ArrayList<Trabajador> trabajadores;

    private ArrayList<Sector> sectores;
    
    public SistemaTrabajadores() {
        this.sectores = new ArrayList<Sector>();
        this.trabajadores = new ArrayList<Trabajador>();
    }
    private Trabajador buscarTrabajador(String CI) {
        Trabajador trabajador = null;
        int i = 0;
        while (i < trabajadores.size() && trabajador == null) {
            Trabajador t = trabajadores.get(i);
            if (t.getCI() == CI) {
                trabajador = t;
            }
            i++;
        }
        return trabajador;
    }

    public Puesto login(String CI, String contrasena) throws TrabajadorException {
        Puesto puesto = null;
        Trabajador t = buscarTrabajador(CI);
        if(t != null && t.contrasenaValida(contrasena)) {
            puesto = t.getSector().altaPuestoTrabajo(t);
            if(puesto == null) {
                throw new TrabajadorException("No hay puestos disponibles");
            }
        } else {
            throw new TrabajadorException("Acceso denegado");
        }
        
        return puesto;
    }

    public boolean salirDelSistema(Trabajador unT) {
        return false;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    void agregar(Trabajador t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
