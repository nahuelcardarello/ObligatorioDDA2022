/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuEscritorio;

import Controlador.ControladorVistaLogin;
import java.awt.Frame;
import Modelo.Puesto;


public class VistaLogin extends VistaLoginImpl {

    public VistaLogin(Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Ingrese sus credenciales");
        this.setControlador(new ControladorVistaLogin(this));
    }

    @Override
    public void ejecutarCasoDeUsoInicial(Puesto unP) {
        new VistaAtenderLlamadaImpl((java.awt.Frame) this.getParent(), false, unP).setVisible(true);
    }
}
