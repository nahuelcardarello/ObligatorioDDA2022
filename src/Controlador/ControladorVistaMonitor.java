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

    public ControladorVistaMonitor(IVistaMonitor vista) {
        this.vista = vista;
    }

    public void inicialiar() {
        Fachada fachada = Fachada.getInstancia();
        vista.mostrarSectores(fachada.getInstancia().getSectores());
    }

    public void sectorSeleccionado(Sector sectorSeleccionado) {
        vista.mostrarLlamadasSector(sectorSeleccionado);
    }
    public void sectoresSeleccionados() {
        vista.mostrarLlamadasSectores(Fachada.getInstancia().getLlamadasTotal());
    }

}
