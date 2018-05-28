package ventanas;

import funciones.Recetario;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuiCambiarIng extends JFrame implements ActionListener{
    
    protected JButton bCambiar;
    protected JPanel jPanel;
    
    protected JPanel jPanel2;
    protected JLabel jLabelC;
    protected JTextField tCambiar;
    
    GuiCambiarIng(String title) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
                
        //instanciar los objetos de la ventana
        bCambiar = new JButton("Cambiar");
        jPanel = new JPanel();
        
        jPanel2 = new JPanel();
        jLabelC = new JLabel("Cambiar:");
        tCambiar = new JTextField("nombre");
        
      
        //agregar los comportamientos a los obejtos de loa ventana
        bCambiar.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bCambiar);
        
        jPanel2.add(jLabelC);
        jPanel2.add(tCambiar);
        
        this.add(jPanel);
        this.add(jPanel2);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);
     
     
    }
    
     @Override
    public void actionPerformed(ActionEvent e) { 
        Recetario recetario = new Recetario();
            
        if (e.getSource()== bCambiar) {
            
        }        
    }
    
}
