import java.util.Scanner;

public class EJEMPLO15 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){

        System.out.print("Ingresa el año: ");
        int año = teclado.nextInt();

        if (año % 400 == 0 || (año % 4 == 0 && año % 100 != 0)) {
            System.out.println("El año " + año + " es bisiesto.");
        } else {
            System.out.println("El año " + año + " NO es bisiesto.");
        }

        }
    }
}
