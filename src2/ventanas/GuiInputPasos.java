package ventanas;

/**
 *
 * @author Jekill
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import funciones.Ingrediente;
import funciones.Instruccion;

import funciones.Receta;
import funciones.Recetario;

public class GuiInputPasos extends JFrame implements ActionListener {
    
    protected JPanel jPanel1;
    protected JLabel jLabel1;    
    protected JTextField t1;
    
    protected JPanel jPanel2;
    protected JTextField t2;
    protected JLabel jLabel2;    
    protected JButton bNumIng;
    
    protected JPanel jPanel3;
    protected JLabel jLabel3;
    protected JTextField t3;
    protected JButton bNumPasos;    
    
    protected JPanel jPanel4;
    protected JButton bAgregar;
    
    
    public GuiInputPasos(String title){
        
        super(title);
        this.setLayout( new FlowLayout() );  
        
        bAgregar = new JButton("Agregar Instrucción");
        bAgregar.addActionListener(this);

        t1 = new JTextField("instrucción");

        jPanel1= new JPanel();

        jPanel4= new JPanel();
        
        jPanel1.add(t1);
        
        jPanel4.add(bAgregar);   
        
        this.add(jPanel1);

        this.add(jPanel4);
        
        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,150);
        setLocationRelativeTo(null);
        setResizable(false);
        
    }
    public void actionPerformed(ActionEvent e) {    

        Receta receta = new Receta();
        Instruccion instruccion = new Instruccion();
        
        if(e.getSource()==bAgregar){

            instruccion.setPaso(t1.getText());
            
            receta.getInstruccion().add(instruccion);

        }
        
    }
    
    
    
}

    
    

