import javax.swing.JOptionPane;
import java.util.Scanner;

public class Par_Impar {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int numero = leerNumero(teclado);
        boolean esPar = esNumeroPar(numero);

        mostrarResultado(esPar);

        teclado.close();
    }

    public static int leerNumero(Scanner teclado) {
        String input = JOptionPane.showInputDialog("Ingrese un número: ");
        return Integer.parseInt(input); 
    }

    public static boolean esNumeroPar(int numero) {
        return numero % 2 == 0; 
    }

    public static void mostrarResultado(boolean esPar) {
        if (esPar) {
            JOptionPane.showMessageDialog(null, "El número es par.");
        } else {
            JOptionPane.showMessageDialog(null, "El número es impar.");
        }
    }
}
