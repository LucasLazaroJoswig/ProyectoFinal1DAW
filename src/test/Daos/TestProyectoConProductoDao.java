package test.Daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;
import modelo.entidades.ProyectoConEmpleado;
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
		//alta();
		//eliminar();
		//buscarUno();
		//buscarTodos();
		//productosByProyecto();
		asignarProductosAProyecto();
		//TotalProductosByProyecto();
		}
	
	public static void alta() {
		/*Proyecto proyecto1 = new Proyecto("EGM1907005",6000,7000,"Producto para envío","En proceso",new Date(06-05-2024),new Date (04-05-2024)
				,new Date(01-05-2024),10000, new Cliente("B22222222","Pepe","Carrasco",1000000,"Burgos",125 ),new Empleado(121, "Nilla", "pmilla@gmail.com", new Date(2000-11-21), new Date(1999-11-21), "H", "pere0", "pere", 10000, null, null, null));
		
		System.out.println(pdao.alta(proyecto1));*/
		ProyectoConProducto proy_prod=new ProyectoConProducto(0, 100, 200, ppdao.buscarUno(1) ,pdao.buscarUno("FOR2021001"));
		System.out.println(pcpdao.alta(proy_prod));
		
		}
	public static void eliminar() {
		System.out.println(pcpdao.eliminar(1));
		}

	public static void buscarUno() {
		System.out.println(pcpdao.buscarUno(2));
	}
	public static void buscarTodos() {
		System.out.println(pcpdao.buscarTodos());
	}
	public static void productosByProyecto() {
		System.out.println(pcpdao.productosByProyecto("FOR2021001"));
	}
	public static void asignarProductosAProyecto() {
		List<ProyectoConProducto> productos = new ArrayList<ProyectoConProducto>();
		productos.add(new ProyectoConProducto(0, 100, 200, ppdao.buscarUno(1) ,pdao.buscarUno("FOR2021001")));
		productos.add(new ProyectoConProducto(0, 50, 200, ppdao.buscarUno(1) ,pdao.buscarUno("FOR2020001")));
		
		System.out.println(pcpdao.asignarProductosAProyecto(productos));
	}
	public static void TotalProductosByProyecto() {
		System.out.println(pcpdao.TotalProductosByProyecto("FOR2021001"));
	}

}
