package Modelo;

import Logica.SistemaClientes;
import Modelo.TipoCliente;
import java.util.ArrayList;
import java.util.Collection;

public class Cliente {

    private String CI;

    private String nombrecompleto;

    private float saldo;

    private ArrayList<Llamada> llamadas;

    private TipoCliente tipoCliente;

    public float calculoDeCostos(Llamada llamada) {
        return tipoCliente.calculoDeCostos(llamada);
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(ArrayList<Llamada> llamada) {
        this.llamadas = llamada;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    void descontarCosto(float costoTotal) {
        if (costoTotal>saldo) {
            saldo=0;
        }
        saldo-=costoTotal;
    }

}
