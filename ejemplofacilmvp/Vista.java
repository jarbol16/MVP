/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofacilmvp;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Esta vista tiene dos JComboBox. El primero permite elegir las opciones
 * "pares" o "impares". Al seleccionar una de ellas, el segundo combo cambiara
 * sus items a valores 2,4,6.. o a valores 1,3,5...
 * 
 * Sin embargo, siguiendo el patron Modelo-Vista-Presenter, esta Vista no sabe
 * nada de nada, así que no pone ella los items en los combobox ni interactua
 * directamente con el modelo. Unicamente, cuando se selecciona un item en uno
 * de los combos, llama a un metodo del Presentador.
 * 
 * La vista instancia al Presenter y en las llamdas que hace a metodos del
 * Presenter es importante que no pase parametros. A cambio, debe tener metodos
 * get que permitan recoger informacion de la vista, es decir, metodos get que
 * permita saber que hay seleccionado en cada combo.
 * @author JDaniels
 */
public class Vista extends JPanel implements InterfazVista{
    /** Combo de tipo "pares" o "impares" */
    JComboBox comboTipo;
    JLabel txt;

    /** Combo de valores 2,4,6 o bien 1,3,5 */
    JComboBox comboValores;

    /** La clase Presenter, que tiene la logica de todo esto */
    private Presentador presenter;

    /**
     * Pone los combo en el panel e instancia el Presenter
     */
    public Vista(Modelo modelo) {
        this.setBackground(Color.RED);
        setLayout(new GridLayout(2, 2, 3, 4));
        comboTipo = new JComboBox();
        add(comboTipo);
        comboValores = new JComboBox();
        add(comboValores);
        txt = new JLabel();
        add(txt);
        presenter = new Presentador(modelo, this);
        addListeners();
        
    }

    /**
     * Añade los listeners al combo, de forma que cuando el usuario seleccione
     * algo en uno de ellos, simplemente se llama a un metodo del Presenter, sin
     * pasarle nada como parametro.
     */
    private void addListeners() {
        comboTipo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.cambiadoTipo();
                txt.setText(comboTipo.getSelectedItem().toString());
            }
        });

        comboValores.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.cambiadoValor();
            }
        });
    }

    /**
     * Devuelve el tipo seleccionado en el primer combo
     */
    @Override
    public Object getTipo() {
        return comboTipo.getSelectedItem();
    }

    /**
     * Devuelve el valor seleccionado en el segundo combo
     */
    @Override
    public Object getValor() {
        return comboValores.getSelectedItem();
    }

    /**
     * Pone los valores que se le pasan como posibles items del segundo combo,
     * borrando los que hubiera previamente.
     */
    @Override
    public void setPosiblesValores(int[] valores) {
        comboValores.removeAllItems();
        for (int valor : valores)
            comboValores.addItem(valor);
    }

    /**
     * Pone los valores que se le pasan como posibles items del primer combo,
     * borrando los que hubiera previamente.
     */
    @Override
    public void setPosiblesTipos(String[] tipos) {
        comboTipo.removeAllItems();
        for (String tipo : tipos) {
            comboTipo.addItem(tipo);
        }

    }
    
}
