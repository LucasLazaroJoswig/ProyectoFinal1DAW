package principales;

import java.util.Scanner;

public class GestionClientes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
    }

    private static void altaCliente() {
        // Implementar la funcionalidad para dar de alta un cliente
        
    }

    private static void buscarCliente() {
        // Implementar la funcionalidad para buscar un cliente
        
    }

    private static void mostrarTodos() {
        // Implementar la funcionalidad para mostrar todos los clientes
        
    }

    private static void eliminarCliente() {
        // Implementar la funcionalidad para eliminar un cliente
        ;
    }
}
