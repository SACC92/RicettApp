package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSON;
import java.io.IOException;

public class Principal {
    
    public static void main (String[]args) throws IOException{

        GestorJSON.crearRecetarioVacio();
        GuiPrincipal ventana = new GuiPrincipal("Menu"); 
        ventana.setVisible(true);
        
    }    
}
