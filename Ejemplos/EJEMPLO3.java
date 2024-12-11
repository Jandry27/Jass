import java.util.Scanner;

public class EJEMPLO3 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner (System.in)){
            
            System.out.println("NOTA 1 : ");
            double nota1 = teclado.nextDouble();

            System.out.println("NOTA 2: ");
            double nota2 = teclado.nextDouble();

            System.out.println("NOTA 3: ");
            double nota3 = teclado.nextDouble();

            double promedio=(nota1+nota2+nota3)/3;

            System.out.print("El promedio es : "+ promedio);

        }
    }
}
