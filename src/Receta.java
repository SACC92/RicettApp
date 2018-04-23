import java.util.ArrayList;
import java.util.Scanner;

public class Receta {
	
	private ArrayList<Ingrediente> ingredientes;	
	private ArrayList<Instruccion> instrucciones;
	private String nombre;
	
	Receta(){
		this.nombre=" ";
		this.ingredientes=new ArrayList<Ingrediente>();
		this.instrucciones=new ArrayList<Instruccion>();
	}		
	//Métodos relacionados con ingredientes		
	public void CrearIngredientes(){
		int opc=0;
		Scanner leer = new Scanner(System.in);
                
		do{ IngresarIngredientes();						
			System.out.println("¿Quiere ingresar otro ingrediente?");
			System.out.println("1.Si");
			System.out.println("2.No");
                        System.out.println("");
			opc = leer.nextInt();
		}while(opc!=2);		
	}	
	
	private void IngresarIngredientes(){
		Scanner leer = new Scanner(System.in);
                
		System.out.println("Ingrese ingrediente de la receta");
		Ingrediente ingrediente = new Ingrediente();
		String nombre = leer.nextLine();
		ingrediente.setNombre(nombre);
		
		this.ingredientes.add(ingrediente);
	}
	public void MostrarIngredientes(){
		for(int x=0;x<ingredientes.size();x++){
			System.out.println(ingredientes.get(x).getNombre());			
		}
	}
	public void CambiarIngredientes(){
		Scanner leer = new Scanner(System.in);
                
                System.out.println("¿Qué ingrediente desea cambiar?");
                String oldIng = leer.nextLine();
                int posicion = BuscarIngrediente(oldIng);
                
                if( posicion !=-1 ){
                    System.out.println("Ingrese el nuevo ingrediente");
                    String newIng = leer.nextLine();
                    ingredientes.get(posicion).setNombre(newIng);
                }
                else{
                    System.out.println("No se puede realizar el cambio");
                }
                
	}	
	
        private int BuscarIngrediente(String ingrediente){
                int pos = -1; 
            
                for(int x=0;x<ingredientes.size();x++){
                    if (ingredientes.get(x).equals(ingrediente)){
                        pos = x;
                        System.out.println("Ingrediente encontrado");
                    }
                    else{
                        System.out.println("Ingrediente no encontrado");
                    }
                }
                return pos;
        }
        
	//Métodos relacionados con el arrayList de instrucciones
	public void CrearInstruccion(){
		int opc=0;
		Scanner leer= new Scanner(System.in);
                
		do{	IngresarPaso();
			System.out.println("¿Quiere ingresar otro paso a seguir?");
			System.out.println("1.Si");
			System.out.println("2.No");
                        System.out.println("");
			opc=leer.nextInt();
		}while(opc!=2);
	}
	private void IngresarPaso(){
		Scanner leer = new Scanner(System.in);
                
		System.out.println("Ingrese paso");
		Instruccion instruccion = new Instruccion();
		String paso = leer.nextLine();
		instruccion.setPaso(paso);
		
		this.instrucciones.add(instruccion);
	}	
	public void MostrarInstrucciones(){
		for(int x=0;x<instrucciones.size();x++){
			System.out.println(instrucciones.get(x).getPaso());			
		}
                System.out.println("");
	}
	
	//Métodos get y set
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public ArrayList<Instruccion> getInstruccion(){
		return instrucciones;
	}
	public void setInstruccion(ArrayList<Instruccion> instrucciones){
		this.instrucciones=instrucciones;
	}
}
