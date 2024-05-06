package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;




public class ClienteDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements ClienteDao{

	
	public ClienteDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Cliente obj) {
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
			Cliente cliente = buscarUno(clave);
			if (cliente != null) {
				tx.begin();
					em.remove(cliente);
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
	public boolean modificar(Cliente obj) {
		try {
	 		Cliente cliente1 = buscarUno(obj.getCif());
			if (cliente1 != null) {
				tx.begin();
					em.persist(cliente1);
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
	public Cliente buscarUno(String clave) {
		
		return em.find(Cliente.class, clave);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		jpql = "select c from Cliente c";
		query = em.createQuery(jpql);
		return query.getResultList();
	}
	
}
