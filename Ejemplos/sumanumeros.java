import java.util.Scanner;
public class sumanumeros {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int valor1;
            int valor2;
            int resultado;

            System.out.println("Ingrese el primer numero");
            valor1 = teclado.nextInt();
            System.out.println("Ingrese el segundo numero");
            valor2 = teclado.nextInt();

            resultado = valor1 + valor2;
            System.out.print("La suma es:"+resultado);
        }
    }
}