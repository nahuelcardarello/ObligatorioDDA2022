/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iuEscritorio;


import Modelo.Puesto;
/**
 *
 * @author matiasan-ot
 */
public interface IVistaLogin {

    public void mostrarError(String mensaje);

    public void ejecutarCasoDeUsoInicial(Puesto unP);

    public void cerrarVista();
}
