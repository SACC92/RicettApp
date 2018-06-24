package com.mycompany.ricettapp.archivos;

import com.mycompany.ricettapp.funciones.Receta;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Gestor {

    public static void main(String[] args) {
        crearDirectorio();
        crearRecetario();
        
    }
    
    public static void crearDirectorio() {
        String ruta = new File("").getAbsolutePath() + File.separator + "Recetas";
        Path directorio = Paths.get(ruta);

        if (Files.exists(directorio)) {

            System.out.println("El directorio ya existe");

        } else {

            try {
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado");

            } catch (IOException e) {

                System.out.println("El directorio no pudo ser creado");

            }

        }

    }

    public static void crearRecetario() {

        String ruta = new File("").getAbsolutePath() + File.separator + "Recetas" + File.separator + "recetario";
        Path archivo = Paths.get(ruta);
        String texto = "Recetario";

        try {
            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }

    }

    public static String leerRecetario(){
    
        String ruta = new File("").getAbsolutePath() + File.separator + "Recetas" + File.separator + "recetario";
        Path archivo = Paths.get(ruta);
        String texto = "";

        try{
            
            texto = new String(Files.readAllBytes(archivo));
            
        }
        
        catch(IOException e){
        
            System.out.println("No se pudo leer el archivo");
        
        } 
        
        return texto;
    }
    
    public static void añadirReceta(Receta receta, int codRec, int num) {

        String ruta = new File("").getAbsolutePath() + File.separator + "Recetas" + File.separator + "recetario";
        Path archivo = Paths.get(ruta);
        String ingredientes = ingredientes(receta);
        String instrucciones = instrucciones(receta);

        String textoReceta = "@" + num + "\n"
                + codRec + "," + "\t" + receta.ranking + "," + "\t" + receta.ingredientes.size() + "," + "\t" + receta.instrucciones.size() + "\n"
                + ingredientes + "\n"
                + instrucciones;

        StringBuilder sb = new StringBuilder(textoReceta);
        sb.append("\n" + textoReceta);

        try {
            Files.write(archivo, (sb.toString()).getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }

    }

    private static String ingredientes(Receta receta) {

        String ingredientes = "";

        for (int x = 0; x < receta.getIngredientes().size(); x++) {

            ingredientes += receta.getIngredientes().get(x).getNombre() + "," + "\t";

        }

        return ingredientes;
    }

    private static String instrucciones(Receta receta) {

        String instrucciones = "";

        for (int x = 0; x < receta.getInstrucciones().size(); x++) {

            instrucciones += receta.getInstrucciones().get(x).getPaso() + "\n";

        }

        return instrucciones;
    }

    /*
    public static String leerNombresRecetas() {
    
    }

    public static String leerReceta() {
        
    }
    
    public static String buscarReceta() {

    }

    public static String buscarIngrediente() {

    }

    public static void borrarReceta(int codRec){
        
    }
    */

}
