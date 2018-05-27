package Ventana;

import java.awt.*;

public class MenuVentana {
    
    public static void main (String[]args){
        GuiMain ventana = new GuiMain("Menu"); 
        ventana.setVisible(true);
        ventana.getContentPane().setBackground(Color.WHITE);
    }
    
}
