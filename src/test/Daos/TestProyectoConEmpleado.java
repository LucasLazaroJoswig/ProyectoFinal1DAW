package test.Daos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;

import modelo.entidades.ProyectoConEmpleado;

public class TestProyectoConEmpleado {

	private static EmpleadoEnProyectoDao pedao;
	private static EmpleadoDao edao;
	private static ProyectoDao pdao;

	static {
		pedao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		edao = new EmpleadoDaoImplMy8Jpa();
		pdao = new ProyectoDaoImplMy8Jpa();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// altaProyEmpl();
		// buscarUno();
		//eliminar();
		//buscarTodos();
		//horasAsignadasAProyecto();
		
		
		//empleadosByProyecto();
		asignarEmpleadosAProyecto();
		
		//costeActualDeProyecto();
		//margenActualProyecto();
	}

	public static void altaProyEmpl() {

		System.out.println(pedao.alta(new ProyectoConEmpleado(0, new Date(2021 - 11 - 31), 50, edao.buscarUno(100),
				pdao.buscarUno("FOR2020001"))));
	}

	public static void buscarUno() {

		System.out.println(pedao.buscarUno(1));

	}

	public static void eliminar() {

		System.out.println(pedao.eliminar(5));

	}
	public static void buscarTodos() {

		pedao.buscarTodos().forEach(System.out::println);

	}
	public static void empleadosByProyecto() {

		pedao.empleadosByProyecto("FOR2020001").forEach(System.out::println);

	}
	public static void asignarEmpleadosAProyecto() {
		List<ProyectoConEmpleado> empleados = new ArrayList<ProyectoConEmpleado>();
		empleados.add(new ProyectoConEmpleado(0, new Date(2021 - 11 - 31), 50, edao.buscarUno(100),pdao.buscarUno("FOR2020001")));
		empleados.add(new ProyectoConEmpleado(0, new Date(2021 - 11 - 23), 60, edao.buscarUno(114),pdao.buscarUno("FOR2020001")));
		
		System.out.println(pedao.asignarEmpleadosAProyecto(empleados));
	}
	
	
	public static void horasAsignadasAProyecto() {

		System.out.println( pedao.horasAsignadasAProyecto("FOR2020001"));;
	}
	public static void costeActualDeProyecto() {

		System.out.println( pedao.costeActualDeProyecto("FOR2020001"));;
	}
	public static void margenActualProyecto() {

		System.out.println( pedao.margenActualProyecto("FOR2020001"));;
	}
	
	
}
