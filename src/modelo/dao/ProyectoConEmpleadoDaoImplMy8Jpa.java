package modelo.dao;

import java.util.List;

import modelo.entidades.Cliente;
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.ProyectoConEmpleado;

public class ProyectoConEmpleadoDaoImplMy8Jpa extends AbstractDaoImplmy8Jpa implements EmpleadoEnProyectoDao{

	@Override
	public boolean alta(ProyectoConEmpleado obj) {
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
			ProyectoConEmpleado empl = buscarUno(clave);
			if (empl != null) {
				tx.begin();
					em.remove(empl);
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
	public boolean modificar(ProyectoConEmpleado obj) {
		try {
			ProyectoConEmpleado empl = buscarUno(obj.getNumeroOrden());
			if (empl != null) {
				tx.begin();
					em.persist(empl);
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
	public ProyectoConEmpleado buscarUno(Integer clave) {
		return em.find(ProyectoConEmpleado.class, clave);
	}

	@Override
	public List<ProyectoConEmpleado> buscarTodos() {
		jpql = "select ep from ProyectoConEmpleado ep";
		query = em.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public List<ProyectoConEmpleado> empleadosByProyecto(String codigoProyecto) {
//jpql= "SELECT * FROM empleados e join proyecto_con_empleados ep on e.id_empl = ep.id_empl join proyectos p on ep.id_proyecto = p."+codigoProyecto+";";
		//jpql = "select ep.empleado from ProyectoConEmpleado ep where ep.proyecto.idProyecto = ?1";
		jpql = "select ep from ProyectoConEmpleado ep where ep.proyecto.idProyecto = ?1";
		query = em.createQuery(jpql);
	//	query.setParameter(1, regionId);
	 	query.setParameter(1,codigoProyecto);
		//return query.getResultList();
	 	List<ProyectoConEmpleado> empleadosList = query.getResultList();
	 	return empleadosList;
	 	/*for (ProyectoConEmpleado empleados:empleadosList) {
	 	      return empleados.
	 	      
	 	    }*/
				
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleado> empleados) {
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

	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		jpql= "select ep from ProyectoConEmpleado ep";
		
		query = em.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<ProyectoConEmpleado> lista = query.getResultList();
		return lista.stream().mapToInt(p -> p.getHorasAsignadas()).sum();
	}

	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
jpql= "select ep from ProyectoConEmpleado ep where ep.proyecto.idProyecto = :idProyecto";
		
		query = em.createQuery(jpql);
		query.setParameter("idProyecto",codigoProyecto);
		@SuppressWarnings("unchecked")

		List<ProyectoConEmpleado> lista = query.getResultList();
		return lista.stream().mapToDouble(p -> p.costeHorasAsignadas()*p.costeHorasAsignadas()).sum();
	}

	@Override
	public double margenActualProyecto(String codigoProyecto) {
		ProyectoConEmpleado proyecto = em.find(ProyectoConEmpleado.class, codigoProyecto);
		return proyecto.getProyecto().getVentaPrevisto()-costeActualDeProyecto(codigoProyecto);
	}

}
