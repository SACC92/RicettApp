package JUnit;

import com.mycompany.ricettapp.archivos.GestorJSONv2;
import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Receta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestorTest {

    private GestorJSONv2 gestor;
    private Receta receta;

    //Probar que los datos se guardan en el archivo y se obtienen con exito
    
    public GestorTest() {
        this.gestor = new GestorJSONv2();
        this.receta = new Receta();

        this.receta.setNombre("Huevos Fritos");
        Ingrediente ing = new Ingrediente();
        Instruccion ins = new Instruccion();
        ing.setNombre("Huevos");
        ins.setPaso("Freir los huevos");
        this.receta.setRanking(12);
        this.receta.setVotos(3);
        this.receta.getIngredientes().add(ing);
        this.receta.getInstrucciones().add(ins);
    }

    @Test
    public void testDecode() {

        Receta resultadoEsperado = receta;

        Receta resultadoFinal;

        try {
            this.gestor.agregarRecetaArchivo(this.receta);

            ArrayList<String> listaRecetas = this.gestor.vectorLineas();

            resultadoFinal = this.gestor.decode(listaRecetas, listaRecetas.size()-1);
            
            //Si las recetas son iguales, los, métodos toString() deberian mostrar lo mismo
            assertEquals(resultadoEsperado.toString(), resultadoFinal.toString());
        } catch (IOException ex) {
            fail("Error no esperado");
        }
    }

    @After
    public void borrarRecetaDePrueba() {
        ArrayList<String> listaRecetas;
        try {
            listaRecetas = this.gestor.vectorLineas();
            this.gestor.generarRecetario(listaRecetas);
            this.gestor.borrarRecetaArchivo("Huevos Fritos");
        } catch (IOException ex) {
            //error
        }

    }
}
