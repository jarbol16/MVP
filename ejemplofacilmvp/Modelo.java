/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofacilmvp;

/**
 * Es una clase sencilla para el ejemplo y sabe que numeros son pares o impares.
 * 
 * @author JDaniels
 */
public class Modelo {
    /** Tipo pares */
    public static final String PARES = "PARES";

    /** Tipo impares */
    public static final String IMPARES = "IMPARES";
    
    /**Tipo primos */
    public static final String PRIMOS = "PRIMOS";

    /** Posibles valores pares */
    private static final int[] pares = { 2, 4, 6, 8, 10, 12, 14 };

    /** Posibles valores impares */
    private static final int[] impares = { 1, 3, 5, 7, 9, 11, 13, 15};
    
    /** Pisibles valores primos */
    private static final int[] primos = {2, 3, 5, 7, 11, 13};

    /**
     * Devuelve los posibles valores segun el tipo que se le pase.
     * 
     * @param tipo
     *            PARES o IMPARES
     * @return array de valores pares o impares. null si no el tipo no es PARES
     *         o IMPARES
     */
    public int[] getPosiblesValores(String tipo) {
        if (PARES.equals(tipo))
            return pares;
        if (IMPARES.equals(tipo))
            return impares;
        if(PRIMOS.equals(tipo))
            return primos;
        return null;
    }
}
