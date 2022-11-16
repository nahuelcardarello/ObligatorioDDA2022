/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Modelo.Sector;
import Observer.Observable;
import Observer.Observador;
import iuEscritorio.IVistaMonitor;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaMonitor  {

    private IVistaMonitor vista;
    private Fachada modelo; 

    public ControladorVistaMonitor(IVistaMonitor vista) {
        this.vista = vista;
        modelo = Fachada.getInstancia();
    }

    public void inicialiar() {
        Fachada fachada = Fachada.getInstancia();
        vista.mostrarSectores(fachada.getInstancia().getSectores());
    }

    public void sectorSeleccionado(String nombreSector) {
       Sector sector =  modelo.buscarSector(nombreSector);
        vista.mostrarLlamadasSector(sector);
    }
    public void sectoresSeleccionados() {
        vista.mostrarLlamadasSectores(modelo.getLlamadasTotal());
    }

}
