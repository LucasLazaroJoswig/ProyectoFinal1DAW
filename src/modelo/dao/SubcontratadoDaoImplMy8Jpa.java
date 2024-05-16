package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.Subcontratado;

public class SubcontratadoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements SubcontratadoDao {

	
	public SubcontratadoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Subcontratado obj) {
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
	public boolean eliminar(String clave) {
		try {
			Subcontratado subcontratado= buscarUno(clave);
			if (subcontratado != null) {
				tx.begin();
					em.remove(subcontratado);
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
	public boolean modificar(Subcontratado obj) {
		try {
	 		Subcontratado subcontratado1 = buscarUno(obj.getIdSub());
			if (subcontratado1 != null) {
				tx.begin();
					em.persist(subcontratado1);
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
	public Subcontratado buscarUno(String clave) {
		// TODO Auto-generated method stub
		return em.find(Subcontratado.class, clave);
	}

	@Override
	public List<Subcontratado> buscarTodos() {
		jpql = "select s from Subcontratado s";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Subcontratado> subcontratadoByApellido(String subcadena) {
jpql= "select s from Subcontratado s where s.apellidos like :apellido";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("apellido", "%" + subcadena + "%");
		return query.getResultList();
	}

}
