package modelo.dao;

import java.util.List;


import modelo.entidades.Subcontratado;

public interface SubcontratadoDao extends IntGenericoCrud<String, Subcontratado> {
	List<Subcontratado> subcontratadoByApellido(String subcadena);
}
