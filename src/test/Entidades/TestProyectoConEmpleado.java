package test.Entidades;

import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {
	private static EmpleadoEnProyectoDao epdao;
	static {
		epdao=new ProyectoConEmpleadoDaoImplMy8Jpa();
	}
public static void main(String[] args) {
	
	ProyectoConEmpleado proy_emp=epdao.buscarUno(1);
	System.out.println(proy_emp.costeHorasAsignadas());
}
}
