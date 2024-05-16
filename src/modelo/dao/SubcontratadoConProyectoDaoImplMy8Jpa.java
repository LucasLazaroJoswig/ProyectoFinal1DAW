package modelo.dao;

import java.util.List;

import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.SubcontratadosConProyecto;

public class SubcontratadoConProyectoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements SubcontratadoConProyectoDao {

	@Override
	public boolean alta(SubcontratadosConProyecto obj) {
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
			SubcontratadosConProyecto sub = buscarUno(clave);
			if (sub != null) {
				tx.begin();
					em.remove(sub);
				tx.commit();
				return true;
			}else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	}

	@Override
	public boolean modificar(SubcontratadosConProyecto obj) {
		try {
			SubcontratadosConProyecto sub = buscarUno(obj.getNumeroOrden());
			if (sub != null) {
				tx.begin();
					em.persist(sub);
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
	public SubcontratadosConProyecto buscarUno(Integer clave) {
		return em.find(SubcontratadosConProyecto.class, clave);
	}

	@Override
	public List<SubcontratadosConProyecto> buscarTodos() {
		jpql = "select sp from SubcontratadosConProyecto sp";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<SubcontratadosConProyecto> empleadosByProyecto(String codigoProyecto) {
		
		jpql = "select sp from SubcontratadosConProyecto sp where sp.proyecto.idProyecto = ?1";
		query = em.createQuery(jpql);
		query.setParameter(1,codigoProyecto);
		List<SubcontratadosConProyecto> empleadosList = query.getResultList();
		return empleadosList;
	}

	@Override
	public String asignarEmpleadosAProyecto(List<SubcontratadosConProyecto> subcontratados) {
		String posible="";
		tx.begin();
		for (SubcontratadosConProyecto subcontratado : subcontratados) {
            	try {
        			
        				em.persist(subcontratado);
        			
        			posible+=" correcto";
        		}catch(Exception e) {
        			e.printStackTrace();
        			posible+=" incorrecto";
        		}
			}tx.commit();
		return posible;
	}

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
jpql= "select sp from SubcontratadosConProyecto sp where sp.proyecto.idProyecto = :idProyecto";
		
		query = em.createQuery(jpql);
		query.setParameter("idProyecto",codigoProyecto);
		@SuppressWarnings("unchecked")
		List<SubcontratadosConProyecto> lista = query.getResultList();
		return lista.stream().mapToInt(p -> p.getHorasAsignadas()).sum();
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
jpql= "select sp from ProyectoConEmpleado sp where sp.proyecto.idProyecto = :idProyecto";
		
		query = em.createQuery(jpql);
		query.setParameter("idProyecto",codigoProyecto);
		@SuppressWarnings("unchecked")

		List<SubcontratadosConProyecto> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.costeHorasAsignadas()).sum();
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		jpql= "select sp from ProyectoConEmpleado sp where sp.proyecto.idProyecto = :idProyecto";
		query = em.createQuery(jpql);
		query.setParameter("idProyecto",codigoProyecto);
		@SuppressWarnings("unchecked")

		List<SubcontratadosConProyecto> lista = query.getResultList();
		double costeActual = lista.stream().mapToDouble(p -> p.costeHorasAsignadas()).sum();
		return lista.stream().mapToDouble(p -> p.getIdProyecto().getVentaPrevisto()-costeActual).sum();
	}

}
