/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Puesto;
import iuEscritorio.VistaAtenderLlamadas;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaAtenderLlamadas {
    private VistaAtenderLlamadas vista;
    private Puesto modelo;
    
    public ControladorVistaAtenderLlamadas(VistaAtenderLlamadas vista, Puesto modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
}
