package com.mycompany.ricettapp.archivos;

import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Receta;
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


public class GestorJSON {

    static JSONArray ingredientes = new JSONArray();
    static JSONArray instrucciones = new JSONArray();
    
    public static void main(String[] args) {
        
        Ingrediente agua = new Ingrediente();
        Ingrediente fideos = new Ingrediente();
        Instruccion sacar = new Instruccion();
        Instruccion echar = new Instruccion();
        
        agua.setNombre("agua");
        fideos.setNombre("fideos");
        sacar.setPaso("sacar de la bolsa");
        echar.setPaso("echar a la olla");
        
        
        llenarJSONArray(ingredientes,agua);
        llenarJSONArray(ingredientes,fideos);
        llenarJSONArray(instrucciones,sacar);
        llenarJSONArray(instrucciones,echar);
        
        
        saveFile(encode("tallarines",9,ingredientes,instrucciones));
        String nombre = decode().getNombre();
        String ranking = decode().getRanking();
        String ing = decode().getIngredientes().toString();
        String ins = decode().getInstrucciones().toString();
        

        
    }
    
    
    public static void llenarJSONArray(JSONArray array, Object obj){
    
        array.add(obj);
    
    }
    
    
    public static JSONObject encode(String nombre,int ranking, JSONArray ingredientes, JSONArray instrucciones){
    
        JSONObject obj = new JSONObject();
        obj.put("nombre",nombre);
        obj.put("ranking", String.valueOf(ranking));
        obj.put("ingredientes", ingredientes);
        obj.put("instrucciones", instrucciones);
        return obj;
        
    }

    public static void saveFile(JSONObject obj){
        
        try (FileWriter file = new FileWriter("recetario.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);
    
    
    
    }
    
    public static Receta decode(){
    
        ArrayList<Ingrediente> ingredientesAL = new ArrayList();  
        ArrayList<Instruccion> instruccionesAL = new ArrayList();
        Receta r = new Receta();
        
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("prueba.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String nombre = (String) jsonObject.get("nombre");
            r.setNombre(nombre);
            System.out.println(nombre);
            

            String ranking = ((String) jsonObject.get("ranking"));
            r.setRanking(ranking);
            System.out.println(ranking);

            JSONArray ingredientesJA = (JSONArray) jsonObject.get("ingredientes");
            Iterator<String> iteratorING = ingredientesJA.iterator();

            while (iteratorING.hasNext()) {
                Ingrediente ing = new Ingrediente();
                ing.setNombre(iteratorING.next());
                ingredientesAL.add(ing);
                System.out.println(iteratorING.next());
            }
            
            r.setIngredientes(ingredientesAL);
            
            JSONArray instruccionesJA = (JSONArray) jsonObject.get("instrucciones");
            Iterator<String> iteratorINS = instruccionesJA.iterator();

            while (iteratorINS.hasNext()) {
                Instruccion ins = new Instruccion();
                ins.setPaso(iteratorINS.next());
                instruccionesAL.add(ins);
                System.out.println(iteratorINS.next());
            }
            
            r.setInstrucciones(instruccionesAL);
            
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return r;
        
    }
 
}