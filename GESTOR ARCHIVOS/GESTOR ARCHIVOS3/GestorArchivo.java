import java.nio.charset.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;

public class GestorArchivo
{
        public void menu() throws IOException{
        Scanner teclado = new Scanner(System.in);
        int opc;
        
        do{
            System.out.println("Que desea hacer??");
            System.out.println("1. Crear Directorio");
            System.out.println("2. Crear Archivo");
            System.out.println("3. Leer Archivo");
            System.out.println("4. Copiar Archivo");
            System.out.println("5. Eliminar Archivo");
            System.out.println("6. Actualizar Archivo");
            System.out.println("7. Sobreescribir Archivo");
            System.out.println("8. Contar Carácteres");
            System.out.println("9. Contar Palabras");
            System.out.println("10. Contar Lineas");
            System.out.println("11.Buscar Palabra");
            opc = teclado.nextInt();
        }while (opc<1 || opc>11);
        seleccion(opc);
     }
    
    public void seleccion (int opc) throws IOException{
        switch(opc){
            case 1:
                crearDirectorio();
                System.out.println("");
                System.out.println("");
                break;
                
            case 2:
                crearArchivo();
                System.out.println("");
                System.out.println("");
                break;
                
            case 3:
                leerArchivo();
                System.out.println("");
                System.out.println("");
                break;
                
            case 4:
                copiarArchivo();
                System.out.println("");
                System.out.println("");
                break;
         
            case 5:
                eliminarArchivo();
                System.out.println("");
                System.out.println("");
                break;
                
            case 6: 
                actualizarArchivo();
                System.out.println("");
                System.out.println("");
                break;
            
                
            case 7: 
                sobreescribirArchivo();
                System.out.println("");
                System.out.println("");
                break;
                
            case 8:
                contarCaracteres(leerArchivo());
                System.out.println("");
                System.out.println("");
                break;
                
            case 9:
                contarPalabras(leerArchivo());
                System.out.println("");
                System.out.println("");
                break;
                
            case 10: 
                contarLineas();
                System.out.println("");
                System.out.println("");
                break;
            
            case 11: 
                buscarPalabra(leerArchivo());
                System.out.println("");
                System.out.println("");
                break;
               }
    }
    
    public void crearDirectorio()
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese ruta completa para crear directorio");
        String ruta = teclado.nextLine();
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
    
    public void crearArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo, de la forma %%/*Carpeta*/nombre.txt%%");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese el texto a guardar en el archivo");
        String texto = teclado.nextLine();
        
        try{
            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha guardado el archivo");
        }
        catch(IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
    
    public String leerArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto = "";

        try{
             texto = new String(Files.readAllBytes(archivo));
             System.out.println("El contenido del archivo es:\n"+texto);
        }
        catch(IOException e){
             System.out.println("El archivo no pudo ser leido");
        } 
        return texto;
        }
               
    public void copiarArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo original");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese la ruta de destino de la copia");
        String newRuta = teclado.nextLine();
        Path newArchivo = Paths.get(newRuta);
        
        try{
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fue copiado existosamente");
        }
        catch(IOException e) {
            System.out.println("El archivo no pudo ser copiado");
        }
    }
    
    public void eliminarArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        
        try{
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fue eliminado existosamente");
        }
        catch(IOException e) {
            System.out.println("El archivo no pudo ser eliminado");
        }
    }
    
    public void actualizarArchivo(){
        Scanner teclado = new Scanner(System.in);  
        System.out.println("Ingrese la ruta completa");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto = "";
        try{
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es:\n"+texto);
          }
          catch(IOException e){
              System.out.println("No se pudo leer el archivo");
            }
        
        System.out.println("Ingrese el texto a guardar en el archivo");
        String newTexto = teclado.nextLine();
        StringBuilder sb = new StringBuilder(texto);
        sb.append("\n"+newTexto);
        System.out.println(sb);
        try{
            Files.write(archivo, (sb.toString()).getBytes());
            System.out.println("Se ha guardado el archivo");
        }
        catch(IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
    
    public void contarCaracteres(String texto){
        System.out.println("Número de carácteres: " +texto.length());
    }
    
    public void contarPalabras(String texto){
        StringTokenizer st = new StringTokenizer(texto);
        System.out.println("Número de palabras: " +st.countTokens());
    }
    
    public int contarLineas() throws IOException {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la dirección del archivo");
        String dir = leer.nextLine();
        int counter = 0;
        try{
            File f = new File(dir);
            FileReader fr = new FileReader(f);
            LineNumberReader lnr = new LineNumberReader(fr);
            lnr.skip(Long.MAX_VALUE);
            System.out.println("Hay "+(lnr.getLineNumber()+1)+" lineas");
            counter = lnr.getLineNumber();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return counter;
    }
    
    public void buscarPalabra(String texto){
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
          System.out.println(pal + " se repitó "+contador+" veces");
        }
    }
    
    public void sobreescribirArchivo() throws IOException{
        Scanner teclado = new Scanner(System.in);
        int opc=0;
        do    {
            System.out.println("¿Desea modificar parcial o totalmente el archivo?!");
            System.out.println("1. Parcialmente");
            System.out.println("2. Totalmente");
            opc = teclado.nextInt();
        }  while(opc<1 || opc>2);
        switch(opc){
           case 1: sobreescribirParcial();
           case 2: sobreescribirCompleto();
        
        }
    }    
    
    public void sobreescribirCompleto()throws IOException{ 
        Scanner teclado = new Scanner(System.in);  
        System.out.println("Ingrese la ruta completa");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto = "";
        try{
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es:\n"+texto);
          }
          catch(IOException e){
              System.out.println("No se pudo leer el archivo");
            }

        System.out.println("Ingrese el texto a guardar en el archivo");
                    String newText = teclado.nextLine();
        try{
              Files.write(archivo, newText.getBytes());
              System.out.println("Se ha guardado el archivo");
                    }
        catch(IOException e) {
              System.out.println("No se pudo guardar el archivo");
                    }
        }
        
    public static void sobreescribirParcial() throws IOException{
        Scanner leer = new Scanner(System.in);
        int linenumber = 0;
        System.out.println("Ingrese la ruta");
        String ruta = leer.nextLine();
         
        int largo=0;
        try{
            File f = new File(ruta);
            FileReader fr = new FileReader(f);
            LineNumberReader lnr = new LineNumberReader(fr);
            lnr.skip(Long.MAX_VALUE);
            largo = lnr.getLineNumber();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        /////////////////////////////////////////
        
        ArrayList <String> frases = new ArrayList <String> (largo);

        try{             
             BufferedReader in =new BufferedReader(new FileReader(ruta));
             String line = null;
             while ((line = in.readLine()) !=null){
                linenumber ++;
                System.out.println("Línea "+ linenumber +" : "+line);
                frases.add(line);
             }
        
            }catch (IOException e){
             e.printStackTrace();
         }
        
        ////////////////////////////////////////// 
         
        int opc=0;
        do{
            System.out.println("Ingrese el número de la línea a cambiar");
            opc=leer.nextInt();
            leer.close();
        }
        while(opc<1 || opc>linenumber);
        
        leer = new Scanner(System.in);
        System.out.println("Ingrese con la que desea reemplazar");
        frases.set(opc-1, leer.nextLine());
        leer.close();
        
        /////////////////////////////////////////////
        
        leer = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa");
        ruta = leer.nextLine();
        FileWriter wrt = new FileWriter(ruta); 
        for(String str: frases) {
            wrt.write(str+"\n");
        }
        wrt.close();
        leer.close();
    }

    public void buscarPalabraLinea() throws IOException{
        Scanner leer = new Scanner(System.in);
        int linenumber = 0;
        System.out.println("Ingrese la ruta");
        String ruta = leer.nextLine();
         
        int largo=0;
        try{
            File f = new File(ruta);
            FileReader fr = new FileReader(f);
            LineNumberReader lnr = new LineNumberReader(fr);
            lnr.skip(Long.MAX_VALUE);
            largo = lnr.getLineNumber();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        /////////////////////////////////////////
        
        ArrayList <String> frases = new ArrayList <String> (largo);

        try{             
             BufferedReader in =new BufferedReader(new FileReader(ruta));
             String line = null;
             while ((line = in.readLine()) !=null){
                linenumber ++;
                System.out.println("Línea "+ linenumber +" : "+line);
                frases.add(line);
                }
        
            }catch (IOException e){
             e.printStackTrace();
         }
        
        //////////////////////////////////////////////
        
        System.out.println("Ingrese palabras a buscar");
        String pal = leer.nextLine();
        int contador =0; 
        String texto=null;
        
        for(int i=0; i<frases.size(); i++){
            texto=frases.get(i);
            while ((frases.get(i)).indexOf(pal) > -1) {
                texto = texto.substring(texto.indexOf(pal)+pal.length(),texto.length());
                contador++; 
            }
        
            if (contador!=0){
                System.out.println(pal + " se encuentra en la línea número "+i);
                System.out.println("acuerdate que i parte de cero");
                System.out.println(frases.get(i));
            }
            else{
                System.out.println("No se encuentra");
            }
        }
    }
    
    public void autoCreatefile(String dir,String texto){
        Path archivo = Paths.get(dir);        
        try{
            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha guardado el archivo");
        }
        catch(IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
    
    public void autoUpdate(String dir, String textoNew){
       Path archivo = Paths.get(dir);
       String texto = "";
       try{
            texto = new String(Files.readAllBytes(archivo));
          }
          catch(IOException e){
              System.out.println("No se pudo leer el archivo");
            }
       StringBuilder sb = new StringBuilder(texto);
       sb.append("\n"+textoNew);
       try{
            Files.write(archivo, (sb.toString()).getBytes());
            System.out.println("Archivo Actualizado");
        }
        catch(IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
}