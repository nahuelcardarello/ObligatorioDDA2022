package iuEscritorio;

/**
 *
 * @author matiasan-ot
 */

import Logica.DatosDePrueba;

public class ObligatorioDDA2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            DatosDePrueba.cargar();
        } catch (Excepciones.Excepcion ex) {
            System.out.println("No se pudo completar la carga de prueba.");
        }
        new VistaAplicacionInicio().setVisible(true);
    }

    
    }
    

