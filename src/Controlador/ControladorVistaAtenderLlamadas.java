/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Puesto;
import iuEscritorio.IVistaAtenderLlamadas;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaAtenderLlamadas {
    private IVistaAtenderLlamadas vista;
    private Puesto modelo;
    
    public ControladorVistaAtenderLlamadas(IVistaAtenderLlamadas vista, Puesto modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
}
