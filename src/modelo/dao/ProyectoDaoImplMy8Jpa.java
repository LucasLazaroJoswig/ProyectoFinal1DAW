package modelo.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import modelo.entidades.Proyecto;


public class ProyectoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements ProyectoDao{

	
	public ProyectoDaoImplMy8Jpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean alta(Proyecto obj) {
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
	public boolean eliminar(String clave) {
		try {
			Proyecto proyecto = buscarUno(clave);
			if (proyecto != null) {
				tx.begin();
					em.remove(proyecto);
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
	public boolean modificar(Proyecto obj) {
		try {
	 		Proyecto proyecto1 = buscarUno(obj.getIdProyecto());
			if (proyecto1 != null) {
				tx.begin();
					em.persist(proyecto1);
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
	public Proyecto buscarUno(String clave) {
		return em.find(Proyecto.class, clave);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Proyecto> buscarTodos() {
		jpql = "select p from Proyecto p";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByEstado(String estado) {
		// TODO Auto-generated method stub
jpql= "select p from Proyecto p where estado = :estado";
		
		query = em.createQuery(jpql);
	 	query.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByCliente(String cif) {
		jpql= "select p from Proyecto p where cif = :cif";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("cif", cif);
		return query.getResultList();
	}

	@Override
	public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
jpql= "select p from Proyecto p where jefe_proyecto = :jefeProyecto and estado = :estado";
		
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter("estado", estado);
	 	query.setParameter("jefe_proyecto", jefeProyecto);
		return query.getResultList();
	}

	@Override
	public double importesVentaProyectosTerminados() {
		jpql = "SELECT p from Proyecto p where p.estado = 'TERMINADO'";
<<<<<<< HEAD
=======

>>>>>>> f9d74c38ec6c12eb1da834e11ba632ffeb1dada8
		//jpql ="SELECT sum(p.venta_previsto) as suma_venta_previsto from Proyecto p where p.estado ='TERMINADO'";
		query = em.createQuery(jpql);
		
		@SuppressWarnings("unchecked")
		List<Proyecto> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.getVentaPrevisto()).sum();
		
	}

	@Override
	public double margenBrutoProyectosTerminados() {
		jpql = "SELECT p from Proyecto p where p.estado = 'TERMINADO'";
		//jpql ="SELECT sum(p.venta_previsto) as suma_venta_previsto from Proyecto p where p.estado ='TERMINADO'";
		query = em.createQuery(jpql);
		
		@SuppressWarnings("unchecked")
		List<Proyecto> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.getVentaPrevisto()-p.getCosteReal().doubleValue()).sum();
	}

	@Override
	public int diasATerminoProyectoActivo(String codigoProyecto) {
		Proyecto p = em.find(Proyecto.class, codigoProyecto);
		Date fecha_hoy = new Date(System.currentTimeMillis());
		Date fecha_prevista = p.getFechaFinPrevisto();
		int dias = (int)((fecha_hoy.getTime()-fecha_prevista.getTime()));
		return dias;
		
		
	}

}
