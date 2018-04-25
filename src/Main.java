import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		ValidadorMenu();
	}
	
        private static void Texto(){
        
        System.out.println("¿Qué desea hacer?");	
        System.out.println("1. Ver recetas");
        System.out.println("2. Agregar recetas");	
        System.out.println("3. Borrar Receta");	        
        System.out.println("4. Ingredientes");
        System.out.println("5. Salir");	        
	}
	
        
	private static void ValidadorMenu(){
		Scanner leer = new Scanner(System.in);
                int opc=0;
		do{                
                    Texto();
                    opc = leer.nextInt();
                    
		}while(opc>5 || opc <1);
		
		OpcionElegida(opc);
	}
	

	private static void OpcionElegida(int opc){
		
		Recetario recetario = new Recetario();
		
		switch(opc){
		
			case 1: recetario.VerCantidadRecetas();
					recetario.ElegirReceta();					
					break;			
			case 2: recetario.AgregarReceta();
					break;
			case 3: recetario.QuitarReceta();
					break;
			case 4: Case4(recetario);
					break;
			case 5: System.out.println("Gracias por utilizar RicettApp");
                    break;  
		}
		if(opc!=5){
			ValidadorMenu();
		}		
	}
	
	private static void Case4(Recetario recetario){
		int opcCase5 =0;
		Scanner leer = new Scanner(System.in);
		do{
		System.out.println("1. Buscar recetas con cierto ingrediente");
		System.out.println("2. Cambiar ingrediente");
		opcCase5= leer.nextInt();
		}while(opcCase5!=1 && opcCase5!=2);
		evaluarOpcCase4(recetario,opcCase5);
	}
	
	private static void evaluarOpcCase4(Recetario recetario, int opcCase5){
		if(opcCase5==1){
			recetario.FindRecetaIngredientes();
		}else{
			if(opcCase5==2){
				recetario.MostrarAllRecetas();
				recetario.CambiarIng();
			}else{
				System.out.println("Error");
			}
		}		
	}
}
