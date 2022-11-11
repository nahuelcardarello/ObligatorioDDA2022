package Logica;

import Excepciones.Excepcion;
import Modelo.Cliente;
import Modelo.Sector;
import Modelo.Trabajador;

public class DatosdePrueba {

    public static void cargar() throws Excepcion {

        //Precarga Sectores
        Sector s1 = new Sector();
        s1.setCantidadPuestos(1);
        s1.setNombre("Ventas");
        s1.setNumero(1);

        Sector s2 = new Sector();
        s2.setCantidadPuestos(2);
        s2.setNombre("Postventa");
        s2.setNumero(1);

        Sector s3 = new Sector();
        s3.setCantidadPuestos(2);
        s3.setNombre("Servicio técnico");
        s3.setNumero(1);

        Fachada.getInstancia().AgregarSector(s1);
        Fachada.getInstancia().AgregarSector(s2);
        Fachada.getInstancia().AgregarSector(s3);

        // Precarga Trabajadores
        Trabajador t1 = new Trabajador();
        t1.setNombreCompleto("Matias Andrade");
        t1.setContrasena("1234");
        t1.setCI("11111111");
        t1.setSector(s1);

        Trabajador t2 = new Trabajador();
        t2.setNombreCompleto("Guillermo Recoba");
        t2.setContrasena("1234");
        t2.setCI("22222222");
        t2.setSector(s2);

        Trabajador t3 = new Trabajador();
        t3.setNombreCompleto("Nahuel Cardarello");
        t3.setContrasena("1234");
        t3.setCI("33333333");
        t3.setSector(s3);

        Fachada.getInstancia().AgregarTrabajador(t1);
        Fachada.getInstancia().AgregarTrabajador(t2);
        Fachada.getInstancia().AgregarTrabajador(t3);

    }

}
