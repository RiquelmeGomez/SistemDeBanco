import java.util.PriorityQueue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Cliente> cola = new PriorityQueue<>(); // Cola de prioridad para clientes
        int opcion;

        // Bucle principal del menú
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
                    // Agregar un nuevo cliente a la cola
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("¿Es cliente prioritario? (1: Sí, 2: No): ");
                    boolean esPrioritario = scanner.nextInt() == 1;
                    cola.add(new Cliente(nombre, esPrioritario)); // Añadir cliente a la cola
                    System.out.println("Cliente agregado a la cola.");
                    break;
                case 2:
                    // Atender al cliente con mayor prioridad en la cola
                    if (cola.isEmpty()) {
                        System.out.println("No hay clientes en espera.");
                    } else {
                        System.out.println("Atendiendo a: \n" + cola.poll()); // Remueve y muestra al cliente atendido
                    }
                    break;
                case 3:
                    // Mostrar la lista de clientes en espera
                    if (cola.isEmpty()) {
                        System.out.println("La cola está vacía.");
                    } else {
                        System.out.println("Clientes en espera: " + cola);
                    }
                    break;
                case 4:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        System.out.println("Gracias por utilizar el Sistema");
        System.out.println("Creado por Riquelme Gómez");

        scanner.close(); // Cerrar el scanner al terminar
    }
}
