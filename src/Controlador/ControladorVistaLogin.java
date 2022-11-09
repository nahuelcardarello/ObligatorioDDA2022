/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Modelo.Puesto;
import Modelo.TrabajadorException;
import iuEscritorio.VistaLoginImpl;

/**
 *
 * @author matiasan-ot
 */
public class ControladorVistaLogin {

    private VistaLoginImpl vista;
    private Fachada fachada;

    public ControladorVistaLogin(VistaLoginImpl vista) {
        this.vista = vista;
        this.fachada = Fachada.getInstancia();
    }

    public void login(String ci, String contrasena) {
        try {
            Puesto unPuesto = fachada.login(ci, contrasena);
            vista.ejecutarCasoDeUsoInicial(unPuesto);
            vista.cerrarVista();
        } catch (TrabajadorException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }
}
