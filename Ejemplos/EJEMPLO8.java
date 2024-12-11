import java.util.Scanner;
public class EJEMPLO8 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            {
                int edad;
                double pulsaciones;

                System.out.println("Escribe tu edad: ");
                edad= teclado.nextInt();

                pulsaciones = (220-edad) / 10.0;

                System.out.println("Las pulsaciones que debes tener es: "+pulsaciones);
            }
        }
    }
}

