package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;

public interface ProyectoConProductoDao extends IntGenericoCrud<Integer, ProyectoConProducto>{

	List<ProyectoConProducto> productosByProyecto(String codigoProyecto);
	int asignarProductosAProyecto(List<ProyectoConProducto> empleados);
	}
