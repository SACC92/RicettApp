package com.mycompany.ricettapp.funciones;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class Receta implements JSONStreamAware {

    public ArrayList<Ingrediente> ingredientes;
    public ArrayList<Instruccion> instrucciones;
    public String nombre;
    public String ranking;

    public Receta() {
        this.nombre = " ";
        this.ingredientes = new ArrayList<Ingrediente>();
        this.instrucciones = new ArrayList<Instruccion>();
        this.ranking="0";
    }

    public Receta(String nombre, String ranking, ArrayList<Ingrediente> ingredientes, ArrayList<Instruccion> instrucciones) {
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.nombre = nombre;
        this.ranking = ranking;
    }
    
    
    
    public void rankear(){
        this.ranking += 1;
    }
    
    //Getters y Setters
    public String getRanking(){
        return ranking;
    }
    
    public void setRanking(String ranking){
        this.ranking=ranking;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }       

    @Override
    public void writeJSONString(Writer writer) throws IOException {
        
        try{
            
            LinkedHashMap obj = new LinkedHashMap();
            obj.put("ingredientes",this.ingredientes);
            obj.put("instrucciones", this.instrucciones);
            obj.put("nombre", this.nombre);
            obj.put("ranking", String.valueOf(this.ranking));
            JSONValue.writeJSONString(obj, writer);
            
        }catch(IOException e){}
        
    }
}
