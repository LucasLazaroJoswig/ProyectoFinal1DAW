package test.Entidades;

import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.ProductoDao;
import modelo.dao.ProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDao;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.ProyectoConProducto;

public class TestProyectoConProducto {
	private static ProyectoConProductoDao ppdao;
	private static ProductoDao prodDao;
	private static ProyectoDao proyDao;
	static {
		ppdao=new ProyectoConProductoDaoImplMy8Jpa();
		proyDao= new ProyectoDaoImplMy8Jpa();
		prodDao = new ProductoDaoImplMy8Jpa();
	}
public static void main(String[] args) {
	//System.out.println(ppdao.alta(new ProyectoConProducto(1, 50, 100, prodDao.buscarUno(1), proyDao.buscarUno("FOR2020001"))));
	
	ProyectoConProducto proy_prod=(new ProyectoConProducto(1, 50, 100, prodDao.buscarUno(1), proyDao.buscarUno("FOR2020001")));
	System.out.println(proy_prod.costeTotalProductos());
}
}
