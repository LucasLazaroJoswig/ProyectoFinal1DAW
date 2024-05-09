package modelo.dao;

import java.util.List;

import modelo.entidades.Empleado;
import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;

public class ProyectoConProductoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements ProyectoConProductoDao{

	@Override
	public boolean alta(ProyectoConProducto obj) {
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
			ProyectoConProducto prod = buscarUno(clave);
			if (prod != null) {
				tx.begin();
					em.remove(prod);
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
	public boolean modificar(ProyectoConProducto obj) {
		try {
			ProyectoConProducto prod = buscarUno(obj.getNumOrden());
			if (prod != null) {
				tx.begin();
					em.persist(prod);
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
	public ProyectoConProducto buscarUno(Integer clave) {
		return em.find(ProyectoConProducto.class, clave);
	}

	@Override
	public List<ProyectoConProducto> buscarTodos() {
		jpql = "select ep from ProyectoConProducto ep";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<ProyectoConProducto> productosByProyecto(String codigoProyecto) {
		jpql = "select ep from ProyectoConProducto ep where ep.proyecto.idProyecto = ?1";
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter(1,codigoProyecto);
		//return query.getResultList();
	 	List<ProyectoConProducto> productosList = query.getResultList();
	 	return productosList;
	}

	@Override
	public int asignarProductosAProyecto(List<ProyectoConProducto> empleados) {
		try {
			tx.begin();
				em.persist(empleados);
			tx.commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public double TotalProductosByProyecto(String codigoProyecto) {
		jpql = "select ep from ProyectoConProducto ep where ep.proyecto.idProyecto = ?1";
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter(1,codigoProyecto);
		//return query.getResultList();
	 	List<ProyectoConProducto> productosList = query.getResultList();
		return productosList.stream().mapToDouble(p -> p.getCantidad()).sum();
	}


}
