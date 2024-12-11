import javax.swing.JOptionPane;
import java.util.Random;

public class juego_adivinar {

    public static void main(String[] args) {
        // Explicación del juego
        JOptionPane.showMessageDialog(null, 
                "¡Bienvenido a 'Adivina el número'!\n" +
                "El objetivo del juego es adivinar un número secreto.\n" +
                "Después de cada intento, recibirás una retroalimentación para ayudarte.\n" +
                "¡Vamos a empezar!");

        Random random = new Random();
        boolean jugarNuevamente = true;

        while (jugarNuevamente) {
            // Generar un número secreto aleatorio entre 1 y 100
            int numeroSecreto = random.nextInt(100) + 1;
            int intentos = 0;
            boolean adivinado = false;

            // Bucle principal del juego
            while (!adivinado) {
                String entrada = JOptionPane.showInputDialog(null, 
                        "Ingresa tu suposición (entre 1 y 100):");

                // Validación de entrada
                if (entrada == null || entrada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
                    continue;
                }

                int suposicion;
                try {
                    suposicion = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
                    continue;
                }

                // Validación de rango
                if (suposicion < 1 || suposicion > 100) {
                    JOptionPane.showMessageDialog(null, 
                            "El número debe estar en el rango de 1 a 100.");
                    continue;
                }

                intentos++;

                // Comparación y retroalimentación
                if (suposicion < numeroSecreto) {
                    JOptionPane.showMessageDialog(null, 
                            "Demasiado bajo. ¡Intenta nuevamente!");
                } else if (suposicion > numeroSecreto) {
                    JOptionPane.showMessageDialog(null, 
                            "Demasiado alto. ¡Intenta nuevamente!");
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "¡Felicidades! ¡Adivinaste el número en " + intentos + " intentos!");
                    adivinado = true;
                }
            }

            // Preguntar si el jugador desea jugar nuevamente
            int respuesta = JOptionPane.showConfirmDialog(null, 
                    "¿Deseas jugar nuevamente?", 
                    "Jugar nuevamente", 
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                jugarNuevamente = true;
            } else {
                JOptionPane.showMessageDialog(null, "Gracias por jugar. ¡Hasta la próxima!");
                jugarNuevamente = false;
            }
        }
    }
}
