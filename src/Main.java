import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		ValidadorMenu();
	}
	
        private static void Texto(){
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Agregar receta");
		System.out.println("2. Ver todas las recetas");
		System.out.println("3. Ver cantidad de recetas");
		System.out.println("4. Borrar receta");
		System.out.println("5. Buscar ingrediente");
		System.out.println("6. Salir");
	}
	
        
	private static void ValidadorMenu(){
		Scanner leer = new Scanner(System.in);
                int opc=0;
		do{                
                    Texto();
                    opc = leer.nextInt();
                    
		}while(opc>6 || opc <1);
		
		OpcionElegida(opc);
	}
	

	private static void OpcionElegida(int opc){
		
		Recetario recetario = new Recetario();
		
		switch(opc){
			case 1: recetario.AgregarReceta();
					break;
			case 2: recetario.MostrarAllRecetas();
					break;
			case 3: recetario.VerCantidadRecetas();
					break;
			case 4: recetario.QuitarReceta();
					break;
			case 5: recetario.FindRecetaIngredientes();
					break;
			case 6: System.out.println("Gracias por utilizar RicettApp");
                    break;  
		}
		if(opc!=6){
			ValidadorMenu();
		}		
	}	
}
