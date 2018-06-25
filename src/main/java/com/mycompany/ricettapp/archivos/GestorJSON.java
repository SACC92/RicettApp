package com.mycompany.ricettapp.archivos;

import org.json.simple.*;
import com.mycompany.ricettapp.funciones.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class GestorJSON {
    
    public static ArrayList<String> ingredientes = new ArrayList();
    public static ArrayList<String> instrucciones = new ArrayList();
    public static String nombre;
    public static int ranking;
    
    public static void llenado(){
    
        ingredientes.add("agua");
        ingredientes.add("agua2");
        instrucciones.add("paso1");
        instrucciones.add("paso2");
        nombre = "agua hervida";
        ranking = 5;
    
    
    }
    
    
    
    public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
        
        llenado();
        
        String sinFormatear = encodeRecetas(addRecetas(new JSONArray(),ingredientes, instrucciones, nombre, ranking));
        System.out.println(sinFormatear);
        guardarArchivo(addRecetas(new JSONArray(),ingredientes, instrucciones, nombre, ranking));
        parsearRecetario();
        
        

        
    }
    
    public static JSONArray addRecetas(JSONArray recetario, ArrayList ingredientes, ArrayList instrucciones, String nombre, int ranking){
    
        recetario.add(new Receta(nombre,ranking,ingredientes,instrucciones));
        return recetario;
    
    }
    
    public static String encodeRecetas(JSONArray recetario) throws IOException{
    
        StringWriter out = new StringWriter();
        
        try{
            
            recetario.writeJSONString(out);

        }
        
        catch(IOException e){
        
            e.printStackTrace();
        
        }
        
        return out.toString();
    
    }
    
    private static void parsearRecetario() {
                
        JSONParser jsonParser = new JSONParser();
		
	try {
		
            FileReader reader = new FileReader("Datos/recetario.json");
            Object obj = jsonParser.parse(reader);

            JSONArray recetario = (JSONArray) obj;
            System.out.println(recetario);
            
            //Iterate over employee array
           recetario.forEach( rec -> parseReceta( (JSONObject) rec ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	
    
private static void parseReceta(JSONObject receta) 
	{
		//Get employee object within list
		JSONObject rec = (JSONObject) receta.get("employee");
		
		//Get employee first name
		String firstName = (String) rec.get("ingredientes");	
		System.out.println(firstName);
		
		//Get employee last name
		String lastName = (String) rec.get("instrucciones");	
		System.out.println(lastName);
		
		//Get employee website name
		String website = (String) rec.get("nombre");	
		System.out.println(website);
	}
        
    
    public static void guardarArchivo(JSONArray recetario){
        
        try  {
            FileWriter file = new FileWriter("Datos/recetario.json");
            file.write(recetario.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
        
    

        

    
    
    
    

