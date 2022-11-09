/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Modelo.Puesto;
import iuEscritorio.VistaLoginImpl;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaLogin{

    private VistaLoginImpl vista;
    private Fachada fachada;

    public ControladorVistaLogin(VistaLoginImpl vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
    }

    public void login(String ci, String contrasena) {
        Puesto unPuesto = fachada.login(ci, contrasena);
        if (unPuesto != null) {
            vista.ejecutarCasoDeUsoInicial(unPuesto);
            vista.cerrarVista();
        } else {
            vista.mostrarError("Acceso denegado");
        }
    }
}
