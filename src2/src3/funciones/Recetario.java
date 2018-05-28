package funciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Recetario {
	
	public static ArrayList<Receta> recetas = new ArrayList<Receta>();
	
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
                
                System.out.println("�Qu� receta quiere quitar?");
		MostrarAllRecetas();//muestra las recetas partiendo del n�mero 1, por eso despu�s hay una resta
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
        
        public String buscarIngredienteGUI(String ing){
            //Métdo debe ser mejorado, pues solo sirve para 1 resultado
            String resultado = " ";
		for(int x=0; x<recetas.size();x++){
                    for(int y=0;y<recetas.get(x).getIngredientes().size();y++){
                        
                        if(ing.equals(recetas.get(x).getIngredientes().get(y).getNombre())){
                            resultado =recetas.get(x).getNombre();
                        }
                        
                    }
                }                
            return resultado;
	}        
        
	public void CambiarIng(){
		Scanner antiguo = new Scanner(System.in);
		Scanner nuevo = new Scanner(System.in);
		int opc;
		System.out.println("Ingrese receta a la que desea cambiar sus ingredientes");
		do{
			opc = (antiguo.nextInt()-1);
		}while(opc>recetas.size() ||opc<0);
		Receta receta = recetas.get(opc);
		
		ArrayList<Ingrediente> ingrediente = recetas.get(opc).getIngredientes();
		int a= receta.ObtenerViejoIngrediente();
		Ingrediente ingredienteViejo =ingrediente.get(a);
		
		System.out.println("Ingrese nuevo ingrediente");
		String newIng= nuevo.nextLine();
		ingredienteViejo.setNombre(newIng);
	}
		
	public int VerCantidadRecetas(){
		return recetas.size();               
	}
	
	public void ElegirReceta(){
		if(recetas.size()!=0){
			
		int recetaElegida = 0;
		Scanner leer = new Scanner(System.in);
		MostrarAllRecetas();
		
		System.out.println("Escoja la receta que desea ver");		
		recetaElegida=(leer.nextInt()-1);
		MostrarOpcionElegida(recetaElegida);		
		}
	}
	
	private static void MostrarOpcionElegida(int recetaElegida){		
		System.out.println("Nombre de la receta:" +" "+ recetas.get(recetaElegida).getNombre());		
		System.out.println("Ingredientes:");
		recetas.get(recetaElegida).MostrarIngredientes();		
		System.out.println("Instrucciones:");
		recetas.get(recetaElegida).MostrarInstrucciones();		
	}
	
	public void RankearRecetas(){
	}	
}
