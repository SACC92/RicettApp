package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.Gestor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog;
import javax.swing.*;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Recetario;

public class GuiAdd extends JFrame implements ActionListener{
   
    protected JPanel nombreP;
    protected JLabel nombreLB;
    protected JTextField nombreTF;

    protected JPanel ingredienteP;
    protected JLabel ingredienteLB;
    protected JTextField ingredienteTF;
    protected JButton ingredienteB;

    protected JPanel instruccionP;
    protected JLabel instruccionLB;
    protected JTextField instruccionTF;
    protected JButton instruccionB;

    protected JPanel guardarP;
    protected JButton guardarB;
    
    protected Receta receta;
    protected Gestor gestor;

    
    
    public GuiAdd(String titulo) {

        super(titulo);
        this.setLayout(new FlowLayout());

        nombreP = new JPanel();
        nombreLB = new JLabel("Nombre");
        nombreTF = new JTextField(10);

        ingredienteP = new JPanel();
        ingredienteLB = new JLabel("Ingrediente");
        ingredienteTF = new JTextField(20);
        ingredienteB = new JButton("Añadir Ingrediente");

        instruccionP = new JPanel();
        instruccionLB = new JLabel("Instrucción");
        instruccionTF = new JTextField(20);
        instruccionB = new JButton("Añadir Instrucción");

        guardarP = new JPanel();
        guardarB = new JButton("Guardar");

        nombreP.add(nombreLB);
        nombreP.add(nombreTF);

        ingredienteP.add(ingredienteLB);
        ingredienteP.add(ingredienteTF);
        ingredienteP.add(ingredienteB);

        instruccionP.add(instruccionLB);
        instruccionP.add(instruccionTF);
        instruccionP.add(instruccionB);

        guardarP.add(guardarB);

        this.add(nombreP);
        this.add(ingredienteP);
        this.add(instruccionP);
        this.add(guardarP);
        
        guardarB.addActionListener(this);
        instruccionB.addActionListener(this);
        ingredienteB.addActionListener(this);
       
        receta = new Receta();
        gestor = new Gestor();

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 150);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        

        if (e.getSource() == guardarB) {

            if (nombreTF.getText().isEmpty() || receta.ingredientes.isEmpty() || receta.instrucciones.isEmpty()) {

                //PopUp de error por campos vacios.
                
            } else {

                Recetario recetario = new Recetario();

                receta.setNombre(nombreTF.getText());
                //recetario.recetas.add(receta);
                gestor.addReceta(receta);
                setVisible(false);

            }

        }

        if (e.getSource() == ingredienteB) {

            if (ingredienteTF.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese al menos un ingrediente y presione Añadir Ingrediente");
                
            } else {

                Ingrediente ingrediente = new Ingrediente();

                ingrediente.setNombre(ingredienteTF.getText());
                receta.getIngredientes().add(ingrediente);

            }

        }

        if (e.getSource() == instruccionB) {

            if (instruccionTF.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese al menos una instrucción y presione Añadir Instrucción");
                
            } else {

                Instruccion instruccion = new Instruccion();

                instruccion.setPaso(instruccionTF.getText());
                receta.getInstrucciones().add(instruccion);

            }

        }

    }
}
