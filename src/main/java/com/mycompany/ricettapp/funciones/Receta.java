package com.mycompany.ricettapp.funciones;

import java.util.ArrayList;

public class Receta {

    public ArrayList<Ingrediente> ingredientes;
    public ArrayList<Instruccion> instrucciones;
    public String nombre;
    public int ranking;

    public Receta() {
        this.nombre = " ";
        this.ingredientes = new ArrayList<Ingrediente>();
        this.instrucciones = new ArrayList<Instruccion>();
        this.ranking=0;
    }
    
    public void rankear(){
        this.ranking += 1;
    }
    
    //Getters y Setters
    public int getRanking(){
        return ranking;
    }
    
    public void setRanking(int ranking){
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
