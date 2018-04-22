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
	//M�todos relacionados con ingredientes		
	public void crearIngredientes(){
		int opc=0;
		Scanner leer = new Scanner(System.in);
		do{ ingresarIngredientes();						
			System.out.println("�Quiere ingresar otro ingrediente?");
			System.out.println("1.Si");
			System.out.println("2.No");
			opc = leer.nextInt();
		}while(opc!=2);		
	}	
	
	private void ingresarIngredientes(){
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese ingrediente de la receta");
		Ingrediente ingrediente = new Ingrediente();
		String nombre = leer.nextLine();
		ingrediente.setNombre(nombre);
		
		this.ingredientes.add(ingrediente);
	}
	public void mostrarIngredientes(){
		for(int x=0;x<ingredientes.size();x++){
			System.out.println(ingredientes.get(x).getNombre());			
		}
	}
	public void cambiarIngredientes(){
		
	}	
	
	//M�todos relacionados con el arrayList de instrucciones
	public void crearInstruccion(){
		int opc=0;
		Scanner leer= new Scanner(System.in);
		do{	ingresarPaso();
			System.out.println("�Quiere ingresar otro paso a seguir?");
			System.out.println("1.Si");
			System.out.println("2.No");
			opc=leer.nextInt();
		}while(opc!=2);
	}
	private void ingresarPaso(){
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese paso");
		Instruccion instruccion = new Instruccion();
		String paso = leer.nextLine();
		instruccion.setPaso(paso);
		
		this.instrucciones.add(instruccion);
	}	
	public void mostrarInstrucciones(){
		for(int x=0;x<instrucciones.size();x++){
			System.out.println(instrucciones.get(x).getPaso());			
		}
	}
	
	//M�todos get y set
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
