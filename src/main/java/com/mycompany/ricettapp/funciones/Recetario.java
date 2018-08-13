package com.mycompany.ricettapp.funciones;

import java.util.ArrayList;

public class Recetario {

    public static ArrayList<Receta> recetas = new ArrayList<Receta>();

    public Recetario() {
    }

    /**
     * Busca un ingrediente en las recetas guardadas en this.recetas.
     *
     * @param ing Nombre del ingrediente a buscar.
     * @return String Nombre de la recetas que contengan a ing.
     *
     */

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

    /**
     * Encargado de hacer un vector para realizar un ordenamiento de la burbuja.
     */

    public void ordenarRecetas() {
        int total = recetas.size();
        Receta[] receta = new Receta[total];
        for (int i = 0; i < receta.length; i++) {
            receta[i] = recetas.get(i);
        }
        burbuja(receta);
    }

    /**
     * Ordena las recetas por metodo de la burbuja, considerando que las recetas sin votos quedarán al final de la lista.
     *
     * @param recetas Listado de recetas para ser ordenadas.
     *
     */

    private void burbuja(Receta[] recetas) {

        for (int i = 0; i < recetas.length - 1; i++) {
            for (int j = 0; j < recetas.length - 1; j++) {

                if (recetas[j].getVotos() == 0) {
                    Receta tmp = recetas[j + 1];
                    recetas[j + 1] = null;
                    recetas[j + 1] = recetas[j];
                    recetas[j] = null;
                    recetas[j] = tmp;

                } else {
                    if (recetas[j].getRanking() *1.0/ recetas[j].getVotos()*1.0 < recetas[j + 1].getRanking()*1.0 / recetas[j + 1].getVotos()*1.0) {
                        Receta tmp = recetas[j + 1];
                        recetas[j + 1] = null;
                        recetas[j + 1] = recetas[j];
                        recetas[j] = null;
                        recetas[j] = tmp;
                    }
                }
            }
        }
        colocarRecetasOrdenadas(recetas);
    }

    /**
     * Limpia this.recetas y lo llena con las recetas ordenadas.
     *
     * @param recetas Listado de recetas ordenadas para reemplazar a las de this.recetas.
     *
     */

    private void colocarRecetasOrdenadas(Receta[] recetas) {
        int largoRecetario = this.recetas.size();
        this.recetas.clear();

        for (int x = 0; x < largoRecetario; x++) {
            this.recetas.add(recetas[x]);
        }

    }

    /**
     * Informa de la cantidad de recetas en this.recetas.
     *
     * @return int Cantidad de recetas.
     *
     */

    public int verCantidadRecetas() {
        return this.recetas.size();
    }

    /**
     * Elimina una receta.
     *
     * @param nombre Nombre de la receta a eliminar.
     *
     */

    public void borrarRecetas(String nombre) {
        for (int x = 0; x < this.recetas.size(); x++) {
            if (this.recetas.get(x).getNombre().equals(nombre)) {
                this.recetas.remove(x);
            }
        }
    }
}
