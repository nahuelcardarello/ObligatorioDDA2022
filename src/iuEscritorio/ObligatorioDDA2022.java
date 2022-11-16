package iuEscritorio;

/**
 *
 * @author matiasan-ot
 */

import Logica.DatosdePrueba;
import Excepciones.Excepcion;
import Excepciones.LlamadaException;

public class ObligatorioDDA2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LlamadaException {

        try {
            DatosdePrueba.cargar();
        } catch (Excepcion ex) {
            System.out.println("No se pudo completar la carga de prueba.");
        }
        new VistaAplicacionInicio().setVisible(true);
    }

    
    }
    

