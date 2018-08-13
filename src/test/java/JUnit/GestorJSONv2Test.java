

import org.junit.*;
import com.mycompany.ricettapp.archivos.GestorJSONv2;
import com.mycompany.ricettapp.funciones.*;
import java.util.ArrayList;

import java.io.IOException;

import static org.junit.Assert.*;

public class GestorJSONv2Test {

    private GestorJSONv2 gestor;
    private Receta receta;

    @Before
    public void setUp(){

        this.gestor.vaciarRecetario("recetario.json");
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
    public void testDecode() throws IOException {

        Receta resultadoObtenido;

        try {

            this.gestor.agregarRecetaArchivo(this.receta);
            ArrayList<String> listaRecetas = this.gestor.vectorLineas();
            resultadoObtenido = this.gestor.decode(listaRecetas, listaRecetas.size()-1);

            assertEquals(this.receta.toString(), resultadoObtenido.toString());

        } catch (IOException ex) {

            fail("No se pudo deserializar el .json");

        }

    }

    @After
    public void testBorrarRecetaArchivo() {

        ArrayList<String> listaRecetas;

        try {

            listaRecetas = this.gestor.vectorLineas();
            this.gestor.generarRecetario(listaRecetas);
            this.gestor.borrarRecetaArchivo("Huevos Fritos");
            int resultadoObtenido = this.gestor.contarLineas();

            assertEquals(0,resultadoObtenido);

        } catch (IOException ex) {

            fail("No se pudo borrar la receta del .json");

        }

    }
}