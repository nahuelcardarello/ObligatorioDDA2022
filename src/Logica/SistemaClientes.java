/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author matiasan-ot
 */
public class SistemaClientes {

    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void agregarCliente(Cliente c) {
        if (c != null) {
            clientes.add(c);
        }
    }

    public Cliente buscarCliente(String CI) {
        Cliente unC = null;
        int i = 0;
        while (i < clientes.size() && unC == null) {
            Cliente c = clientes.get(i);
            if (c.getCI().equalsIgnoreCase(CI)) {
                unC = c;
            }
            i++;
        }
        return unC;
    }



}
