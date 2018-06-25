package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.Gestor;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class GuiVerRecetas extends JFrame implements ActionListener {

    private JScrollPane menuScrollPane;
    private JScrollPane areaScrollPane;

    protected JList listaRecetas;

    protected JLabel jLabel1;
    protected JLabel jLabel2;
    protected JPanel jPanel1;

    protected JPanel jPanel2;
    protected JButton bVer;

    protected JPanel jPanel3;
    protected JTextArea area;

    protected Gestor gestor;

    public GuiVerRecetas(String title) {
        super(title);

        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        jPanel1 = new JPanel();
        bVer = new JButton("Ver receta");
        jPanel2 = new JPanel();
        jLabel1 = new JLabel("Recetas:");

//para el JList y barra

        Recetario recetario = new Recetario();
        DefaultListModel listModel = new DefaultListModel();
        for (int x = 0; x < recetario.recetas.size(); x++) {
            listModel.addElement(recetario.recetas.get(x).getNombre());
        }
        listaRecetas = new JList();
        listaRecetas.setModel(listModel);

        menuScrollPane = new JScrollPane(listaRecetas);
        menuScrollPane.setPreferredSize(new Dimension(100, 100));

        jPanel3 = new JPanel();
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jPanel3 = new JPanel();
        area = new JTextArea();
        areaScrollPane = new JScrollPane(area);
        areaScrollPane.setPreferredSize(new Dimension(100, 100));

        //Para saber la cantidad de recetas almacenadas        
        int cantidad = recetario.verCantidadRecetas();
        jLabel2 = new JLabel(String.valueOf(cantidad));

        //agregar los comportamientos a los obejtos de loa ventana
        bVer.addActionListener(this);

        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);

        jPanel2.add(bVer);

        jPanel3.add(areaScrollPane);

        this.add(jPanel1);
        //para la barra
        this.add(menuScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //
        this.add(jPanel2);
        this.add(jPanel3);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        this.setVisible(true);

        gestor = new Gestor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bVer) {
            int i = listaRecetas.getSelectedIndex();
            mostrar(i);
        }
    }

    void mostrar(int i) {
        if (i > -1) {
            Recetario recetario = new Recetario();
           recetario.recetas.get(i).rankear();
            String saltoLinea = System.getProperty("line.separator");
            area.setText("Los datos de la receta son:"+saltoLinea+ recetario.recetas.get(i).toString());
        } else {
            area.setText("Seleccione una receta de la lista"
                    + "\npara poder realizar esta acción");
        }
    }
}
