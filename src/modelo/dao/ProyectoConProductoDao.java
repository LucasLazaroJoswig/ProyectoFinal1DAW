package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;

public interface ProyectoConProductoDao extends IntGenericoCrud<Integer, ProyectoConProducto>{

	List<ProyectoConProducto> productosByProyecto(String codigoProyecto);
	String asignarProductosAProyecto(List<ProyectoConProducto> empleados);
	double TotalProductosByProyecto(String codigoProyecto);
	}
