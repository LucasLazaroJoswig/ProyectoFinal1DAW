package test.Entidades;

import java.math.BigDecimal;
import java.util.Date;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;
import modelo.entidades.Proyecto;

public class testProyecto {
	private static ProyectoDao pdao;
	static {
		pdao=new ProyectoDaoImplMy8Jpa();
	}
public static void main(String[] args) {
	Proyecto proy1 = pdao.buscarUno("FOR2020001");
	
	System.out.println(proy1.MargenPrevisto());
	System.out.println("\n");
	System.out.println(proy1.MargenReal());
	System.out.println("\n");
	System.out.println(proy1.DiferenciaGastos());
	System.out.println("\n");
	System.out.println(proy1.diferenciaFinPrevistoReal());
	System.out.println("\n");
}
}
