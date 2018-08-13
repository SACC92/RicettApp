package com.mycompany.ricettapp.test;

import org.junit.Before;
import org.junit.Test;
import com.mycompany.ricettapp.funciones.*;

import static org.junit.Assert.*;

public class RecetarioTest {

    private Recetario recetario;

    @Before
    public void setUp(){

        this.recetario = new Recetario();
        Receta receta1 = new Receta();
        receta1.setNombre("Receta1");
        Ingrediente ing1 = new Ingrediente();
        ing1.setNombre("Huevos");
        receta1.getIngredientes().add(ing1);
        receta1.setVotos(1);

        Receta receta2 = new Receta();
        receta2.setNombre("Receta2");
        Ingrediente ing2 = new Ingrediente();
        ing2.setNombre("Queso");
        receta2.getIngredientes().add(ing2);
        receta2.setVotos(0);

        Receta receta3 = new Receta();
        receta3.setNombre("Receta3");
        Ingrediente ing3 = new Ingrediente();
        ing3.setNombre("Huevos");
        receta3.getIngredientes().add(ing3);
        receta3.setVotos(3);
        receta3.setRanking(15);

        recetario.recetas.add(receta1);
        recetario.recetas.add(receta2);
        recetario.recetas.add(receta3);

    }

    @Test
    public void testBuscarIngrediente() {

        String saltoLinea = System.getProperty("line.separator");
        String resultadoEsperado = saltoLinea + "Receta1" + saltoLinea + "Receta3";
        String resultadoFinal = recetario.buscarIngrediente("Huevos");

        assertEquals(resultadoEsperado, resultadoFinal);

    }

    @Test
    public void testOrdenarRecetas() {

        String resultadoEsperado = "Receta3";
        recetario.ordenarRecetas();

        assertEquals(resultadoEsperado, recetario.recetas.get(0).getNombre());

    }
}