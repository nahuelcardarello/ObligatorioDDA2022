/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author Dario
 */
public interface Observador {
    
    public enum Eventos {
        INICIAR_LLAMADA,
        FINALIZAR_LLAMADA,
        QUITAR_DE_ESPERA
    }
    public void actualizar(Object evento,Observable origen);
    
}
