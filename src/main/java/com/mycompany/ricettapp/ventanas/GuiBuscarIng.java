package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiBuscarIng extends JFrame implements ActionListener {

    protected JButton bBuscar;
    protected JPanel jPanel;

    protected JPanel jPanel2;
    protected JLabel jLabelB;
    protected JTextField tBuscar;

    protected JPanel jPanel3;
    protected JLabel jLabelR;
    
    protected JScrollPane areaScrollPane;
    protected JTextArea area;

    GuiBuscarIng(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        //instanciar los objetos de la ventana
        bBuscar = new JButton("Buscar");
        jPanel = new JPanel();

        jPanel2 = new JPanel();
        jLabelB = new JLabel("Busqueda:");
        tBuscar = new JTextField(10);

        jPanel3 = new JPanel();
        jLabelR = new JLabel("Resultado:");
        
        area = new JTextArea();
        areaScrollPane = new JScrollPane(area);
        areaScrollPane.setPreferredSize(new Dimension(100, 100));

        //agregar los comportamientos a los obejtos de loa ventana
        bBuscar.addActionListener(this);

        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        jPanel.add(bBuscar);

        jPanel2.add(jLabelB);
        jPanel2.add(tBuscar);
              
        this.areaScrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        jPanel3.add(jLabelR);
        jPanel3.add(areaScrollPane);  

        this.add(jPanel);
        this.add(jPanel2);
        this.add(jPanel3);
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Recetario recetario = new Recetario();

        if (e.getSource() == bBuscar) {
            if(this.tBuscar.getText().toString().isEmpty()){
            
                JOptionPane.showMessageDialog(null, "Ingrese un ingrediente para realizar la busqueda");
            
            }
            else{
                String ing = this.tBuscar.getText();
                //EN ESTA PARTE SE DEBE ACCEDER AL ARCHIVO Y BUSCAR EL INGREDIENTE, RETORNANDO RECETAS QUE LO CONTENGAN.
                area.setText(recetario.buscarIngrediente(ing));
            }
        }
    }
}
