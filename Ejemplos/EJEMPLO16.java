import java.util.Scanner;

public class EJEMPLO16 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){

        System.out.print("Ingresa la edad: ");
        int edad = teclado.nextInt();

        if (edad >= 1 && edad <= 3) {
            System.out.println("Es un bebé.");
        } else if (edad >= 4 && edad <= 11) {
            System.out.println("Es un niño.");
        } else if (edad >= 12 && edad <= 17) {
            System.out.println("Es un adolescente.");
        } else if (edad >= 18 && edad <= 31) {
            System.out.println("Es un joven.");
        } else if (edad >= 32 && edad <= 65) {
            System.out.println("Es un adulto.");
        } else if (edad > 65) {
            System.out.println("Es un adulto mayor.");
        } else {
            System.out.println("Edad no válida.");
        }
        }
    }
}
