import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		ValidadorMenu();
	}
	
        private static void Texto(){
        
        System.out.println("¿Qué desea hacer?");	
        System.out.println("1. Ver recetas");	
        System.out.println("2. Rankear Receta");//Método debe ser creado
        System.out.println("3. Agregar recetas");	
        System.out.println("4. Borrar Receta");	        
        System.out.println("5. Ingredientes");
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
		
			case 1: recetario.VerCantidadRecetas();
					recetario.ElegirReceta();					
					break;
			case 2: 
					break;
			case 3: recetario.AgregarReceta();
					break;
			case 4: recetario.QuitarReceta();
					break;
			case 5: Case5(recetario);
					break;
			case 6: System.out.println("Gracias por utilizar RicettApp");
                    break;  
		}
		if(opc!=6){
			ValidadorMenu();
		}		
	}
	
	private static void Case5(Recetario recetario){
		int opcCase5 =0;
		Scanner leer = new Scanner(System.in);
		do{
		System.out.println("1. Buscar recetas con cierto ingrediente");
		System.out.println("2. Cambiar ingrediente");
		opcCase5= leer.nextInt();
		}while(opcCase5!=1 && opcCase5!=2);
		evaluarOpcCase5(recetario,opcCase5);
	}
	
	private static void evaluarOpcCase5(Recetario recetario, int opcCase5){
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
