package testing;


import modelo.dao.*;
import modelo.entidades.Cliente;




public class TestPrueba {
private static ClienteDao cdao;
	
	static {
		cdao=new ClienteDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
			
			uno();

		}
	public static void uno() {
		Cliente cl1 = cdao.buscarUno("A22222222");
		System.out.println(cl1.getNombre());
		System.out.println(cl1.getApellidos());
	}
		
		

	}


