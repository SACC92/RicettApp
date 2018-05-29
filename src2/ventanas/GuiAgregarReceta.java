package ventanas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Ingrediente;
import funciones.Instruccion;

import funciones.Receta;
import funciones.Recetario;

public class GuiAgregarReceta extends JFrame implements ActionListener{
        
    protected JPanel jPanel1;
    protected JLabel jLabel1;    
    protected JTextField t1;
    
    protected JPanel jPanel2;
    protected JTextField t2;
    protected JLabel jLabel2;    
    
    protected JPanel jPanel3;
    protected JLabel jLabel3;
    protected JTextField t3;    
    
    protected JPanel jPanel4;
    protected JButton bAgregar;
    
    public GuiAgregarReceta(String title){
        
        super(title);
        this.setLayout( new FlowLayout() );  
        
        bAgregar = new JButton("Agregar Receta");
        bAgregar.addActionListener(this);
        
        jLabel1 = new JLabel("Nombre");
        jLabel2 = new JLabel("Ingrediente");
        jLabel3 = new JLabel("Instruccion o paso");
        
        t1 = new JTextField("nombre");
        t2 = new JTextField("ingrediente");
        t3 = new JTextField("instruccion");
        
        jPanel1= new JPanel();
        jPanel2= new JPanel();
        jPanel3= new JPanel();
        jPanel4= new JPanel();
        
        jPanel1.add(jLabel1);
        jPanel1.add(t1);
        
        jPanel2.add(jLabel2);
        jPanel2.add(t2);
        
        jPanel3.add(jLabel3);
        jPanel3.add(t3);
        
        jPanel4.add(bAgregar);
        
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,150);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    public void actionPerformed(ActionEvent e) {    
        
        if(e.getSource()==bAgregar){
            
            Recetario recetario = new Recetario();
            Receta receta = new Receta();
            Ingrediente ingrediente = new Ingrediente();
            Instruccion instruccion = new Instruccion();
        
            String nombre = t1.getText();
            ingrediente.setNombre(t2.getText());
            instruccion.setPaso(t3.getText());
        
            receta.setNombre(nombre);
            receta.getIngredientes().add(ingrediente);
            receta.getInstruccion().add(instruccion);
            recetario.recetas.add(receta);
        }
        
    }
}
