package principales;


import java.util.List;
import java.util.Scanner;


import modelo.dao.EmpleadoEnProyectoDao;
import modelo.dao.FacturaDao;
import modelo.dao.FacturaDaoImplMy8Jpa;
import modelo.dao.ProyectoConEmpleadoDaoImplMy8Jpa;
import modelo.dao.ProyectoConProductoDaoImplMy8Jpa;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entidades.Empleado;
import modelo.entidades.Factura;
import modelo.entidades.ProyectoConEmpleado;
import modelo.entidades.ProyectoConProducto;


public class ImprimirFactura {
private static FacturaDao fdao;
private static ProyectoDao pdao;
private static EmpleadoEnProyectoDao epdao;
private static ProyectoConProductoDaoImplMy8Jpa ppdao;
private static Scanner scanner;
private static double totalPrecio = 0;
	
	static {
    	
		pdao = new ProyectoDaoImplMy8Jpa();
		epdao = new ProyectoConEmpleadoDaoImplMy8Jpa();
		fdao = new FacturaDaoImplMy8Jpa();
		ppdao = new ProyectoConProductoDaoImplMy8Jpa();
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
		List<ProyectoConEmpleado> empleados = epdao.empleadosByProyecto(facturaImp.getProyecto().getIdProyecto());
		//System.out.println(empleados)
		System.out.println("...........................................");
        for (ProyectoConEmpleado emp : empleados) {
        	System.out.println("Apellidos, nombre : "+emp.getEmpleado().getApellidos()+", "+emp.getEmpleado().getNombre()+
    				"  	Horas(total): "+emp.getHorasAsignadas()+" Importe Repercutido : "+ emp.costeHorasAsignadas());

        	totalPrecio+=emp.costeHorasAsignadas();
        }    
        System.out.println("Total horas : "+epdao.horasAsignadasAProyecto("FOR2020001")+" Total Precio : "+totalPrecio);
		System.out.println("\n");

		System.out.println("LISTA PRODUCTOS");
		List<ProyectoConProducto> productos = ppdao.productosByProyecto(facturaImp.getProyecto().getIdProyecto());
		for (ProyectoConProducto prod : productos) {
        	System.out.println("Descripcion : "+prod.getProducto().getDescripcion()+". Cantidad : "+prod.getCantidad()+
    				" Precio por uno: "+prod.getProducto().getPrecio());
        }
		System.out.println("...........................................");
		System.out.println("Total Productos : "+ppdao.TotalProductosByProyecto(facturaImp.getProyecto().getIdProyecto()));
		System.out.println("\n");
		System.out.println("DETALLE DEL IMPORTE:");
		System.out.println("Importe venta : "+facturaImp.getProyecto().getVentaPrevisto());
		System.out.println("Total Facturado : ");
		
	}
}
