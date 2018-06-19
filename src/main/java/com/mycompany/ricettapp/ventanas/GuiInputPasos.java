package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Instruccion;
import funciones.Receta;
import funciones.Recetario;

public class GuiInputPasos extends JFrame implements ActionListener {

    protected JPanel jPanel1;
    protected JLabel jLabel1;
    protected JTextField t1;
    protected JButton bAgregar;

    protected JPanel jPanel2;
    protected JButton bGuardar;

    protected Receta receta;

    public GuiInputPasos(String title, Receta receta) {

        super(title);
        this.setLayout(new FlowLayout());

        bAgregar = new JButton("Agregar Instrucción");
        bAgregar.addActionListener(this);
        t1 = new JTextField("instrucción");
        jPanel1 = new JPanel();

        jPanel1.add(t1);
        jPanel1.add(bAgregar);

        bGuardar = new JButton("Guardar");
        bGuardar.addActionListener(this);
        jPanel2 = new JPanel();

        jPanel2.add(bGuardar);

        this.add(jPanel1);
        this.add(jPanel2);

        this.receta = receta;

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 150);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void actionPerformed(ActionEvent e) {
        Instruccion instruccion = new Instruccion();

        if (e.getSource() == bAgregar) {
            instruccion.setPaso(t1.getText());
            this.receta.getInstruccion().add(instruccion);
        }

        if (e.getSource() == bGuardar) {
            Recetario recetario = new Recetario();
            recetario.recetas.add(receta);
            setVisible(false);
        }
    }
}
