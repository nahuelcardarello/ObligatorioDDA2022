/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iuEscritorio;

/**
 *
 * @author matiasan-ot
 */

import Modelo.Puesto;

interface IVistaSimularLlamada {

    public void inicializar();

    public void mostrarDatosPuesto(Puesto p);

    public void iniciarllamada(Puesto p);

    public void finalizarLlamada();

    public void reset();
}
