import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class prueba {
    public static void main(String[] args) {
        ArrayList<String> empleados = new ArrayList<>();
        ArrayList<Integer> sueldos = new ArrayList<>();
        Random random = new Random();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null, 
                "¿Desea crear un nuevo empleado? (SI / NO)", 
                "Gestión de Empleados", 
                JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equalsIgnoreCase("NO")) {
                break;
            }

            if (opcion.equalsIgnoreCase("SI")) {
                String nombreEmpleado = JOptionPane.showInputDialog(null, 
                    "Ingrese el nombre del empleado:", 
                    "Nuevo Empleado", 
                    JOptionPane.QUESTION_MESSAGE);

                if (nombreEmpleado != null && !nombreEmpleado.isEmpty()) {
                    
                    if (nombreEmpleado.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, 
                            "El nombre del empleado no puede contener números.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        int sueldo = 350 + random.nextInt(151); 
                        empleados.add(nombreEmpleado);
                        sueldos.add(sueldo);
                        JOptionPane.showMessageDialog(null, 
                            "Empleado agregado:\nNombre: " + nombreEmpleado + "\nSueldo: $" + sueldo, 
                            "Empleado Creado", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "El nombre del empleado no puede estar vacío.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Opción no válida. Por favor, escriba 'SI' o 'NO'.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        if (!empleados.isEmpty()) {
            StringBuilder resultado = new StringBuilder("Lista de empleados:\n");
            for (int i = 0; i < empleados.size(); i++) {
                resultado.append(i + 1)
                        .append(". Nombre: ")
                        .append(empleados.get(i))
                        .append(" - Sueldo: $")
                        .append(sueldos.get(i))
                        .append("\n");
            }
            JOptionPane.showMessageDialog(null, 
                resultado.toString(), 
                "Consulta de Empleados", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se ingresaron empleados.", 
                "Consulta de Empleados", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
