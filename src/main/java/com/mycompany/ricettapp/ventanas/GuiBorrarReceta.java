package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Recetario;

public class GuiBorrarReceta extends JFrame implements ActionListener {

    protected JPanel jPanel;
    protected JLabel jLabel;
    protected JButton bBorrar;
    protected JTextField t;

    public GuiBorrarReceta(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        jPanel = new JPanel();
        jLabel = new JLabel("Receta:");
        t = new JTextField("nombre");
        bBorrar = new JButton("Borrar");

        bBorrar.addActionListener(this);

        jPanel.add(jLabel);
        jPanel.add(t);
        jPanel.add(bBorrar);

        this.add(jPanel);

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 100);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bBorrar) {
            String receta = t.getText();
            //EN ESTA PARTE SE DEBE ACCEDER AL ARCHIVO Y AHI BUSCAR LA RECETA, PARA BORRARLA.
            Recetario recetario = new Recetario();
            recetario.borrarRecetas(receta);
        }
    }
}
