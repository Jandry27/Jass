import java.util.Scanner;
public class EJEMPLO1 {

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            int valor1; 
            int valor2;
            int valor3;
            int resultado;

            System.out.println("Primer numero: ");
            valor1 = teclado.nextInt();
            System.out.println("Segundo numero: ");
            valor2 = teclado.nextInt();

            System.out.println("Tercer numero: ");
            valor3 = teclado.nextInt();

            resultado=valor1+valor2+valor3;

            System.out.print("LA SUMA ES: "+resultado);

        }

    }

}