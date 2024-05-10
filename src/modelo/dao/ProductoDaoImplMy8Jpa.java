package modelo.dao;

import java.util.List;

import modelo.entidades.Producto;

public class ProductoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements ProductoDao{

	public ProductoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Producto obj) {
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
			Producto producto = buscarUno(clave);
			if (producto != null) {
				tx.begin();
					em.remove(producto);
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
	public boolean modificar(Producto obj) {
		try {
	 		Producto producto1 = buscarUno(obj.getIdProducto());
			if (producto1 != null) {
				tx.begin();
					em.persist(producto1);
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
	public Producto buscarUno(Integer clave) {
		return em.find(Producto.class, clave);
	}

	@Override
	public List<Producto> buscarTodos() {
		jpql = "select p from Producto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

}
