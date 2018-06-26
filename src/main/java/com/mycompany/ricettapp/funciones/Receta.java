package com.mycompany.ricettapp.funciones;

import java.util.ArrayList;

public class Receta  {

    public static ArrayList<Ingrediente> ingredientes;
    public static ArrayList<Instruccion> instrucciones;
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
    
    public String toString(){
        String saltoLinea = System.getProperty("line.separator");
        return "Nombre: "+nombre+saltoLinea+"Ranking: "+ranking+saltoLinea+"Ingredientes: "+ ings()+saltoLinea+"Instrucciones:"+inst();
    }
    
    private static String ings(){
        String ings = "";
        String saltoLinea = System.getProperty("line.separator");
        for(int x=0;x<ingredientes.size();x++){
            ings+= saltoLinea + ingredientes.get(x).getNombre();
        }        
        return ings;
    }   
    
    private static String inst(){
        String inst = "";
        String saltoLinea = System.getProperty("line.separator");
        for(int x=0;x<instrucciones.size();x++){
            inst+= saltoLinea + instrucciones.get(x).getPaso();
        }        
        return inst;
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
}
