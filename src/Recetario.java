import java.util.ArrayList;
import java.util.Scanner;

public class Recetario {
	
	private static ArrayList<Receta> recetas = new ArrayList<Receta>();
	
	public void agregarReceta(){
		Scanner leer = new Scanner(System.in);
		Receta receta = new Receta();

		System.out.println("Ingrese nombre de la receta");
		String nombre = leer.nextLine();
		//Se fijan nombre de la receta y los ingredientes que tiene
		receta.setNombre(nombre);
		receta.crearIngredientes();
		receta.crearInstruccion();
		
		recetas.add(receta);
	}
	public void quitarReceta(){		
		recetas.remove(preguntar());	
	}
	private static int preguntar(){
		System.out.println("�Qu� receta quiere quitar?");
		mostrarAllRecetas();//muestra las recetas partiendo del n�mero 1, por eso depues hay una resta
		Scanner leer = new Scanner(System.in);
		int opc = leer.nextInt();
		int n=(opc-1);//Considerar que el arraylist empieza en cero
		return n;					
	}
	
	public static void mostrarAllRecetas(){
		for(int x=0; x<recetas.size();x++){
			System.out.println((x+1)+ " " + recetas.get(x).getNombre());
		}
	}
	
	public void findRecetaIngredientes(){
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese ingrediente que tiene");
		String ing = leer.nextLine();
		buscar(ing);
	}
	
	private static void buscar(String ing){
		for(int x=0;x<recetas.size();x++){//El for de aqui es para contar la cantidad de recetas
			
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
	public void verCantidadRecetas(){
		int cantidad=recetas.size();
		System.out.println(cantidad);
	}
	public void rankearRecetas(){
	}
	
	
}
