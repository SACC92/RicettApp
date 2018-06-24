package prototipogestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class lectorLineas {
    
    public static void main(String[]args) throws FileNotFoundException, IOException{
        
        int numLineas=contarLineas();
        
        String datos[]=vectorLineas();      
        
        for(int x=0;x<numLineas;x++){
            System.out.println(datos[x]);
        }         
    }    
    
    private static int contarLineas() throws FileNotFoundException, IOException{
        int numLineas=0;
        String fichero = new File("").getAbsolutePath() + File.separator +"Recetas"+File.separator+ "Recetario"+".txt";        
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea= reader.readLine();
        
        while (linea!=null)
        {        
        numLineas=numLineas+1;
        linea=reader.readLine();
        }   
        return numLineas;
    }
    
    private static String [] vectorLineas() throws FileNotFoundException, IOException{
        int numLineas=0;
        int contador=0;
        String fichero = new File("").getAbsolutePath() + File.separator +"Recetas"+File.separator+ "Recetario"+".txt";        
                
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea = reader.readLine();         
        
        numLineas=contarLineas();
        
        String datos[] = new String[numLineas];
        
        while(linea!=null&&contador<numLineas)
        {
            datos[contador]=linea;
            linea=reader.readLine();
            contador++;
        }   
        return datos;
    }
}

