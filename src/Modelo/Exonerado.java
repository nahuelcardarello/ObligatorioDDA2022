package Modelo;

import Logica.Cliente;

public class Exonerado extends Cliente, TipoCliente {

	public float calculoDeCostos(int duracion) {
		return 0;
	}

}
