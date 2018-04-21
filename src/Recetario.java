import java.util.ArrayList;
import java.util.Scanner;

public class Recetario {
	
	private static ArrayList<Receta> recetas = new ArrayList<Receta>();
	
	/*
	 * Para probar esta clase
	 * 
	 * public static void main(String[] args){
		Recetario rec = new Recetario();
		rec.agregarReceta();
		rec.agregarReceta();
		rec.findRecetaIngredientes();		
	}
	*/
	
	public void agregarReceta(){
		Scanner leer = new Scanner(System.in);
		Receta receta = new Receta();

		System.out.println("Ingrese nombre de la receta");
		String nombre = leer.nextLine();
		//Se fijan nombre de la receta y los ingredientes que tiene
		receta.setNombre(nombre);
		receta.crearIngredientes();
		
		recetas.add(receta);
	}
	public void quitarReceta(){		
		recetas.remove(preguntar());	
	}
	private static int preguntar(){
		System.out.println("¿Qué receta quiere quitar?");
		mostrarAllRecetas();
		Scanner leer = new Scanner(System.in);
		int opc = leer.nextInt();
		int n=(opc-1);//Considerar que el arraylist empieza en cero
		return n;					
	}
	public static void mostrarAllRecetas(){
		for(int x=0; x<recetas.size();x++){
			System.out.println((x+1)+ " " + recetas.get(x));
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
			/*Este array de abajo lo hice por pereza para evitar escribir mucho
			  era para evitar hacer tantos get.get.get.get... que se veian feos	*/
			ArrayList<Ingrediente> ingredientes = recetas.get(x).getIngredientes();
			//en el for de aqui se compara cada elemento de una receta
			for (int i = 0; i < ingredientes.size(); i++) {				
				if(ing.equals(ingredientes.get(i).getNombre())){
					System.out.println((x+1)+" "+recetas.get(x).getNombre());
				}
			}	
			
		}	
	}	
	public int verCantidadRecetas(){
		int cantidad=recetas.size();
		return cantidad;
	}
	public void rankearRecetas(){
	}
	
	
}
