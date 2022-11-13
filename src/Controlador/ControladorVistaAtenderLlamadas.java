/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Puesto;
import Observer.Observable;
import Observer.Observador;
import iuEscritorio.IVistaAtenderLlamadas;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaAtenderLlamadas implements Observador {
    private IVistaAtenderLlamadas vista;
    private Puesto modelo;
    
    public ControladorVistaAtenderLlamadas(IVistaAtenderLlamadas vista, Puesto modelo) {
        this.vista = vista;
        this.modelo = modelo;
        modelo.agregarObservador(this);
    }
    public void inicializar()
    {
        vista.mostrarDatosPuesto(modelo);
    }
    public void finalizarLlamada(String desc) {
        modelo.finalizarLlamada(desc);
    }
    public boolean enLlamada() {
        return modelo.getLlamada() != null;
    }
    @Override
    public void actualizar(Object evento, Observable origen) {
        Observador.Eventos e  = (Observador.Eventos)evento;
        switch(e) {
            case INICIAR_LLAMADA:
                vista.iniciarLlamada((Puesto) origen);
            break;
            case FINALIZAR_LLAMADA:
                vista.finalizarLlamada((Puesto) origen);
            break;
                
        }
    }
}
