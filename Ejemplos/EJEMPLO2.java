import java.util.Scanner;
public class EJEMPLO2 {
    public static void main(String[] args) {

        try (Scanner teclado = new Scanner (System.in)){

            
            System.out.println("Ingrese la velocidad constante: ");
            double velocidad = teclado.nextDouble();

            System.out.println("Ingrese el tiempo: ");
            double tiempo = teclado.nextDouble();

            double distancia = velocidad * tiempo;

            System.out.println("La distancia recorrida es: " + distancia );


        }
    }
    
}
