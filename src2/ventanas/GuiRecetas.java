/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Recetario;

public class GuiRecetas extends JFrame implements ActionListener{
    
    protected JLabel jLabel1;
    protected JLabel jLabel2;
    protected JPanel jPanel1;
    
    protected JPanel jPanel2;
    protected JButton bVer;
    
    protected JPanel jPanel3;
    protected JList listaRecetas;
    
    protected JPanel jPanel4;
    protected JTextArea area;
    
    
    GuiRecetas(String title) {        
        
        super( title );      
        this.setLayout( new FlowLayout() );       
        
        //instanciar los objetos de la ventana
        jPanel1 = new JPanel();
        bVer = new JButton("Ver receta");
        jPanel2 = new JPanel();
        jLabel1 = new JLabel("Recetas:");        
       
        //para el JList
        Recetario recetario = new Recetario();
        DefaultListModel listModel = new DefaultListModel();  
        for(int x=0; x<recetario.recetas.size();x++){
            listModel.addElement(recetario.recetas.get(x).getNombre());
        }
        listaRecetas = new JList();
        listaRecetas.setModel(listModel);        
        jPanel3= new JPanel();                          
        listaRecetas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
        jPanel4= new JPanel();
        area= new JTextArea();
        area.setSize(200,200);
        
        
        //Para saber la cantidad de recetas almacenadas        
        int cantidad = recetario.VerCantidadRecetas();
        jLabel2 = new JLabel(String.valueOf(cantidad));
      
        //agregar los comportamientos a los obejtos de loa ventana
        bVer.addActionListener(this);
                
        // agregar objetos a la ventana
        // uso de paneles para ordenar la distribucion de objetos en la ventana
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        
        jPanel2.add(bVer);
        
        jPanel3.add(listaRecetas);
        
        jPanel4.add(area);
        
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);  
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bVer){       
            int i= listaRecetas.getSelectedIndex();
            mostrar(i);
        }        
    }
    
    void mostrar(int i){
        Recetario recetario = new Recetario();
        String ingredientes ="";
        for(int x=0; x<recetario.recetas.get(i).getIngredientes().size();x++){
            String ing = recetario.recetas.get(i).getIngredientes().get(x).getNombre();
            ingredientes += "\n" + ing ;
        }      
        String instrucciones="";
        for(int x=0; x<recetario.recetas.get(i).getInstruccion().size();x++){
            String paso = recetario.recetas.get(i).getInstruccion().get(x).getPaso();
            instrucciones +="\n"+ paso;
        }
        
        area.setText("Los datos de la receta son:"+ "\nNombre:"+" "+recetario.recetas.get(i).getNombre() 
                + "\nIngredientes:"+ ingredientes 
                + "\nInstrucciones:"+instrucciones);
    }
}
