package com.mycompany.ricettapp.archivos;

import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Recetario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestorJSONv2 {

    /**
     * Verifica si recetario.json existe, de no existir lo crea.
     */

    public static void crearRecetarioVacio(){

        if(new File("recetario.json").exists()){}
        else{
            
            try{
            
                Files.write(Paths.get("recetario.json"), new String().getBytes());
            
            }   
            catch(IOException e) {}
        
        }
    }

    /**
     * Añade ingredientes o instrucciones a un JSONArray.
     */

    public static void llenarJSONArray(JSONArray array, Object obj) {

        array.add(obj);

    }

    /**
     * Serializa una receta a formato JSONObject.
     */

    public static JSONObject encode(String nombre, String ranking,String votos, JSONArray ingredientes, JSONArray instrucciones) {

        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("ranking", ranking);
        obj.put("ingredientes", ingredientes);
        obj.put("instrucciones", instrucciones);
        obj.put("votos", votos);
        return obj;

    }

    /**
     * Agrega el texto almacenado en el JSONObject en un archivo .json y lo guarda.
     */

    public static void saveFile(JSONObject obj) throws IOException {

        //Los salto de linea los hago de esta forma para que funcionen bien en cualquier
        //tipo de archivo o sistema operativo
        String saltoLinea = System.getProperty("line.separator");

        ArrayList<String> lineas = vectorLineas();
        String textoViejo = "";

        for (int x = 0; x < lineas.size(); x++) {
            textoViejo += lineas.get(x) + saltoLinea;
        }

        try (FileWriter file = new FileWriter("recetario.json")) {

            file.write(textoViejo + obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Deserializa las lineas obtenidas de un .json y genera una Receta.
     */

    public static Receta decode(ArrayList<String> lineas, int n) {

        ArrayList<Ingrediente> ingredientesAL = new ArrayList();
        ArrayList<Instruccion> instruccionesAL = new ArrayList();
        Receta r = new Receta();

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(lineas.get(n));

            JSONObject jsonObject = (JSONObject) obj;
            String nombre = (String) jsonObject.get("nombre");
            String ranking = ((String) jsonObject.get("ranking"));
            String votos = ((String) jsonObject.get("votos"));

            r.setNombre(nombre);
            r.setRanking(Double.parseDouble(ranking));
            r.setVotos(Double.parseDouble(votos));

            ingredientes(jsonObject, ingredientesAL, r);
            instrucciones(jsonObject, instruccionesAL, r);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return r;

    }

    /**
     * Cuenta la cantidad de lineas dentro del archivo .json.
     */

    public static int contarLineas() throws FileNotFoundException, IOException {
        int numLineas = 0;
        String fichero = new File("").getAbsolutePath() + File.separator + "recetario.json";
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea = reader.readLine();

        while (linea != null) {
            numLineas = numLineas + 1;
            linea = reader.readLine();
        }
        return numLineas;
    }

    /**
     * Convierte el .json en texto plano.
     */

    public static ArrayList<String> vectorLineas() throws FileNotFoundException, IOException {

        int numLineas = 0;
        int contador = 0;
        String fichero = new File("").getAbsolutePath() + File.separator + "recetario.json";

        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea = reader.readLine();

        numLineas = contarLineas();

        ArrayList<String> datos = new ArrayList<String>();

        while (linea != null && contador < numLineas) {
            datos.add(linea);
            linea = reader.readLine();
            contador++;
        }
        return datos;
    }

    /**
     * Genera Recetario con el contenido del archivo .json.
     */

    public static Recetario generarRecetario(ArrayList<String> lineas) {

        Recetario recetario = new Recetario();
        
        recetario.recetas.clear();
        
        for (int x = 0; x < lineas.size(); x++) {
            
            recetario.recetas.add(decode(lineas, x));
            
        }
        recetario.ordenarRecetas();
        
        return recetario;
        
    }

    /**
     * Añande una receta al archivo .json.
     */

    public static void agregarRecetaArchivo(Receta receta) throws IOException {

        JSONArray ingredientes = new JSONArray();
        JSONArray instrucciones = new JSONArray();

        String nombre = receta.getNombre();

        String ranking = String.valueOf(receta.getRanking());
        String votos = String.valueOf(receta.getVotos());

        for (int x = 0; x < receta.getIngredientes().size(); x++) {
            llenarJSONArray(ingredientes, receta.getIngredientes().get(x).getNombre());
        }

        for (int x = 0; x < receta.getInstrucciones().size(); x++) {
            llenarJSONArray(instrucciones, receta.getInstrucciones().get(x).getPaso());
        }

        saveFile(encode(nombre, ranking,votos, ingredientes, instrucciones));
    }

    /**
     * Elimina una receta del .json, pero no afecta a las demás recetas.
     */

    public static void borrarRecetaArchivo(String nombre) throws IOException{
    
        ArrayList<Receta> recetario = Recetario.recetas; 
        
        for(int i=0; i<recetario.size(); i++){
            
            if(recetario.get(i).getNombre().equals(nombre)){
                
                recetario.remove(i);
            
            }
            
        }
        
        vaciarRecetario("recetario.json");
        
        for(int i=0; i<recetario.size(); i++){
            
            agregarRecetaArchivo(recetario.get(i));
            
        }
    
    }

    /**
     * Elimina completamente el contenido del .json.
     */

    public static void vaciarRecetario(String dir){
    
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(dir));
            bw.write("");
            bw.close();
        }catch(IOException e){}
        
    }

    /**
     * Encargado de llenar el ArrayList ingredientes de una Receta desde un JSONObject.
     */

    public static void ingredientes(JSONObject jsonObject, ArrayList ingredientesAL, Receta r) {

        JSONArray ingredientesJA = (JSONArray) jsonObject.get("ingredientes");
        Iterator<String> iteratorING = ingredientesJA.iterator();

        while (iteratorING.hasNext()) {
            Ingrediente ing = new Ingrediente();
            ing.setNombre(iteratorING.next());
            ingredientesAL.add(ing);
        }

        r.setIngredientes(ingredientesAL);

    }

    /**
     * Encargado de llenar el ArrayList instrucciones de una Receta desde un JSONObject.
     */

    public static void instrucciones(JSONObject jsonObject, ArrayList instruccionesAL, Receta r) {

        JSONArray instruccionesJA = (JSONArray) jsonObject.get("instrucciones");
        Iterator<String> iteratorINS = instruccionesJA.iterator();

        while (iteratorINS.hasNext()) {
            Instruccion ins = new Instruccion();
            ins.setPaso(iteratorINS.next());
            instruccionesAL.add(ins);
        }

        r.setInstrucciones(instruccionesAL);

    }

}
