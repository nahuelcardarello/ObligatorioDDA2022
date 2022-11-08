package Modelo;

import Logica.SistemaClientes;
import Modelo.TipoCliente;
import java.util.Collection;

public class Cliente {

	private String CI;

	private String nombrecompleto;

	private float saldo;

	private Collection<Llamada> llamada;

	private TipoCliente tipoCliente;

	private SistemaClientes sistemaClientes;

	public float calculoDeCostos(int duracion) {
		return 0;
	}

}
