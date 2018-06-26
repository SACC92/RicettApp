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

    public static JSONArray ingredientes = new JSONArray();
    public static JSONArray instrucciones = new JSONArray();

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

    public static void saveFile(JSONObject obj) { //VER SI SOBREESCRIBE O ACTUALIZA

        try (FileWriter file = new FileWriter("recetario.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Receta decode() {

        ArrayList<Ingrediente> ingredientesAL = new ArrayList();
        ArrayList<Instruccion> instruccionesAL = new ArrayList();
        Receta r = new Receta();

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("recetario.json"));

            JSONObject jsonObject = (JSONObject) obj;
            String nombre = (String) jsonObject.get("nombre");
            String ranking = ((String) jsonObject.get("ranking"));

            r.setNombre(nombre);
            r.setRanking(ranking);

            ingredientes(jsonObject, ingredientesAL, r);
            instrucciones(jsonObject, instruccionesAL, r);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return r;

    }

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