/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iuEscritorio;

/**
 *
 * @author matiasan-ot
 */
import Excepciones.LlamadaException;
import Modelo.Llamada;
import Modelo.Puesto;

public interface IVistaSimularLlamada {

    public void inicializar() throws LlamadaException;

    public void altaLlamada(String numeroSectorElegido);

    public void ingresarUsuario();

    public void mostrarSectores();

    public void reset();

    public void finalizarLlamada(int ultimaDuracionLlamada, float ultimoCosto, float ultimoSaldo);
    
    public void mostrarDatosLlamada(Puesto p);
}
