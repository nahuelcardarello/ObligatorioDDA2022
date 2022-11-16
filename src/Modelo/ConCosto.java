package Modelo;

public class ConCosto extends TipoCliente {

    @Override
    public float calculoDeCostos(Llamada llamada) {
        float costo = 0;
        if (llamada.unMinutoDeTiempoDeEspera()) {
            costo = (llamada.getDuracion() * llamada.getCostoPorSegundo()) / 2;
        } else {
            costo = (llamada.getDuracion() * llamada.getCostoPorSegundo());
        }
        if (costo < 0) {
            costo = 0;
        }
        return costo;
    }
}
