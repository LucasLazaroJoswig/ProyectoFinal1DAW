package modelo.dao;

import java.util.List;

import modelo.entidades.Familia;

public class FamiliaDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements FamiliaDao{

	public FamiliaDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Familia obj) {
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
			Familia familia = buscarUno(clave);
			if (familia != null) {
				tx.begin();
					em.remove(familia);
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
	public boolean modificar(Familia obj) {
		try {
	 		Familia familia1 = buscarUno(obj.getIdFamilia());
			if (familia1 != null) {
				tx.begin();
					em.persist(familia1);
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
	public Familia buscarUno(Integer clave) {
		return em.find(Familia.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Familia> buscarTodos() {
		jpql = "select f from Familia f";
		query = em.createQuery(jpql);
		return query.getResultList();
	}


}
