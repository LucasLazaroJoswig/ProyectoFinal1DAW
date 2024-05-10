package modelo.dao;

import java.util.List;

import modelo.entidades.Perfil;

public class PerfilDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements PerfilDao{

	public PerfilDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Perfil obj) {
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
			Perfil perfil = buscarUno(clave);
			if (perfil != null) {
				tx.begin();
					em.remove(perfil);
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
	public boolean modificar(Perfil obj) {
		try {
	 		Perfil perfil1 = buscarUno(obj.getIdPerfil());
			if (perfil1 != null) {
				tx.begin();
					em.persist(perfil1);
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
	public Perfil buscarUno(Integer clave) {
		return em.find(Perfil.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscarTodos() {
		jpql = "select p from Perfil  p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
}
