package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.PrototipoGestor;

public class Principal {
    
    public static void main (String[]args){
        
        PrototipoGestor gestor = new PrototipoGestor();
        gestor.crearDirectorio();
        
        GuiMain ventana = new GuiMain("Menu"); 
        ventana.setVisible(true);
        
    }    
}
