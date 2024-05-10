package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entidades.Cliente;

public class GestionEmpleados {
	private static ClienteDao cdao;
	private static Scanner scanner;
	static {
		cdao=new ClienteDaoImplMy8Jpa();
		scanner = new Scanner(System.in);
	}
    public static void main(String[] args) {
      

        int opcion;

        do {
            System.out.println("\nMENÚ");
            System.out.println("1. Alta del Cliente");
            System.out.println("2. Buscar un Cliente");
            System.out.println("3. Mostrar Todos");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    mostrarTodos();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                	System.out.println("Porfavor elija una opción entre el 1 y el 5");
            }
        } while (opcion != 5);

        System.out.println("Programa terminado");
        scanner.close();
    }

    private static void altaCliente() {
    	 
    	String cif;
    	String nombre;
    	String apellidos;
    	String domicilio;
    	double fact_anual;
    	int num_empleados;
    	
          scanner.nextLine();
          
        System.out.println("Digame el CIF");
        cif = scanner.nextLine();

        System.out.println("Digame el nombre");
        nombre = scanner.nextLine();
        
        System.out.println("Digame los apellidos");
        apellidos = scanner.nextLine();
        
        System.out.println("Digame el domicilio");
        domicilio = scanner.nextLine();
        
        System.out.println("Digame la facturacion anual");
        fact_anual = scanner.nextDouble();
        
        System.out.println("Digame el numero de empleados");
        num_empleados = scanner.nextInt();
        
        Cliente c = new Cliente(cif, apellidos, domicilio, fact_anual, nombre, num_empleados);
        System.out.println(cdao.alta(c));
        
    }

    private static void buscarCliente() {
    	 
        System.out.println("Dame el CIF del cliente que quieres buscar");
        String cif;
        
        scanner.nextLine();
        
        cif = scanner.nextLine();
        Cliente cl1 = cdao.buscarUno(cif);
        System.out.println(cl1);
        
    }

    private static void mostrarTodos() {
    	scanner.nextLine();
       System.out.println(cdao.buscarTodos());
        
    }

    private static void eliminarCliente() {
        
        System.out.println("Introduzca el CIF del cliente que desees eliminar");
        String cif;
        scanner.nextLine();
        cif = scanner.nextLine();
        System.out.println(cdao.eliminar(cif));
        
    }
}
