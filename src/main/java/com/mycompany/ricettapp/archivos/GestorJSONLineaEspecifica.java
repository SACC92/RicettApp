package com.mycompany.ricettapp.archivos;

import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Recetario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GestorJSONLineaEspecifica {
    
    private static ArrayList<Receta> recetasArchivo = new ArrayList<Receta>();
    
    public static void main(String[] args) throws IOException{
        
        //Se crea un array de lineas que son cada linea del archivo actualemente
        //vectorLineas(); obtiene las lineas del archivo recetario.json
        ArrayList<String> lineas= vectorLineas();  
        /* ver contenido de lineas
        for(int x =0; x<lineas.size();x++){
            System.out.println(lineas.get(x));
        }
        */
        
        //Se prueba el decode de cada linea del array
        /*
        System.out.println(decode(lineas,0).toString());  
        System.out.println("");
        System.out.println(decode(lineas,1).toString());   
        System.out.println("");
        System.out.println(decode(lineas,2).toString());
        System.out.println("");
        System.out.println("");
        System.out.println("");
        */
        
        //al ver que funciona,
        //Se agregan a recetasArchivo(ArrayList de prueba EN ESTA CLASE)     
               
        recetasArchivo.add(decode(lineas,0));     
        recetasArchivo.add(decode(lineas,1)); 
        recetasArchivo.add(decode(lineas,2));
        
        //Abajo se imprime el contenido de recetasArchivo, que son los decode(lineas, ?) agregados, 
        //y el programa pierde la cabeza ._.
        //Se queda con los ingredientes e instrucciones del último "objeto decode" agregado
        //probar lo dicho en la linea anterio alterando el orden en que agregan
        //los objetos a la lista recetasArchivo
       
        for(int x=0;x<recetasArchivo.size();x++){
            System.out.println(recetasArchivo.get(x).toString());
            System.out.println("");
        }
        
    }

    public static void llenarJSONArray(JSONArray array, Object obj) {

        array.add(obj);

    }

    public static JSONObject encode(String nombre, int ranking, JSONArray ingredientes, JSONArray instrucciones) {

        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("ranking", String.valueOf(ranking));
        obj.put("ingredientes", ingredientes);
        obj.put("instrucciones", instrucciones);
        return obj;

    }

    public static void saveFile(JSONObject obj) {

        try (FileWriter file = new FileWriter("recetario.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Nuevo
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

            r.setNombre(nombre);
            r.setRanking(ranking);

            ingredientes(jsonObject, ingredientesAL, r);
            instrucciones(jsonObject, instruccionesAL, r);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return r;

    }
    //Nuevo
    private static int contarLineas() throws FileNotFoundException, IOException{
        int numLineas=0;
        String fichero = new File("").getAbsolutePath() + File.separator +"recetario.json";        
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea= reader.readLine();
        
        while (linea!=null)
        {        
        numLineas=numLineas+1;
        linea=reader.readLine();
        }   
        return numLineas;
    }
    //Nuevo
    private static ArrayList<String> vectorLineas() throws FileNotFoundException, IOException{
        
        int numLineas=0;
        int contador=0;
        String fichero = new File("").getAbsolutePath() + File.separator + "recetario.json";        
                
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        String linea = reader.readLine();         
        
        numLineas=contarLineas();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        while(linea!=null&&contador<numLineas)
        {
            datos.add(linea);
            linea=reader.readLine();
            contador++;
        }   
        return datos;
    }
    /* Cuando se corrija el error, se podra hacer uso de esto para
        iniciar al programa con recetas ya existentes
    
    private static void generarRecetario(ArrayList<String> lineas){
        Recetario recetario = new Recetario();
            
        for(int x=0;x<lineas.size();x++){            
            recetario.recetas.add(decode(lineas,x));
        }
    }
    */
    
    //Metodos de Auxiliares de Deserialización.
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
