/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iuEscritorio;

import Modelo.Puesto;

/**
 *
 * @author guillermorecoba
 */
public interface IVistaAtenderLlamadas {

    void inicializar();

    void mostrarDatosPuesto(Puesto p);

    void iniciarLlamada(Puesto p);

    void finalizarLlamada(); //creo que tendria que recibir puesto

    void reset();
}
