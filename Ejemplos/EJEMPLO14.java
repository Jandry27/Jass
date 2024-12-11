import java.util.Scanner;

public class EJEMPLO14 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.print("Ingresa el primer lado: ");
            int lado1 = teclado.nextInt();

            System.out.print("Ingresa el segundo lado: ");
            int lado2 = teclado.nextInt();

            System.out.print("Ingresa el tercer lado: ");
            int lado3 = teclado .nextInt();

            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("El triángulo es equilátero.");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("El triángulo es isósceles.");
            } else {
                System.out.println("El triángulo es escaleno.");
            }
        }

    }
}