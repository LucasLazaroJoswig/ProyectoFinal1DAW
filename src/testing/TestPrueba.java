package testing;


import java.util.ArrayList;
import java.util.List;

import modelo.dao.*;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;





public class TestPrueba {
private static ClienteDao cdao;
private static EmpleadoDao edao;
private static ProyectoDao pdao;
	
	static {
		cdao=new ClienteDaoImplMy8Jpa();
		edao=new EmpleadoDaoImplMy8Jpa();
		pdao=new ProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {

			/*uno();*/
			//todos();
			dias();



		}
	public static void uno() {
		Cliente cl1 = cdao.buscarUno("A22222222");
		System.out.println(cl1.getNombre());
		System.out.println(cl1.getApellidos());
	}

	public static void todos() {
		cdao.buscarTodos().forEach(System.out::println);

	}
	public static void dias() {
		pdao.diasATerminoProyectoActivo("FOR2021002");
	}
		

	}


