package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.SubcontratadosConProyecto;

public interface SubcontratadoConProyectoDao extends IntGenericoCrud<Integer, SubcontratadosConProyecto> {
	
	List<SubcontratadosConProyecto> empleadosByProyecto(String codigoProyecto);
	String asignarEmpleadosAProyecto(List<SubcontratadosConProyecto> empleados);
	int horasAsignadasAProyecto(String codigoProyecto);
	double costeActualDeProyecto(String codigoProyecto);
	double margenActualProyecto(String codigoProyecto);
}

