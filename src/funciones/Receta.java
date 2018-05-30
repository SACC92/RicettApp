package funciones;

import java.util.ArrayList;

public class Receta {

    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Instruccion> instrucciones;
    private String nombre;

    public Receta() {
        this.nombre = " ";
        this.ingredientes = new ArrayList<Ingrediente>();
        this.instrucciones = new ArrayList<Instruccion>();
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

    public ArrayList<Instruccion> getInstruccion() {
        return instrucciones;
    }

    public void setInstruccion(ArrayList<Instruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
}
