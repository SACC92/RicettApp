package com.mycompany.ricettapp.ventanas;

import com.mycompany.ricettapp.archivos.GestorJSONv2;
import java.io.IOException;

public class Principal {
    
    public static void main (String[]args) throws IOException{
        
        GestorJSONv2.crearRecetarioVacio();
        GuiPrincipal ventana = new GuiPrincipal("Menu"); 
        ventana.setVisible(true);
        
    }    
}
