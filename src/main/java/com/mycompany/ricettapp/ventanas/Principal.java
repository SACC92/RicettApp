package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSONv2;

public class Principal {
    
    public static void main (String[]args){
        
        GestorJSONv2.crearRecetarioVacio();
        GuiMain ventana = new GuiMain("Menu"); 
        ventana.setVisible(true);
        
    }    
}
