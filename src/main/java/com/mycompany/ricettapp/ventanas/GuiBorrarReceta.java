package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class GuiBorrarReceta extends JFrame implements ActionListener {

    private JScrollPane menuScrollPane;
    protected JList listaRecetas;

    protected JPanel counterP;
    protected JLabel recetasLB;
    protected JLabel counterLB;

    protected JPanel borrarP;
    protected JButton borrarB;

    GuiBorrarReceta(String title) {

        super(title);

        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        counterP = new JPanel();
        borrarB = new JButton("Borrar Receta");
        borrarP = new JPanel();
        recetasLB = new JLabel("Recetas:");

        //para el JList y barra
        Recetario recetario = new Recetario();
        DefaultListModel listModel = new DefaultListModel();

        for (int x = 0; x < recetario.recetas.size(); x++) {

            listModel.addElement(recetario.recetas.get(x).getNombre());

        }

        listaRecetas = new JList();
        listaRecetas.setModel(listModel);
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        menuScrollPane = new JScrollPane(listaRecetas);
        menuScrollPane.setPreferredSize(new Dimension(100, 100));

        //Para saber la cantidad de recetas almacenadas        
        counterLB = new JLabel(String.valueOf(recetario.verCantidadRecetas()));

        //agregar los comportamientos a los obejtos de loa ventana
        borrarB.addActionListener(this);

        // agregar objetos a la ventana
        counterP.add(recetasLB);
        counterP.add(counterLB);

        borrarP.add(borrarB);

        this.add(counterP);
        //para la barra
        this.add(menuScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(borrarP);

        //Configuracion Ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == borrarB) {

            int i = listaRecetas.getSelectedIndex();
            borrar(i);

        }

    }

    void borrar(int i) {
        try {

            Recetario recetario = new Recetario();
            recetario.recetas.remove(i);
            JOptionPane.showMessageDialog(null, "Receta borrada exitosamente");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista");

        }

    }

}
