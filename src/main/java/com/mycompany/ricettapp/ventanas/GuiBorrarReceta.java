package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.ricettapp.funciones.Recetario;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class GuiBorrarReceta extends JFrame implements ActionListener{

            private JScrollPane menuScrollPane;
            private JScrollPane areaScrollPane;
        
            protected JList listaRecetas;
        
            protected JLabel jLabel1;
            protected JLabel jLabel2;
            protected JPanel jPanel1;

            protected JPanel jPanel2;
            protected JButton bBorrar;

            protected JPanel jPanel3;
            protected JTextArea area;

        public GuiBorrarReceta(String title) {
                super(title);
                
		FlowLayout layout = new FlowLayout();                
		this.setLayout(layout);
                
                jPanel1 = new JPanel();
                bBorrar = new JButton("Borrar Receta");
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
                menuScrollPane.setPreferredSize(new Dimension(100,100));
                 //
                
                jPanel3 = new JPanel();
                listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                jPanel3 = new JPanel();
                area = new JTextArea();                
                areaScrollPane = new JScrollPane(area);
                areaScrollPane.setPreferredSize(new Dimension(100,100));

                //Para saber la cantidad de recetas almacenadas        
                int cantidad = recetario.verCantidadRecetas();
                jLabel2 = new JLabel(String.valueOf(cantidad));

                //agregar los comportamientos a los obejtos de loa ventana
                bBorrar.addActionListener(this);

                // agregar objetos a la ventana
                // uso de paneles para ordenar la distribucion de objetos en la ventana
                jPanel1.add(jLabel1);
                jPanel1.add(jLabel2);

                jPanel2.add(bBorrar);

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
    }
         @Override
        public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == bBorrar) {          
            int i = listaRecetas.getSelectedIndex();
            borrar(i); 
        }
    }
	
	void borrar(int i){         
        try{
        Recetario recetario = new Recetario();
        
        recetario.recetas.remove(i);
        
        JOptionPane.showMessageDialog(null, "Receta borrada exitosamente");
        
         }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "Seleccione una receta de la lista");
            } 
    }
}
