package com.mycompany.ricettapp.funciones;

import java.util.ArrayList;

public class Recetario {

    public static ArrayList<Receta> recetas = new ArrayList<Receta>();

    public String buscarIngrediente(String ing) {
        String resultado = "";
        String saltoLinea = System.getProperty("line.separator");
        for (int x = 0; x < recetas.size(); x++) {
            for (int y = 0; y < recetas.get(x).getIngredientes().size(); y++) {

                if (ing.equals(recetas.get(x).getIngredientes().get(y).getNombre())) {
                    resultado = resultado + saltoLinea + recetas.get(x).getNombre();
                    y = recetas.get(x).getIngredientes().size();
                }

            }
        }
        return resultado;
    }

    //Método para hacer un vector para realizar un ordenamiento de la burbuja
    public void ordenarRecetas() {
        int total = recetas.size();
        Receta[] receta = new Receta[total];
        for (int i = 0; i < receta.length; i++) {
            receta[i] = recetas.get(i);
        }
        burbuja(receta);
    }

    //Método de la burbuja para ordenar luchadores por las velocidades
    private void burbuja(Receta[] receta) {

        for (int i = 0; i < receta.length - 1; i++) {
            for (int j = 0; j < receta.length - 1; j++) {

                if (receta[j].getVotos() == 0) {//Recetas sin votos terminaran al final de la lista
                    Receta tmp = receta[j + 1];
                    receta[j + 1] = null;
                    receta[j + 1] = receta[j];
                    receta[j] = null;
                    receta[j] = tmp;

                } else {
                    if (receta[j].getRanking() / receta[j].getVotos() < receta[j + 1].getRanking() / receta[j + 1].getVotos()) {
                        Receta tmp = receta[j + 1];
                        receta[j + 1] = null;
                        receta[j + 1] = receta[j];
                        receta[j] = null;
                        receta[j] = tmp;
                    }
                }
            }
        }
        colocarRecetasOrdenadas(receta);
    }

    private void colocarRecetasOrdenadas(Receta[] receta) {
        int largoRecetario = recetas.size();
        recetas.clear();

        for (int x = 0; x < largoRecetario; x++) {
            recetas.add(receta[x]);
        }

    }

    public int verCantidadRecetas() {
        return this.recetas.size();
    }

    public void borrarRecetas(String nombre) {
        for (int x = 0; x < this.recetas.size(); x++) {
            if (this.recetas.get(x).getNombre().equals(nombre)) {
                this.recetas.remove(x);
            }
        }
    }
}
