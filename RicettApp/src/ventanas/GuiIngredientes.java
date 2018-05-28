package Ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import funciones.Recetario;

public class GuiIngredientes extends JFrame implements ActionListener{
    
    protected JButton bBuscarIng;
    protected JButton bCambiarIng;
    protected JPanel jPanel;
    
    protected JPanel jPanel2;
    protected JLabel jLabelB;
    protected JLabel jLabelC;
    protected JTextField tBuscar;
    protected JTextField tCambiar;
    
    GuiIngredientes(String title) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
                
        //instanciar los objetos de la ventana
        bBuscarIng = new JButton("Buscar Ingrediente");
        bCambiarIng = new JButton("Cambiar Ingrediente");
        jPanel = new JPanel();
        
        jPanel2 = new JPanel();
        jLabelB = new JLabel("Busqueda");
        jLabelC = new JLabel("Cambiar");
        tBuscar = new JTextField();
        tCambiar= new JTextField();
        
      
        //agregar los comportamientos a los obejtos de loa ventana
        bBuscarIng.addActionListener(this);
        bCambiarIng.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bBuscarIng);
        jPanel.add(bCambiarIng);
        
        jPanel2.add(jLabelB);
        jPanel2.add(tBuscar);
        jPanel2.add(jLabelC);
        jPanel2.add(tCambiar);
        
        this.add(jPanel);
        this.add(jPanel2);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
     
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        
        Recetario recetario = new Recetario();
            
        if (e.getSource()== bBuscarIng) {             
            String b = this.tBuscar.getText();
            /*
            recetario.Buscar(b);            
            */
        }
        if (e.getSource()== bCambiarIng){            
            String c =this.tCambiar.getText();    
            /*
            recetario.MostrarAllRecetas();
            recetario.CambiarIng();
            */
        }
    }
}
