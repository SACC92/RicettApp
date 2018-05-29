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
    protected JLabel jLabelN;
    protected JTextField tNombre;
    
    protected JPanel jPanel3;
    protected JLabel jLabelIN;//letra i
    protected JTextField tNuevo;
    
    GuiCambiarIng(String title) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
                
        //instanciar los objetos de la ventana
        bCambiar = new JButton("Cambiar");
        jPanel = new JPanel();
        
        jPanel2 = new JPanel();
        jLabelN = new JLabel("Receta:");
        tNombre = new JTextField("nombre");
        
        jPanel3 = new JPanel();
        jLabelIN= new JLabel("Ingrediente nuevo");
        tNuevo = new JTextField("ingrediente");
      
        //agregar los comportamientos a los objetos de loa ventana
        bCambiar.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bCambiar);
        
        jPanel2.add(jLabelN);
        jPanel2.add(tNombre);
        
        jPanel3.add(jLabelIN);
        jPanel3.add(tNuevo);
        
        this.add(jPanel);
        this.add(jPanel2);
        this.add(jPanel3);
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);         
    }
    
     @Override
    public void actionPerformed(ActionEvent e) { 
        
        Recetario recetario = new Recetario();    
        
        if (e.getSource()== bCambiar) {
            String nombre = tNombre.getText();
            String nuevo = tNuevo.getText();
            for(int x=0; x< recetario.recetas.size();x++){                
                if(nombre.equals(recetario.recetas.get(x).getNombre())){
                    for(int y=0; y<recetario.recetas.get(x).getIngredientes().size();y++){                        
                        recetario.recetas.get(x).getIngredientes().get(y).setNombre(nuevo);
                    }
                }
            }
        }        
    }    
    
}
