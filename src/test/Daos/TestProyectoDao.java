package test.Daos;

import java.awt.Image;
import java.math.BigDecimal;
import java.util.Date;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;





public class TestProyectoDao {



	private static ProyectoDao pdao;
	static {
		pdao=new ProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		
		
		//altaProy();
		//buscarUno();
		//Eliminar();
		//buscarTodos();
		//proyectosByEstado();
		//proyectosByCliente();
		//proyectosByJefeProyectoAndByEstado();
		//importesVentaProyectosTerminados();
		//margenBrutoProyectosTerminados();
		diasATerminoProyectoActivo();
	
	}
	
	public static void altaProy() {
	
	
		System.out.println( pdao.alta(new Proyecto("FOR2021010", new BigDecimal(315000.00), 30000.00, "Formacion de jefes de proyectos",
				"TERMINADO", new Date(2020-07-31), new Date(2020-06-31),new Date(2020-02-15) ,
				50000.00,  new Cliente("A22222222", "March", "Madrid", 12000000.00, "Carlos",1500 ),
				new Empleado(100, "Diaz", "ediaz@tt.com", new Date(1990-01-12), new Date(1977-02-12), "H", "esteban", "esteban", new BigDecimal(90000.00) ,
						new Departamento(10, "Gestion Personas", "Madrid"), new Perfil(4, "Recusos Humanos", 250.00), null))));
	}
	
		public static void buscarUno() {
			System.out.println(pdao.buscarUno("FOR2020001")); 

		}
		public static void Eliminar() {
			System.out.println(pdao.eliminar("FOR2020001"));
			
		}
		public static void buscarTodos() {
			pdao.buscarTodos().forEach(System.out::println);

		}
		public static void proyectosByEstado() { 
			pdao.proyectosByEstado("TERMINADO").forEach(System.out::println);
		}
		public static void proyectosByCliente() {
			pdao.proyectosByCliente("A22222222").forEach(System.out::println);

		}
		
		public static void proyectosByJefeProyectoAndByEstado() {
			pdao.proyectosByJefeProyectoAndByEstado(114, "TERMINADO").forEach(System.out::println);

		}
		
		public static void importesVentaProyectosTerminados() {
			System.out.println(pdao.importesVentaProyectosTerminados());

		}
		
		
		public static void margenBrutoProyectosTerminados() {
			System.out.println(pdao.margenBrutoProyectosTerminados());

		}
		
		public static void diasATerminoProyectoActivo() {
			System.out.println(pdao.diasATerminoProyectoActivo("FOR2020001"));

		}
		

	
}
