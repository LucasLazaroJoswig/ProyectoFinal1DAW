package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Departamento;

public class DepartamentoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements DepartamentoDao{

	
	public DepartamentoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Departamento obj) {
		try {
			tx.begin();
				em.persist(obj);
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean eliminar(Integer clave) {
		try {
			Departamento departamento = buscarUno(clave);
			if (departamento != null) {
				tx.begin();
					em.remove(departamento);
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
	public boolean modificar(Departamento obj) {
		try {
	 		Departamento departamento1 = buscarUno(obj.getIdDepar());
			if (departamento1 != null) {
				tx.begin();
					em.persist(departamento1);
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
	public Departamento buscarUno(Integer clave) {
		return em.find(Departamento.class, clave);
	}

	@Override
	public List<Departamento> buscarTodos() {
		jpql = "select d from Departamento d";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
