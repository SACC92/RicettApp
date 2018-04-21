import java.util.ArrayList;
import java.util.Scanner;

public class Receta {
	
	private ArrayList<Ingrediente> ingredientes;	
	private String nombre;
	
	Receta(){
		this.nombre=" ";
		this.ingredientes=new ArrayList<Ingrediente>();
	}	
	//Métodos relacionados con ingredientes	
	
	
	public void crearIngredientes(){
		int opc=0;
		Scanner leer = new Scanner(System.in);
		do{ ingresarIngredientes();						
			System.out.println("¿Quiere ingresar otro ingrediente?");
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
}
