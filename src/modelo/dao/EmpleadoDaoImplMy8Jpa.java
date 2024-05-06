package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;

public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements EmpleadoDao {

	
	

	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosBySexo(char sexo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double salarioTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double salarioTotal(int idDepar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean alta(Empleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Empleado obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Empleado buscarUno(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
