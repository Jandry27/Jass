import java.util.Scanner;

public class EJEMPLO18 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){

        System.out.print("Ingresa la edad: ");
        int edad = teclado.nextInt();

        System.out.print("Ingresa la estatura en metros (por ejemplo, 1,75): ");
        double estatura = teclado.nextDouble();

        if (edad > 14 && estatura >= 1.65) {
            System.out.println("La persona es APTA para jugar en la selección de mayores en básquet.");

        } else {

            System.out.println("La persona NO es APTA para jugar en la selección de mayores en básquet.");
        }
        }
    }
}
