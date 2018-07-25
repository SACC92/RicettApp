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
import javax.swing.ListSelectionModel;

 public class GuiBorrarRecetas extends JFrame implements ActionListener {
    
    protected JScrollPane menuScrollPane;

    protected JList listaRecetas;

    protected JLabel recetasLB;
    protected JLabel counterLB;
    protected JPanel recetasP;

    protected JPanel borrarP;
    protected JButton borrarB;
    
    public GuiBorrarRecetas(String title) throws IOException {

        super(title);
        FlowLayout layout = new FlowLayout();
        this.setLayout(layout);

        recetasP = new JPanel();
        borrarB = new JButton("Borrar Receta");
        borrarP = new JPanel();
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

        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Para saber la cantidad de recetas almacenadas        
        counterLB = new JLabel(String.valueOf(recetario.verCantidadRecetas()));

        //agregar los comportamientos a los obejtos de loa ventana
        borrarB.addActionListener(this);

        // agregar objetos a la ventana
        recetasP.add(recetasLB);
        recetasP.add(counterLB);

        borrarP.add(borrarB);

        this.add(recetasP);
        //para la barra
        this.add(menuScrollPane);
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.add(borrarP);

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

        if (e.getSource() == borrarB) {
            
            try{
                
                int i = listaRecetas.getSelectedIndex();
                borrar(i);

            }
            catch(IOException exc){}
        }
    }

    void borrar(int i) throws IOException {
        
        if (i > -1) {

            try{
                
                Recetario recetario = new Recetario();
                recetario.recetas.remove(i);
                GestorJSONv2.borrarRecetaArchivo(listaRecetas.getName());
                JOptionPane.showMessageDialog(null, "Receta borrada exitosamente");
                ((DefaultListModel) listaRecetas.getModel()).remove(i);
                counterLB.setText(String.valueOf(recetario.verCantidadRecetas()));
                
            }
                catch(IOException e){}

        } else {

            JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista");

        }

    }

}