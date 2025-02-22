import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Cliente> colaPrioritarios = new LinkedList<>(); // Cola de clientes prioritarios
        Queue<Cliente> colaNormales = new LinkedList<>();     // Cola de clientes normales
        int opcion;

        do {
            System.out.println("\n1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Mostrar cola de espera");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    // Agregar un nuevo cliente a la cola correspondiente
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("¿Es cliente prioritario? (1: Sí, 2: No): ");
                    boolean esPrioritario = scanner.nextInt() == 1;

                    Cliente cliente = new Cliente(nombre, esPrioritario);
                    if (esPrioritario) {
                        colaPrioritarios.add(cliente);
                    } else {
                        colaNormales.add(cliente);
                    }
                    System.out.println("Cliente agregado a la cola.");
                    break;

                case 2:
                    // Atender al cliente en la cola
                    if (!colaPrioritarios.isEmpty()) {
                        System.out.println("Atendiendo a: " + colaPrioritarios.poll());
                    } else if (!colaNormales.isEmpty()) {
                        System.out.println("Atendiendo a: " + colaNormales.poll());
                    } else {
                        System.out.println("No hay clientes en espera.");
                    }
                    break;

                case 3:
                    // Mostrar la lista de clientes en espera
                    System.out.println("\nClientes en espera:");
                    if (colaPrioritarios.isEmpty() && colaNormales.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Prioritarios: " + colaPrioritarios);
                        System.out.println("Normales: " + colaNormales);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        System.out.println("Gracias por utilizar el Sistema");
        System.out.println("Creado por Riquelme Gómez");

        scanner.close();
    }
}


