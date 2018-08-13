
package JUnit;

import com.mycompany.ricettapp.funciones.Ingrediente;
import com.mycompany.ricettapp.funciones.Instruccion;
import com.mycompany.ricettapp.funciones.Receta;
import com.mycompany.ricettapp.funciones.Recetario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RecetaTest {
    
    private Receta receta;
    
    public RecetaTest() {
        this.receta= new Receta();

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
    public void testRankeo(){
        
        int resultadoEsperado=17;
        this.receta.rankear(5);
        int resultadoFinal=this.receta.getRanking();
        assertEquals(resultadoEsperado,resultadoFinal,0.000001);  
    }
    @Test
    public void testRankeoCeroVotos(){
        String resultadoEsperado="Receta sin valorar";
        this.receta.setVotos(0);
        String resultadoFinal=receta.mostrarRanking();
        assertEquals(resultadoEsperado,resultadoFinal);  
        
    }
    @Test
    public void testVotos(){
        int resultadoEsperado = 3;
        assertEquals(resultadoEsperado,receta.getVotos(),0.00000000001);//0.00000000001 es margen de error
    }
    
    @After
    public void after(){
        this.receta.setRanking(12);
        this.receta.setVotos(3);
    }
}
