package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSONv2;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiBuscarIng extends JFrame implements ActionListener {
    
    protected JButton buscarB;
    protected JPanel btBuscarP;

    protected JPanel busquedaP;
    protected JLabel busquedaLB;
    protected JTextField busquedaTF;

    protected JPanel resultadoP;
    protected JLabel resultadoLB;

    protected JScrollPane areaScrollPane;
    protected JTextArea area;

    GuiBuscarIng(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        //instanciar los objetos de la ventana
        buscarB = new JButton("Buscar");
        btBuscarP = new JPanel();

        busquedaP = new JPanel();
        busquedaLB = new JLabel("Busqueda:");
        busquedaTF = new JTextField(10);

        resultadoP = new JPanel();
        resultadoLB = new JLabel("Resultado:");

        area = new JTextArea();
        area.setEditable(false);
        areaScrollPane = new JScrollPane(area);
        areaScrollPane.setPreferredSize(new Dimension(100, 100));

        //agregar los comportamientos a los obejtos de loa ventana
        buscarB.addActionListener(this);

        // agregar objetos a la ventana
        btBuscarP.add(buscarB);

        busquedaP.add(busquedaLB);
        busquedaP.add(busquedaTF);

        this.areaScrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        resultadoP.add(resultadoLB);
        resultadoP.add(areaScrollPane);

        this.add(btBuscarP);
        this.add(busquedaP);
        this.add(resultadoP);

        //Configuración ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Recetario recetario = new Recetario();

        if (e.getSource() == buscarB) {
            if (this.busquedaTF.getText().toString().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese un ingrediente para realizar la busqueda");

            } else {                
                
                String ing = this.busquedaTF.getText();                
                //EN ESTA PARTE SE DEBE ACCEDER AL ARCHIVO Y BUSCAR EL INGREDIENTE, RETORNANDO RECETAS QUE LO CONTENGAN.
                GestorJSONv2 gestor = new GestorJSONv2();
                 ArrayList<String>lineas;
                try {
                   lineas = gestor.vectorLineas();
                   gestor.generarRecetario(lineas); 
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la busqueda","Error", JOptionPane.ERROR_MESSAGE);
                } 
                area.setText(recetario.buscarIngrediente(ing));

            }
        }
    }
}
