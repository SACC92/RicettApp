package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSON;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.ricettapp.funciones.*;
import java.io.IOException;

public class GuiAdd extends JFrame implements ActionListener {

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

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 200);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == guardarB) {

            if (nombreTF.getText().isEmpty() || receta.getIngredientes().isEmpty() || receta.getInstrucciones().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Uno o mas campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                
                try{
                    
                    receta.setNombre(nombreTF.getText().toString());
                    Recetario recetario = GestorJSON.generarRecetario(GestorJSON.vectorLineas());
                    boolean existe = false;
                
                    for(int i=0; i<recetario.recetas.size();i++){
                        
                        if(receta.getNombre().equals(recetario.recetas.get(i).getNombre())){
                           
                            JOptionPane.showMessageDialog(null, "La receta ya existe en el inventario", "Error", JOptionPane.WARNING_MESSAGE);
                            existe = true;
                            
                        }
                        
                    }
                
                    if(existe == true){
                
                        setVisible(false);
                    
                    }
                    else{
                
                        try {

                            GestorJSON.agregarRecetaArchivo(this.receta);
                            setVisible(false);

                        } catch (IOException e2) {}
                
                    }
                    
                }catch(IOException e1){}

            }

        }
        
        if (e.getSource() == ingredienteB) {

            if (ingredienteTF.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese al menos un ingrediente y presione Añadir Ingrediente", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                Ingrediente ingrediente = new Ingrediente();

                ingrediente.setNombre(ingredienteTF.getText());
                receta.getIngredientes().add(ingrediente);
                ingredienteTF.setText("");

            }

        }
        if (e.getSource() == instruccionB) {

            if (instruccionTF.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Ingrese al menos una instrucción y presione Añadir Instrucción", "Error", JOptionPane.ERROR_MESSAGE);

            } else {

                Instruccion instruccion = new Instruccion();

                instruccion.setPaso(instruccionTF.getText());
                receta.getInstrucciones().add(instruccion);
                instruccionTF.setText("");

            }

        }

    }
}
