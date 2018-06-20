package com.mycompany.ricettapp.ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.mycompany.ricettapp.funciones.Recetario;

public class GuiBorrarReceta extends JFrame {

    protected JPanel jPanel;
    
    private PanelJlistBorrar panelList;

    public GuiBorrarReceta(String title) {

        super(title);
        this.setLayout(new FlowLayout());
        
        this.panelList = new PanelJlistBorrar();
	this.setContentPane(panelList);

        jPanel = new JPanel();

        this.add(jPanel);

        //Operaciones por defecto
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(550, 550);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
