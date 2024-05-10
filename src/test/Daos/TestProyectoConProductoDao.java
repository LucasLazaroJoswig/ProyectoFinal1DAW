package test.Daos;

import java.sql.Date;

import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConProducto;
 


public class TestProyectoConProductoDao {
	
	private static ProyectoConProductoDao pcpdao;
	private static ProyectoDao pdao;
	private static ProductoDao ppdao;
	
	static {
		ppdao=new ProductoDaoImplMy8Jpa();
		pcpdao= new ProyectoConProductoDaoImplMy8Jpa();
		pdao= new ProyectoDaoImplMy8Jpa();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		alta();
		}
	
	public static void alta() {
		/*Proyecto proyecto1 = new Proyecto("EGM1907005",6000,7000,"Producto para envío","En proceso",new Date(06-05-2024),new Date (04-05-2024)
				,new Date(01-05-2024),10000, new Cliente("B22222222","Pepe","Carrasco",1000000,"Burgos",125 ),new Empleado(121, "Nilla", "pmilla@gmail.com", new Date(2000-11-21), new Date(1999-11-21), "H", "pere0", "pere", 10000, null, null, null));
		
		System.out.println(pdao.alta(proyecto1));*/
		ProyectoConProducto proy_prod=new ProyectoConProducto(1, 100, 200, ppdao.buscarUno(1) ,pdao.buscarUno("FOR2021001"));
		System.out.println(pcpdao.alta(proy_prod));
		
		}
	public static void eliminar() {
		
		}
	public static void modificar() {
	
		}
	public static void buscarUno() {
	
	}

}
