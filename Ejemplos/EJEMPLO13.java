import java.util.Scanner;

public class EJEMPLO13 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){
            
            System.out.println("Ingrese el angulo entre 0 y 180°: ");
            int angulo = teclado.nextInt();

            if (angulo > 0 && angulo < 180) {
                if (angulo < 90) {
                    System.out.println("Es un ángulo agudo.");

                } else if (angulo > 90) {
                    System.out.println("Es un ángulo obtuso.");

                } else {
                    System.out.println("Es un ángulo recto.");
                    
                }
            } else {
                System.out.println("El ángulo ingresado no está en el rango válido (0-180°).");
            }
        }
    }
}
