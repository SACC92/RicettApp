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
        do{        
                IngresarIngredientes();
		do{ 						
			System.out.println("¿Quiere ingresar otro ingrediente?");
			System.out.println("1.Si");
			System.out.println("2.No");
			opc = leer.nextInt();
		}while(opc!=1 && opc!=2);		
		}while(opc==1);
        System.out.println("");
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
			System.out.println((x+1)+" "+ingredientes.get(x).getNombre());			
		}
	}
	
	public int ObtenerViejoIngrediente(){
		Scanner leer = new Scanner(System.in);
		
				System.out.println("Ingredientes que tiene actualmente la receta:");
                MostrarIngredientes();
                
                System.out.println("¿Qué ingrediente desea cambiar?");
                int oldIng =0;
                do{
                oldIng=(leer.nextInt()-1);
                }while(oldIng>ingredientes.size() || oldIng<0);
                
                return oldIng;                
	}
		
	//Métodos relacionados con el arrayList de instrucciones
	public void CrearInstruccion(){
		int opc=0;
		Scanner leer= new Scanner(System.in);
        do{        
                IngresarPaso();
		do{	
			System.out.println("¿Quiere ingresar otro paso a seguir?");
			System.out.println("1.Si");
			System.out.println("2.No");                        
			opc=leer.nextInt();
		}while(opc!=1 && opc!=2);
        }while(opc==1);
        System.out.println("");
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
