/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author matiasan-ot
 */
public abstract class ControladorVistaLogin {

    private VistaLogin vista;

    public ControladorVistaLogin(VistaLogin vista) {
        this.vista = vista;
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

    public abstract Object llamarLogin(String usr, String pwd);
}
