import javax.swing.JOptionPane; // Importación correcta
import java.util.ArrayList;
import java.util.Random;

public class prueba {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> nombresEmpleados = new ArrayList<>();
        ArrayList<Integer> sueldos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar un nuevo empleado?", "Gestión de Empleados", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                String nombre;
                boolean nombreValido = false;

                while (!nombreValido) {
                    nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del empleado (sin números):", "Nuevo Empleado", JOptionPane.PLAIN_MESSAGE);

                    if (nombre == null || nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        JOptionPane.showMessageDialog(null, "El nombre no puede contener números o caracteres especiales. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        nombreValido = true;

                        int sueldo = random.nextInt(151) + 350;
                        nombresEmpleados.add(nombre);
                        sueldos.add(sueldo);

                        JOptionPane.showMessageDialog(null, "Empleado " + nombre + " agregado con sueldo: $" + sueldo, "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else {
                continuar = false;
            }
        }

        if (nombresEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se registraron empleados.", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder listaEmpleados = new StringBuilder("--- Lista de Empleados y Sueldos ---\n");
            for (int i = 0; i < nombresEmpleados.size(); i++) {
                listaEmpleados.append((i + 1))
                        .append(". ")
                        .append(nombresEmpleados.get(i))
                        .append(" - Sueldo: $")
                        .append(sueldos.get(i))
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, listaEmpleados.toString(), "Empleados Registrados", JOptionPane.INFORMATION_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Programa finalizado.", "Fin", JOptionPane.INFORMATION_MESSAGE);
    }
}
