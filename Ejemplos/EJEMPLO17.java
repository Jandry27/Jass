import java.util.Scanner;

public class EJEMPLO17 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){

        System.out.print("Ingresa la edad: ");
        int edad = teclado.nextInt();

        if (edad < 0) {
            System.out.println("La edad no puede ser negativa. Por favor, ingresa una edad válida.");

        } else if (edad >= 18) {
            System.out.println("Es mayor de edad.");

        } else {
            System.out.println("Es menor de edad.");
        }
        }
    }
}
