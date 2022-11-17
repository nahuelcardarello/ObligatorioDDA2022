package Modelo;

import java.time.Duration;

public class Gestores extends TipoCliente {

    @Override
    public float calculoDeCostos(Llamada llamada) {
        float costo;
        float costoFijoGestor = (float) 0.5;
        int cantidadCostosFijosADescontar = (int) Duration.between(llamada.getHoraInicio(), llamada.getHoraComienzoLlamada()).toSeconds();
        costo = llamada.getDuracion() * costoFijoGestor;
        if (llamada.getDuracion() < 90) {
            costo-=cantidadCostosFijosADescontar;
        }
        
        if (costo < 0) {
            costo = 0;
        }
        return costo;
    }

}
