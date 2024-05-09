package principales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Factura;
import modelo.entidades.ProyectoConEmpleado;


public class ImprimirFactura {
private static FacturaDao fdao;
private static ProyectoDao pdao;
private static EmpleadoEnProyectoDao epdao;
private static Scanner scanner;
	
	static {
		pdao = new ProyectoDaoImplMy8Jpa();
		epdao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		fdao = new FacturaDaoImplMy8Jpa();
		scanner = new Scanner(System.in);
	}
	public static void main(String[] args) {
		//Factura fact1 = new Factura("00AA22", "Primera Factura",new Date(2023-11-23), pdao.buscarUno("FOR2020001"));
		//System.out.println(fdao.altaFactura(fact1));
		
		System.out.println("Diga el ID de la factura a imprimir");
		String idFactura;
		idFactura=scanner.nextLine();
		Factura facturaImp = fdao.buscarUno(idFactura);
		System.out.println("\nDatos de la FACTURA");
		System.out.println(facturaImp);
		System.out.println("\n");
		System.out.println("Datos del CLIENTE:");
		System.out.println("nombre : "+facturaImp.getProyecto().getCliente().getNombre()+". Dirección : "+facturaImp.getProyecto().getCliente().getDomicilio()+".");
		System.out.println("\n");
		System.out.println("Datos del PROYECTO:");
		System.out.println("Código Proyecto : "+facturaImp.getProyecto().getIdProyecto());
		System.out.println("Descripción Proyecto : "+facturaImp.getProyecto().getDescripcion());
		System.out.println("Fecha Inicio : "+facturaImp.getProyecto().getFechaInicio()+"   Fecha Fin Real : "+facturaImp.getProyecto().getFechaFinReal());
		System.out.println("\n");
		System.out.println("DETALLE DE RECURSOS EMPLEADOS:");
		System.out.println("LISTA EMPLEADOS");
		List<ProyectoConEmpleado> empleados = epdao.empleadosByProyecto(idFactura);
        for (ProyectoConEmpleado emp : empleados) {
        	System.out.println("Apellidos, nombre : "+emp.getProyecto().getEmpleado().getApellidos()+", "+emp.getProyecto().getEmpleado().getNombre()+
    				"  	Horas(total): "+emp.getHorasAsignadas()+" Importe Repercutido : "+ emp.costeHorasAsignadas());
        }     

		System.out.println("\n");
		/*System.out.println("LISTA PRODUCTOS");
		ArrayList<ProyectoConProducto> productos = new ArrayList<>;
		for (int i = 0; i < args.length; i++) {
			
		}
		System.out.println("Descripción : "+facturaImp.getProyecto().getIdProyecto());*/
		
	}
}
