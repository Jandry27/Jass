import java.util.Scanner;

public class TablaDividir {
    public static void main(String[] args) {
        int n1;
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("¿Qué número de tabla quiere?: ");
            n1 = teclado.nextInt();
        }
        for (int i = 1; i <= 12; i++) {
            // Asegurarse de que no se divida por cero
            if (n1 != 0) {
                System.out.println(i + " ÷ " + n1 + " = " + (double)i / n1);
            } else {
                System.out.println("No se puede dividir entre cero.");
                break;
            }
        }
    }
}
