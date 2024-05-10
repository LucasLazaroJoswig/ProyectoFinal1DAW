package test.Entidades;

import java.math.BigDecimal;
import java.util.Date;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class TestEmpleados {
	private static EmpleadoDao edao;
	static {
		edao=new EmpleadoDaoImplMy8Jpa();
	}
	public static void main(String[] args) {
		Empleado emp1 =edao.buscarUno(100);
		
		System.out.println(emp1.salarioBruto());
		System.out.println("\n");
		System.out.println(emp1.literalSexo());
		System.out.println("\n");
		System.out.println(emp1.salarioMensual(12));
		System.out.println("\n");
		System.out.println(emp1.obtenerEmail());
		System.out.println("\n");
		System.out.println(emp1.nombreCompleto());
	}
	
	
	
}
