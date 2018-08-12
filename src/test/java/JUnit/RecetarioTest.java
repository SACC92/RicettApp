package JUnit;

import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Recetario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecetarioTest {

    private Recetario recetario;

    public RecetarioTest() {
        recetario = new Recetario();
    }

    @Test
    public void buscarIngredienteTest() {
        Receta receta1 = new Receta();
        receta1.setNombre("Receta1");
        Ingrediente ing1 = new Ingrediente();
        ing1.setNombre("Huevos");
        receta1.getIngredientes().add(ing1);

        Receta receta2 = new Receta();
        receta2.setNombre("Receta2");
        Ingrediente ing2 = new Ingrediente();
        ing2.setNombre("Queso");
        receta2.getIngredientes().add(ing2);

        Receta receta3 = new Receta();
        receta3.setNombre("Receta3");
        Ingrediente ing3 = new Ingrediente();
        ing3.setNombre("Huevos");
        receta3.getIngredientes().add(ing3);

        recetario.recetas.add(receta1);
        recetario.recetas.add(receta2);
        recetario.recetas.add(receta3);

        String saltoLinea = System.getProperty("line.separator");
        String resultadoEsperado = saltoLinea + "Receta1" + saltoLinea + "Receta3";

        String resultadoFinal = recetario.buscarIngrediente("Huevos");

        assertEquals(resultadoEsperado, resultadoFinal);
    }
}
