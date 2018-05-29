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

public class GuiCambiarIngAntiguos extends JFrame implements ActionListener{
    
    protected JButton bCambiar;
    protected JPanel jPanel;
    
    protected JPanel jPanel2;
    protected JList listaIngredientes;
    
    protected JPanel jPanel3;
    protected JLabel jLabelIN;
    protected JTextField tNuevo;
    //creación de otro atributo, para saber de que receta es
    private int posicion;
    
    GuiCambiarIngAntiguos(String title, int i) {
        
        super( title );      
        this.setLayout( new FlowLayout() );
        
        posicion =i;
                
        //instanciar los objetos de la ventana
        bCambiar = new JButton("Cambiar");
        jPanel = new JPanel();
        
        jPanel2 = new JPanel();
        //para el JList
        Recetario recetario = new Recetario();
        DefaultListModel listModel = new DefaultListModel();  
        for(int x=0; x<recetario.recetas.get(i).getIngredientes().size();x++){
            listModel.addElement(recetario.recetas.get(i).getIngredientes().get(x).getNombre());
        }
        listaIngredientes = new JList();
        listaIngredientes.setModel(listModel);                  
        listaIngredientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jPanel3 = new JPanel();
        jLabelIN= new JLabel("Ingrediente nuevo");
        tNuevo = new JTextField("ingrediente");
      
        //agregar los comportamientos a los objetos de loa ventana
        bCambiar.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        
        jPanel.add(bCambiar);
        
        jPanel2.add(listaIngredientes);
        
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
        
        if (e.getSource()== bCambiar) {   
            int j = listaIngredientes.getSelectedIndex();
            cambiar(j);
        }       
    }
    void cambiar(int j){
        //j es el ingrediente seleccionado para cambiar
        Recetario recetario = new Recetario();
        recetario.recetas.get(getPosicion()).getIngredientes().get(j).setNombre(tNuevo.getText());
    }
    
    public int getPosicion(){
        return posicion;
    }
}
