package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class GuiPrincipal extends JFrame implements ActionListener {

    protected JButton verRecetasB;
    protected JButton agregarRecetaB;
    protected JButton borrarRecetaB;
    protected JButton ingredientesB;
    protected JPanel botoneraP;

    GuiPrincipal(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        //instanciar los objetos de la ventana
        verRecetasB = new JButton("Ver Recetas");
        agregarRecetaB = new JButton("Agregar Receta");
        borrarRecetaB = new JButton("Borrar Receta");
        ingredientesB = new JButton("Buscar Ingredientes");
        botoneraP = new JPanel();

        //agregar los comportamientos a los obejtos de loa ventana
        verRecetasB.addActionListener(this);
        agregarRecetaB.addActionListener(this);
        borrarRecetaB.addActionListener(this);
        ingredientesB.addActionListener(this);

        // agregar objetos a la ventana
        botoneraP.add(verRecetasB);
        botoneraP.add(agregarRecetaB);
        botoneraP.add(borrarRecetaB);
        botoneraP.add(ingredientesB);

        this.add(botoneraP);

        //Configuracion de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == verRecetasB) {
            
            try{
                
                GuiVerRecetas ventRecet = new GuiVerRecetas("Ver Recetas");
                ventRecet.setVisible(true);
                
            }catch(IOException ioe){}
        }
        if (e.getSource() == agregarRecetaB) {
            GuiAdd ventana = new GuiAdd("Agregar Receta");
            ventana.setVisible(true);
        }
        if (e.getSource() == borrarRecetaB) {
            
            try{
            GuiBorrarRecetas ventB = new GuiBorrarRecetas("Borrar Receta");
            ventB.setVisible(true);
            }
            catch(IOException io){}
        }
        if (e.getSource() == ingredientesB) {
            GuiBuscarIng buscar = new GuiBuscarIng("Buscar Ingrediente");
            buscar.setVisible(true);
        }
    }
}
