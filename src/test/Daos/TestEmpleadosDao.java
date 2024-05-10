package test.Daos;

import java.math.BigDecimal;
import java.util.Date;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleadosDao {



	private static EmpleadoDao edao;
	static {
		edao=new EmpleadoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		
		
		//altaEmpl();
		//buscarUno();
		//Eliminar();
		//buscarTodos();
		//empleadoPorDepart();
		empleadoPorsexo();
		//empleadoPorApellido();
		//salarioTotal();
		//salarioTotalDepart();
	
	}
	public static void altaEmpl() {
		System.out.println( edao.alta(new Empleado(0, "Gomez", "agomez@tt.com", new Date(1992-04-11), new Date(1983-11-11),
													"M", "Andrea", "Andrea", new BigDecimal(30000), new Departamento(10, "Gestion Personas", "Madrid") ,
													new Perfil(4, "Recusos Humanos", 250.00), null )));
	

	}
	
		public static void buscarUno() {
			System.out.println(edao.buscarUno(101)); 

		}
		public static void Eliminar() {
			System.out.println(edao.eliminar(121));
			
		}
		public static void buscarTodos() {
			edao.buscarTodos().forEach(System.out::println);

		}
		public static void empleadoPorDepart() {
			edao.empleadosByDepartamento(10).forEach(System.out::println);
		}
		public static void empleadoPorsexo() {
			edao.empleadosBySexo("M").forEach(System.out::println);;
		}
		public static void empleadoPorApellido() {
			System.out.println(edao.empleadosByApellido("Hernandez"));
		}
		
		public static void salarioTotal() {
			System.out.println(edao.salarioTotal());
		}
		public static void salarioTotalDepart() {
			System.out.println(edao.salarioTotal(10));
		}
		

		
		
		

	


	}
