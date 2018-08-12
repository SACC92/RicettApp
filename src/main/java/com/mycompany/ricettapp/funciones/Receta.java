package com.mycompany.ricettapp.funciones;

import java.util.ArrayList;

public class Receta {

    /**
     *
     * Clase Receta
     *
     * @autor Lucas Sandoval Jorge Echeverria Sebastian Contreras
     * @version 4.0
     */

    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Instruccion> instrucciones;
    private String nombre;
    private double ranking;
    private double votos;
	
    public Receta() {
        this.nombre = " ";
        this.ingredientes = new ArrayList<Ingrediente>();
        this.instrucciones = new ArrayList<Instruccion>();
        this.ranking = 0;
        this.votos = 0;
    }

    public Receta(String nombre, int ranking, ArrayList<Ingrediente> ingredientes, ArrayList<Instruccion> instrucciones) {
        this.ingredientes = ingredientes;
        this.instrucciones = instrucciones;
        this.nombre = nombre;
        this.ranking = ranking;
    }

    /**
     * Encargado de entregar la información completa de una receta.
     *
     * @return String información completa de la Receta.
     *
     */

    public String toString() {
        String saltoLinea = System.getProperty("line.separator");
        return "Nombre: " + nombre + saltoLinea + "Ranking: " + mostrarRanking() + saltoLinea + "Ingredientes: " + ings() + saltoLinea + "Instrucciones:" + inst();
    }

    /**
     * Entrega el ranking de una receta, informa si no ha sido rankeada.
     *
     * @return String valoración de la receta.
     *
     */

    public String mostrarRanking(){
        String valoracion="";
        if(this.votos!=0){
            valoracion=String.valueOf(ranking/votos);
        }else{
            valoracion= "Receta sin valorar";
        }
        return String.valueOf(valoracion);
    }

    /**
     * Entrega en String la lista de ingredientes de una receta.
     *
     * @return String ingredientes de la receta.
     *
     */

    private String ings() {
        String ings = "";
        String saltoLinea = System.getProperty("line.separator");
        for (int x = 0; x < ingredientes.size(); x++) {
            ings += saltoLinea + ingredientes.get(x).getNombre();
        }
        return ings;
    }

    /**
     * Entrega en String la lista de instrucciones de una receta.
     *
     * @return String instrucciones de la receta.
     *
     */

    private String inst() {
        String inst = "";
        String saltoLinea = System.getProperty("line.separator");
        for (int x = 0; x < instrucciones.size(); x++) {
            inst += saltoLinea + instrucciones.get(x).getPaso();
        }
        return inst;
    }

    /**
     * Encargado de actualizar el ranking de una receta.
     *
     * @param valoracion cantidad de estrellas ingresadas por el usuario.
     *
     */

    public void rankear(double valoracion) {
        this.votos += 1;
        this.ranking = ranking + valoracion;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getNombre() {
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

    public double getVotos() {
        return votos;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public void setVotos(double votos) {
        this.votos = votos;
    }

}
