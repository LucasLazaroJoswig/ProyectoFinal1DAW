package test.Daos;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entidades.Cliente;



public class TestClienteDao {
	

		private static ClienteDao cdao;


		static {
			cdao=new ClienteDaoImplMy8Jpa();
		
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			
			//altaCliente();
			//buscarUno();
			//Eliminar();
			buscarTodos();
		
		
		}
			
		public static void altaCliente() {
			System.out.println( cdao.alta(new Cliente("C44444444", "Gutierrez", "La Valeta", 6000000, "Alfonso", 155)));
		
	
		}
		
			public static void buscarUno() {
				System.out.println(cdao.buscarUno("C44444444").getNombre()); 

			}
			public static void Eliminar() {
				System.out.println(cdao.eliminar("C44444444"));
				
			}
			public static void buscarTodos() {
				cdao.buscarTodos().forEach(System.out::println);

			}
	}

