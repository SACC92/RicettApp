
package main.java.com.mycompany.ricettapp.archivos;

import com.mycompany.ricettapp.funciones.Receta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PrototipoGestor {
    public static void main (String[]args){
        crearDirectorio();

        Receta receta = new Receta();
        crearReceta(receta);
        String contenido = leerArchivo(receta);
        System.out.println(contenido);
        buscarPalabra(leerArchivo(receta));
    }
    
    public static void crearDirectorio(){
    //Este método es usado solo para crear la carpeta en que se guardaran los txt        
        String ruta = new File("").getAbsolutePath() + File.separator  + "Recetas";
        Path directorio = Paths.get(ruta);
        
        if(Files.exists(directorio)){
            System.out.println("El directorio ya existe");
        }else{
            try{
            Files.createDirectories(directorio);
            System.out.println("El directorio fue creado");
          }
          catch(IOException e){
              System.out.println("El directorio no pudo ser creado");
            }
        }
    }    
    
    public static void crearReceta(Receta receta){        
        //Crea un archivo txt dentro de la carpeta en el proyecto que se esta trabajando
        String ruta = new File("").getAbsolutePath() + File.separator +"Recetas"+
                      File.separator+ receta.getNombre()+".txt";
        //Se obtiene la ruta y se agrega el contenido
        Path archivo = Paths.get(ruta);
        
        String saltoLinea = System.getProperty("line.separator");
        
        //texto es el contenido actual del txt        
        String nombre = receta.getNombre();
        String ingredientes = ingredientes(receta);
        String instrucciones = instrucciones(receta);
         String texto = "Nombre: "+ saltoLinea + nombre+
                 saltoLinea + "Ingredientes: " + ingredientes+
                 saltoLinea + "Instrucciones: " + instrucciones;
         
         try{
            Files.write(archivo, texto.getBytes());
        }
        catch(IOException e) {
            //error
        }        
    }
    //Es para crearReceta() este método
    private static String ingredientes(Receta receta){
        
        String saltoLinea = System.getProperty("line.separator");
        
        String ingredientes = "";
        for(int x =0; x<receta.getIngredientes().size();x++){
            ingredientes = ingredientes + saltoLinea + receta.getIngredientes().get(x).getNombre();
        }        
        return ingredientes;
    }
    //
    //Es para crearReceta() este método
    private static String instrucciones(Receta receta){
        
        String saltoLinea = System.getProperty("line.separator");
        
        String instrucciones = "";
        for(int x =0; x<receta.getInstrucciones().size();x++){
            instrucciones = instrucciones + saltoLinea + receta.getInstrucciones().get(x).getPaso();
        }  
        return instrucciones;
    }     
    //
    public static String leerArchivo(Receta receta){
        
        String ruta = new File("").getAbsolutePath() + File.separator +"Recetas"+
                      File.separator+ receta.getNombre() +".txt";
        Path archivo = Paths.get(ruta);
        String texto = "";

        try{
             texto = new String(Files.readAllBytes(archivo));
        }
        catch(IOException e){
             //error
        } 
        return texto;
    }
    
    public static void buscarPalabra(String texto){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese palabras a buscar");
        String pal = leer.nextLine();
        int contador =0; 
        
        while (texto.indexOf(pal) > -1) {
          texto = texto.substring(texto.indexOf(pal)+pal.length(),texto.length());
          contador++; 
        }
        
        if (contador==0){
          System.out.println("No se encuentra");
        }
        else{
          System.out.println(pal + " se repitió "+contador+" veces");
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
