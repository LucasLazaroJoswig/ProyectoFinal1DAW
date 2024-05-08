package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Proyecto;


public class EmpleadoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements EmpleadoDao {

	
	public EmpleadoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

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
			Empleado empleado= buscarUno(clave);
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
	 		Empleado empleado1 = buscarUno(obj.getIdEmpl());
			if (empleado1 != null) {
				tx.begin();
					em.persist(empleado1);
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
		
		return em.find(Empleado.class, clave);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> buscarTodos() {
		jpql = "select e from Empleados e";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
	@Override
	public List<Empleado> empleadosByDepartamento(int idDepar) {
jpql= "select e from Empleado e where e.departamento.idDepar  = :idDepar";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("idDepar",idDepar);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosBySexo(String sexo) {
jpql= "select e from Empleado e where e.genero = :genero";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("genero",sexo);
		return query.getResultList();
	}

	@Override
	public List<Empleado> empleadosByApellido(String subcadena) {
jpql= "select e from Empleado e where e.apellidos like :apellido";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("apellido", "%" + subcadena + "%");
		return query.getResultList();
	}

	@Override
	public double salarioTotal() {
		jpql= "select e from Empleado e";
		
		query = em.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Empleado> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.getSalario()).sum();
	}

	@Override
	public double salarioTotal(int idDepar) {
jpql= "select e from Empleado e where id_depar=:idDepar";
		
		query = em.createQuery(jpql);
		query.setParameter("idDepar",idDepar);
		@SuppressWarnings("unchecked")
		List<Empleado> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.getSalario()).sum();
	
	}

	
	


	
}
