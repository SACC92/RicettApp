package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSONv2;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class GuiVerRecetas extends JFrame implements ActionListener {

    
    //EN EL CUADRO DE TEXTO QUE MUESTRA LAS RECETAS PERMITE ESCIRTURA.
    
    protected JScrollPane menuScrollPane;
    protected JScrollPane areaScrollPane;

    protected JList listaRecetas;

    protected JLabel recetasLB;
    protected JLabel counterLB;
    protected JPanel recetasP;

    protected JPanel verP;
    protected JButton verB;

    protected JPanel areaP;
    protected JTextArea area;
    
    public GuiVerRecetas(String title) throws IOException {

        super(title);
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        recetasP = new JPanel();
        verB = new JButton("Ver receta");
        verP = new JPanel();
        recetasLB = new JLabel("Recetas:");

        //para el JList y barra
        Recetario recetario = GestorJSONv2.generarRecetario(GestorJSONv2.vectorLineas());
        DefaultListModel listModel = new DefaultListModel();

        for (int x = 0; x < recetario.recetas.size(); x++) {

            listModel.addElement(recetario.recetas.get(x).getNombre());

        }

        listaRecetas = new JList();
        listaRecetas.setModel(listModel);

        menuScrollPane = new JScrollPane(listaRecetas);
        menuScrollPane.setPreferredSize(new Dimension(100, 100));

        areaP = new JPanel();
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        areaP = new JPanel();
        area = new JTextArea();
        areaScrollPane = new JScrollPane(area);
        areaScrollPane.setPreferredSize(new Dimension(200, 150));

        //Para saber la cantidad de recetas almacenadas        
        counterLB = new JLabel(String.valueOf(recetario.verCantidadRecetas()));

        //agregar los comportamientos a los obejtos de loa ventana
        verB.addActionListener(this);

        // agregar objetos a la ventana
        recetasP.add(recetasLB);
        recetasP.add(counterLB);

        verP.add(verB);

        areaP.add(areaScrollPane);

        this.add(recetasP);
        //para la barra
        this.add(menuScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(verP);
        this.add(areaP);

        //Configuracion ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == verB) {
            int i = listaRecetas.getSelectedIndex();
            mostrar(i);
        }
    }

    void mostrar(int i) {
        if (i > -1) {

            Recetario recetario = new Recetario();
            recetario.recetas.get(i).rankear();
            String saltoLinea = System.getProperty("line.separator");
            area.setText("Los datos de la receta son:" + saltoLinea + recetario.recetas.get(i).toString());
            area.setEditable(false);

        } else {

            JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista");

        }

    }

}
