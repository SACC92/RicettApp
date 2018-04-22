import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		menu();
	}
	
	private static void menu(){
		texto();
		Scanner leer = new Scanner(System.in);
		int opc=0; 
		do{
			opc= leer.nextInt();
			
		}while(opc>5 || opc <1);
		
		opcionElegida(opc);
	}
	
	private static void texto(){
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Agregar receta");
		System.out.println("2. Ver todas las recetas");
		System.out.println("3. Ver cantidad de recetas");
		System.out.println("4. Borrar receta");
		System.out.println("5. Salir");
	}
	
	private static void opcionElegida(int opc){
		
		Recetario recetario = new Recetario();
		
		switch(opc){
			case 1: recetario.agregarReceta();
					break;
			case 2: recetario.mostrarAllRecetas();
					break;
			case 3: recetario.verCantidadRecetas();
					break;
			case 4: recetario.quitarReceta();
					break;
			case 5: System.out.println("¡Adiós!");
		}
		if(opc<5 ||opc>0){
			menu();
		}
	}	
}
