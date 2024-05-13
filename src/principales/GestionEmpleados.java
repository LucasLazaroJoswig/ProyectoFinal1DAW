package principales;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.dao.DepartamentoDao;
import modelo.dao.DepartamentoDaoImplMy8Jpa;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8Jpa;
import modelo.entidades.Cliente;
import modelo.entidades.Departamento;
import modelo.entidades.Empleado;
import modelo.entidades.Perfil;

public class GestionEmpleados {
	private static EmpleadoDao edao;
	private static PerfilDao perfilDao;
	private static DepartamentoDao ddao;
	private static Scanner scanner;
	static {
		edao=new EmpleadoDaoImplMy8Jpa();
		perfilDao = new PerfilDaoImplMy8Jpa();
		ddao=new DepartamentoDaoImplMy8Jpa();
		scanner = new Scanner(System.in);
	}
    public static void main(String[] args) throws ParseException {
      

        int opcion;
        int opcion2;

        do {
            System.out.println("\nMENÚ");
            System.out.println("1. Alta del Empleado");
            System.out.println("2. Buscar un Empleado");
            System.out.println("3. Mostrar Todos");
            System.out.println("4. Eliminar un Empleado");
            System.out.println("Salir del programa");
            System.out.print("Seleccione una opción: ");
            System.out.println("\n");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    altaEmpleado();
                    break;
                case 2:
                    buscarEmpleado();
                    break;
                case 3:
                    mostrarTodos();
                    break;
                case 4:
                    eliminarEmpleado();
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

    private static void altaEmpleado() throws ParseException {
    	 
    	String nombre;
    	String apellidos;
    	String genero;
    	String email;
    	String password;
    	BigDecimal salario;
    	Date fecha_ingreso=new Date();
    	String fecha_nacimiento;
    	Perfil perfil=new Perfil();
    	Departamento departamento=new Departamento();
    	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
    	
          scanner.nextLine();
          

        System.out.println("Digame el nombre");
        nombre = scanner.nextLine();
        
        System.out.println("Digame los apellidos");
        apellidos = scanner.nextLine();
        
        System.out.println("Digame el genero");
        genero = scanner.nextLine();
        
        System.out.println("Digame el email");
        email = scanner.nextLine();
        
        System.out.println("Digame la contraseña");
        password = scanner.nextLine();
        
        System.out.println("Digame el salario");
        salario=scanner.nextBigDecimal();
        scanner.nextLine();
        
        System.out.println("Digame su fecha de nacimiento (yyyy-MM-dd)");
        fecha_nacimiento=scanner.nextLine();
        Date fecha = formato.parse(fecha_nacimiento);
        
        System.out.println("Elija el perfil del empleado");
        int opcion;
		
            System.out.println("\nMENÚ");
            System.out.println("1. Control de Gestion");
            System.out.println("2. Jefe de Proyecto");
            System.out.println("3. Operativo");
            System.out.println("4. Recusos Humanos");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    perfil = perfilDao.buscarUno(1);
                    break;
                case 2:
                	perfil = perfilDao.buscarUno(2);
                    break;
                case 3:
                	perfil = perfilDao.buscarUno(3);
                    break;
                case 4:
                	perfil = perfilDao.buscarUno(4);
                    break;
                default:
                	System.out.println("Porfavor elija una opción entre el 1 y el 5");
            }
        

        	
        System.out.println("Elija el departamento del empleado");
        int opcion1;
		
            System.out.println("\nMENÚ");
            System.out.println("1. Gestion Personas");
            System.out.println("2. Software");
            System.out.println("3. Hardware");
            System.out.println("4. Financiero");

            System.out.print("Seleccione una opción: ");
            opcion1 = scanner.nextInt();

            switch (opcion1) {
                case 1:
                    departamento = ddao.buscarUno(10);
                    break;
                case 2:
                	departamento = ddao.buscarUno(20);
                    break;
                case 3:
                	departamento = ddao.buscarUno(30);
                    break;
                case 4:
                	departamento = ddao.buscarUno(40);
                    break;
                default:
                	System.out.println("Porfavor elija una opción entre el 1 y el 5");

            }

        
        Empleado empleado = new Empleado(0, apellidos, email, fecha_ingreso, fecha, genero, nombre, password, salario, departamento, perfil, null);
        System.out.println(edao.alta(empleado));
    
    }

    private static void buscarEmpleado() {
    	 
        System.out.println("Dame el ID del empleado que quieres buscar");
        int id;
        
        scanner.nextLine();
        
        id = scanner.nextInt();
        Empleado empleado = edao.buscarUno(id);
        System.out.println(empleado);
        
    }

    private static void mostrarTodos() {

       edao.buscarTodos().forEach(System.out::println);
        
    }

    private static void eliminarEmpleado() {
        
        System.out.println("Introduzca el ID del empleado que desees eliminar");
        int id;
        id = scanner.nextInt();
        System.out.println(edao.eliminar(id));
        
    }
}
