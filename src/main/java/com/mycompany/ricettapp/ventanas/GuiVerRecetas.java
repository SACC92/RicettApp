package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSONv2;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

    protected JScrollPane menuScrollPane;

    protected JList listaRecetas;

    protected JLabel recetasLB;
    protected JLabel counterLB;
    protected JPanel recetasP;

    protected JPanel verP;
    protected JButton verB;

    protected JPanel areaP;
    protected JTextArea area;
    protected JScrollPane areaScrollPane;
    
    protected JPanel rankP;
    protected JButton rankB;
    
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
            
            if(listModel.contains(recetario.recetas.get(x).getNombre())){}
            
            else{
                
                listModel.addElement(recetario.recetas.get(x).getNombre());
                
            }

        }

        listaRecetas = new JList();
        listaRecetas.setModel(listModel);

        menuScrollPane = new JScrollPane(listaRecetas);
        menuScrollPane.setPreferredSize(new Dimension(100, 100));

        areaP = new JPanel();
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        areaP = new JPanel();
        area = new JTextArea();
        area.setEditable(false);
        areaScrollPane = new JScrollPane(area);
        areaScrollPane.setPreferredSize(new Dimension(200, 150));

        //Para saber la cantidad de recetas almacenadas        
        counterLB = new JLabel(String.valueOf(recetario.verCantidadRecetas()));
        
        //ranking
        this.rankP= new JPanel();
        this.rankB= new JButton("Rankear Receta");
        
        //agregar los comportamientos a los obejtos de loa ventana
        verB.addActionListener(this);
        rankB.addActionListener(this);

        // agregar objetos a la ventana
        recetasP.add(recetasLB);
        recetasP.add(counterLB);

        verP.add(verB);

        areaP.add(areaScrollPane);
        
        rankP.add(rankB);

        this.add(recetasP);
        //para la barra
        this.add(menuScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(verP);
        this.add(areaP);
        this.add(rankP);

        //Configuracion ventana
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                recetario.recetas.clear();
                setVisible(false);
            }
        });
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == verB) {
            int i = listaRecetas.getSelectedIndex();
            mostrar(i);
        }
        
        if(e.getSource()==rankB){
            int indice = listaRecetas.getSelectedIndex();
            if (indice > -1) {
            GuiRankear rankear = new GuiRankear("Rankear Receta",indice);
            rankear.setVisible(true);
            setVisible(false);
            }else{
            JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista","Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrar(int i) {
        
        try{

            Recetario recetario = new Recetario();
            //recetario.recetas.get(i).rankear();
            String saltoLinea = System.getProperty("line.separator");
            area.setText("Los datos de la receta son:" + saltoLinea + recetario.recetas.get(i).toString());

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista","Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}
