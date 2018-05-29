package ventanas;

import funciones.Recetario;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class GuiCambiarIng extends JFrame implements ActionListener{
    
    protected JButton bCambiar;
    protected JPanel jPanel;
    
    protected JPanel jPanel2;
    protected JList listaRecetas;
    
    GuiCambiarIng(String title) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
                
        //instanciar los objetos de la ventana
        bCambiar = new JButton("Cambiar");
        jPanel = new JPanel();
        
        jPanel2 = new JPanel();
        //para el JList
        Recetario recetario = new Recetario();
        DefaultListModel listModel = new DefaultListModel();  
        for(int x=0; x<recetario.recetas.size();x++){
            listModel.addElement(recetario.recetas.get(x).getNombre());
        }
        listaRecetas = new JList();
        listaRecetas.setModel(listModel);                  
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
        //agregar los comportamientos a los objetos de loa ventana
        bCambiar.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bCambiar);
        
        jPanel2.add(listaRecetas);
        
        this.add(jPanel);
        this.add(jPanel2);
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,200);
        setLocationRelativeTo(null);         
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {    
        
        if (e.getSource()== bCambiar) {
            int i = listaRecetas.getSelectedIndex();
            GuiCambiarIngAntiguos ing = new GuiCambiarIngAntiguos("Cambiar",i);
            ing.setVisible(true);
        }       
    }  
}
