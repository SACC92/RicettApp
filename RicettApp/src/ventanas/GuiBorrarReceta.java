package Ventana;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Recetario;

public class GuiBorrarReceta extends JFrame implements ActionListener{
    
    protected JPanel jPanel;
    protected JLabel jLabel;
    protected JButton bBorrar;
    protected JTextField t;
    
    public GuiBorrarReceta(String title){
        
        super(title);
        this.setLayout( new FlowLayout() );
        
        jPanel = new JPanel();
        jLabel = new JLabel("Receta:");
        t= new JTextField();
        bBorrar = new JButton("Borrar");
        
        bBorrar.addActionListener(this);
        
        jPanel.add(jLabel);
        jPanel.add(t);
        jPanel.add(bBorrar);
        
        this.add(jPanel);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,100);
        setLocationRelativeTo(null);
    } 
        
    public void actionPerformed(ActionEvent e) {        
                
        if(e.getSource()==bBorrar){
            String receta = t.getText();
            Recetario recetario = new Recetario();
            
            for(int x=0; x<recetario.recetas.size();x++){
                if(recetario.recetas.get(x).getNombre().equals(t.getText())){
                    recetario.recetas.remove(x); 
                }
            }           
        }         
    }
}
