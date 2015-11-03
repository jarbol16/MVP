/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofacilmvp;

/**
 *Interfaz que implementa a vista
 * Aqui estan los metroso que necesita el Presentador
 * @author JDaniels
 */
public interface InterfazVista {
    
    /**Devuelve e tipo seleccionado en el primer ComboBox */
    Object getTipo();
    
    /*Devuelve el valor seleccionado en el segundo CombBox */
    Object getValor();
    
    /** Pasa los posibles valores al segundo combo box */
    void setPosiblesValores(int[] valores);

    /** Pasa los posibles tipos al primer combo box */
    void setPosiblesTipos(String[] tipos);
    
}
