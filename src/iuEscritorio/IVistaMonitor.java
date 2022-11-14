package iuEscritorio;

import Modelo.Llamada;
import Modelo.Sector;
import java.util.ArrayList;

public interface IVistaMonitor {

    public void inicializar();

    public void mostrarSectores(ArrayList<Sector> sectores);

    public void mostrarLlamadasSector(Sector sectorSeleccionado);

    public void mostrarLlamadasSectores( ArrayList<Llamada> llamadasSectores);
}
