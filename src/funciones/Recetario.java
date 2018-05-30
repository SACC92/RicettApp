package funciones;

import java.util.ArrayList;

public class Recetario {

    public static ArrayList<Receta> recetas = new ArrayList<Receta>();

    public String buscarIngrediente(String ing) {
        //Métdo debe ser mejorado, pues solo sirve para 1 resultado
        String resultado = " ";
        for (int x = 0; x < recetas.size(); x++) {
            for (int y = 0; y < recetas.get(x).getIngredientes().size(); y++) {

                if (ing.equals(recetas.get(x).getIngredientes().get(y).getNombre())) {
                    resultado = recetas.get(x).getNombre();
                }

            }
        }
        return resultado;
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
