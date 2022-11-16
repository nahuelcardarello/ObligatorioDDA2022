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
public class ControladorVistaMonitor implements Observador {

    private IVistaMonitor vista;
    private Fachada modelo;
    private boolean isSectorSeleccionado;
    private Sector sector;

    public ControladorVistaMonitor(IVistaMonitor vista) {
        this.vista = vista;
        modelo = Fachada.getInstancia();
        modelo.agregarObservador(this);
    }

    public void inicialiar() {
        Fachada fachada = Fachada.getInstancia();
        vista.mostrarSectores(fachada.getInstancia().getSectores());
    }

    public void sectorSeleccionado(String nombreSector) {
        if (sector != null) {
            this.sector.quitarObservador(this);
        }
        Sector sector = modelo.buscarSector(nombreSector);
        this.sector = sector;
        sector.agregarObservador(this);
        vista.mostrarLlamadasSector(sector);
    }

    public void sectoresSeleccionados() {
        vista.mostrarLlamadasSectores(modelo.getLlamadasTotal());
    }

    public void updateSectores() {
         vista.mostrarLlamadasSectores(modelo.getLlamadasTotal());
    }

    public void updateSectorSeleccionado(Sector sector) {
        vista.mostrarLlamadasSector(sector);
    }

    public boolean isSectorSeleccionado() {
        return isSectorSeleccionado;
    }

    public void setSectorSeleccionado(boolean sectorSeleccionado) {
        this.isSectorSeleccionado = sectorSeleccionado;
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        Eventos e = (Eventos)evento;
        if(e.equals(Eventos.ACTUALIZAR_SECTORES) && !isSectorSeleccionado) {
            updateSectores();
        }
        if(e.equals(Eventos.ACTUALIZAR_SECTOR) && isSectorSeleccionado) {
            updateSectorSeleccionado((Sector)origen);
        }
    }

}
