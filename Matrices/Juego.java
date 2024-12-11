package Matrices;
import javax.swing.JOptionPane;
import java.util.Random;

public class Juego {
    public static void main(String[] args) {
        
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 3;
        boolean adivinado = false;

        
        JOptionPane.showMessageDialog(null, "Adivina el numero del 1 al 100"+"   (Tienes 3 intentos)");

        
        for (int i = 0; i < intentos; i++) {
            
            String entrada = JOptionPane.showInputDialog("Intento " + (i + 1) );
            int numeroUsuario;

            
            try {
                numeroUsuario = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
                i--; 
                continue;
            }

           
            if (numeroUsuario < 1 || numeroUsuario > 100) {
                JOptionPane.showMessageDialog(null, "El número debe estar entre 1 y 100. Intenta de nuevo.");
                i--; 
                continue;
            }

            if (numeroUsuario == numeroSecreto) {
                adivinado = true;
                break;
            } else if (numeroUsuario < numeroSecreto) {
                
                int pista = numeroSecreto + 5;
                JOptionPane.showMessageDialog(null, "El número es mayor. El número secreto es menor que " + pista + ".");
            } else {
                
                int pista = numeroSecreto - 5;
                JOptionPane.showMessageDialog(null, "El número es menor." + " El número secreto es mayor que " + pista + ".");
            }
        }

        
        if (adivinado) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! Adivinaste el número: " + numeroSecreto);
        } else {
            JOptionPane.showMessageDialog(null, "Lo siento, no adivinaste el número. Era: " + numeroSecreto);
        }
    }
}