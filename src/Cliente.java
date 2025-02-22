public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private boolean esPrioritario;

    // Constructor para inicializar el cliente con nombre y prioridad
    public Cliente(String nombre, boolean esPrioritario) {
        this.nombre = nombre;
        this.esPrioritario = esPrioritario;
    }

    // Método para comparar clientes por prioridad (los prioritarios van primero)
    @Override
    public int compareTo(Cliente otro) {
        return Boolean.compare(otro.esPrioritario, this.esPrioritario);
    }

    // Método para obtener el nombre del cliente
    public String getNombre() {
        return nombre;
    }

    // Representación en cadena del cliente
    @Override
    public String toString() {
        return nombre + (esPrioritario ? " (Prioritario)" : "");
    }
}
