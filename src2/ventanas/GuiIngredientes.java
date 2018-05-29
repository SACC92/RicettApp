package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiIngredientes extends JFrame implements ActionListener{
    
    protected JButton bBuscarIng;
    protected JButton bCambiarIng;
    protected JPanel jPanel;
    
    GuiIngredientes(String title) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
                
        //instanciar los objetos de la ventana
        bBuscarIng = new JButton("Buscar Ingrediente");
        bCambiarIng = new JButton("Cambiar Ingrediente");
        jPanel = new JPanel();
        
      
        //agregar los comportamientos a los obejtos de loa ventana
        bBuscarIng.addActionListener(this);
        bCambiarIng.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bBuscarIng);
        jPanel.add(bCambiarIng);
        
        this.add(jPanel);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);    
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            
        if (e.getSource()== bBuscarIng) {
            GuiBuscarIng buscar = new GuiBuscarIng("Buscar Ingrediente");
            buscar.setVisible(true);            
        }
        if (e.getSource()== bCambiarIng){
            GuiCambiarIng cambiar = new GuiCambiarIng("Cambiar Ingrediente");
            cambiar.setVisible(true);
        }
    }
}
