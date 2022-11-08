/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Logica.Fachada;
import Modelo.Puesto;
import iuEscritorio.VistaLogin;

/**
 *
 * @author matiasan-ot
 */
public  class ControladorVistaLogin {

    private VistaLogin vista;
    private Fachada modelo;

    public ControladorVistaLogin(VistaLogin vista) {
        this.vista = vista;
        this.modelo = Fachada.getInstancia();
    }

    public void login(String ci, String contrasena) {
        Object obj = llamarLogin(ci, contrasena);
        if (obj != null) {
            vista.cerrar();
            vista.proximoCasoUso(obj);
        } else {
            vista.mostrarError("Login incorrecto");
        }
    }

    private Object llamarLogin(String ci, String contrasena) {
        return null;
    };
}
