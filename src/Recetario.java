import java.util.ArrayList;
import java.util.Scanner;

public class Recetario {
	
	private static ArrayList<Receta> recetas = new ArrayList<Receta>();
	
	public void AgregarReceta(){
		Scanner leer = new Scanner(System.in);
		Receta receta = new Receta();

		System.out.println("Ingrese nombre de la receta");
		String nombre = leer.nextLine();
		//Se fijan nombre de la receta y los ingredientes que tiene
		receta.setNombre(nombre);
		receta.CrearIngredientes();
		receta.CrearInstruccion();
		
		recetas.add(receta);
	}
	public void QuitarReceta(){		
		recetas.remove(Preguntar());	
	}
	private static int Preguntar(){
                Scanner leer = new Scanner(System.in);
                
                System.out.println("¿Qué receta quiere quitar?");
		MostrarAllRecetas();//muestra las recetas partiendo del número 1, por eso después hay una resta
		int opc = leer.nextInt();
		int n=(opc-1);//Considerar que el arraylist empieza en cero
		return n;					
	}
	
	public static void MostrarAllRecetas(){
		for(int x=0; x<recetas.size();x++){
			System.out.println((x+1)+ ". " + recetas.get(x).getNombre());
		}
                System.out.println("");
	}
	
	public void FindRecetaIngredientes(){
		Scanner leer = new Scanner(System.in);
		
                System.out.println("Ingrese ingrediente que tiene");
		String ing = leer.nextLine();
		Buscar(ing);
	}
	
	private static void Buscar(String ing){
		for(int x=0;x<recetas.size();x++){//Este for es para contar la cantidad de recetas
			
			/*Este array de abajo lo hice para evitar escribir muchos get().get()*/
			ArrayList<Ingrediente> ingredientes = recetas.get(x).getIngredientes();			
			
			for (int i = 0; i < ingredientes.size(); i++) {	
				//en el if de aqui se compara cada ingrediente de una receta
				if(ing.equals(ingredientes.get(i).getNombre())){
					System.out.println((x+1)+" "+recetas.get(x).getNombre());
					i=ingredientes.size();//por si hay 2 ingredientes con el mismo nombre
				}
			}				
		}	
	}	
	public void VerCantidadRecetas(){
		int cantidad=recetas.size();
                System.out.println("La cantidad de recetas disponibles es: "+ cantidad);
		System.out.println("");                
	}
	public void RankearRecetas(){
	}	
}
