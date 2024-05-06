package testing;


import modelo.dao.*;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;




public class TestPrueba {
private static ClienteDao cdao;
private static EmpleadoDao edao;
	
	static {
		cdao=new ClienteDaoImplMy8Jpa();
		edao=new EmpleadoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
			
			//uno();
			dos();

		}
	public static void uno() {
		Cliente cl1 = cdao.buscarUno("A22222222");
		System.out.println(cl1.getNombre());
		System.out.println(cl1.getApellidos());
	}
	public static void dos() {
		//Empleado empl1 = edao.buscarUno(100);
		//System.out.println(empl1.getNombre());
		//System.out.println(empl1.getApellidos());
		cdao.buscarTodos().forEach(System.out::println);
		
	}
		

	}


