package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiMain extends JFrame implements ActionListener {

    protected JButton bVerRecetas;
    protected JButton bAgregarReceta;
    protected JButton bBorrarReceta;
    protected JButton bIngredientes;
    protected JPanel jPanel;

    GuiMain(String title) {

        super(title);
        this.setLayout(new FlowLayout());
        
        //instanciar los objetos de la ventana
        bVerRecetas = new JButton("Ver Recetas");
        bAgregarReceta = new JButton("Agregar Receta");
        bBorrarReceta = new JButton("Borrar Receta");
        bIngredientes = new JButton("Buscar Ingredientes");
        jPanel = new JPanel();

        //agregar los comportamientos a los obejtos de loa ventana
        bVerRecetas.addActionListener(this);
        bAgregarReceta.addActionListener(this);
        bBorrarReceta.addActionListener(this);
        bIngredientes.addActionListener(this);

        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        jPanel.add(bVerRecetas);
        jPanel.add(bAgregarReceta);
        jPanel.add(bBorrarReceta);
        jPanel.add(bIngredientes);

        this.add(jPanel);

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bVerRecetas) {

            GuiVerRecetas ventRecet = new GuiVerRecetas("Ver Recetas");
            ventRecet.setVisible(true);
        }
        if (e.getSource() == bAgregarReceta) {

            GuiAdd ventana = new GuiAdd("Agregar Receta");
            ventana.setVisible(true);
        }
        if (e.getSource() == bBorrarReceta) {

            GuiBorrarReceta ventB = new GuiBorrarReceta("Borrar Receta");
            ventB.setVisible(true);
        }
        if (e.getSource() == bIngredientes) {

            GuiBuscarIng buscar = new GuiBuscarIng("Buscar Ingrediente");
            buscar.setVisible(true);
        }
    }
}
