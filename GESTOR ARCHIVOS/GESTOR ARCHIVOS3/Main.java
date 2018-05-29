import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException  {
        GestorArchivo gA = new GestorArchivo();
        Scanner leer = new Scanner(System.in);
        int opc=0;
        
        gA.sobreescribirParcial();
        // gA.menu();
        
        // do{
            // System.out.println("Desea volver a utilizar el programa");
            // System.out.println("1.Si");
            // System.out.println("2.No");
            // opc = leer.nextInt();
            // switch(opc){
                  // case 1: gA.menu();
                  // case 2: break;
            // }
        // }
        // while(opc!=1 && opc!=2);
    }
}
   
