package test.Daos;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.util.Date;
=======
import java.util.Date; 
>>>>>>> 8f023bd444203360bbc5ab9165216a584760ccfb


import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class TestFacturaDao {
	
	private static FacturaDao fdao;
	private static ProyectoDao pdao;


	static {
		fdao=new FacturaDaoImplMy8Jpa();
		pdao=new ProyectoDaoImplMy8Jpa();

	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//altaFactura();
		//buscarUno();
		
		
	}
	
	
	public static void altaFactura() {
		Proyecto proyectod = new Proyecto("FOR2021008", new BigDecimal(315000.00), 30000.00, "Formacion de jefes de proyectos",
											"TERMINADO", new Date(2020-07-31), new Date(2020-06-31),new Date(2020-02-15) ,
											50000.00,  new Cliente("A22222222", "March", "Madrid", 12000000.00, "Carlos",1500 ),
											new Empleado(100, "Diaz", "ediaz@tt.com", new Date(1990-01-12), new Date(1977-02-12), "H", "esteban", "esteban", 90000.00,
													new Departamento(10, "Gestion Personas", "Madrid"), new Perfil(4, "Recusos Humanos", 250.00), null));
		System.out.println(pdao.alta(proyectod));
		System.out.println(fdao.altaFactura(new Factura("F2020004", "Formacion a cliente 1", new Date(2023-01-11), proyectod)));
		
		
		


	

	}
	public static void buscarUno() {
		System.out.println(fdao.buscarUno("E1023781")); 

	}

}
