package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;


public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements EmpleadoDao {

	
	public EmpleadoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Empleado obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			Empleado empleado = buscarUno(clave);
			if (empleado != null) {
				tx.begin();
					em.remove(empleado);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modificar(Empleado obj) {
		try {
			if (buscarUno(obj.getIdEmpl()) != null) {
				tx.begin();
					em.merge(obj);
				tx.commit();
				return true;
			}else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Empleado buscarUno(Integer clave) {
		
		// TODO Auto-generated method stub
		return em.find(Empleado.class, clave);
	}

	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleados e ";
		return em.createQuery(jpql);
			return query.getResultList();
	}

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

	
	


	
}
