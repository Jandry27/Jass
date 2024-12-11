import java.util.Scanner;

public class EJEMPLO11 {
    
    public static void main(String[] args) {
       
        try (Scanner teclado = new Scanner(System.in)){
            
            double inversion1, inversion2, inversion3;
            double por1, por2, por3;
            double total;
        
            System.out.println("Introduzca la primera inversion: ");
            inversion1 = teclado.nextDouble();
            System.out.println("Introduzca la segunda inversion: ");
            inversion2 = teclado.nextDouble();
            System.out.println("Introduzca la tercera inversion; ");
            inversion3 = teclado.nextDouble();

            total = inversion1 + inversion2 + inversion3;

            por1 = (inversion1 / total) * 100;
            por2 = (inversion2 / total) * 100;
            por3 = (inversion3 / total) * 100;

            System.out.println("El porcentaje de la primera persona es; "+por1+"%");
            System.out.println("El porcentaje de la segunda persona es; "+por2+"%");
            System.out.println("El porcentaje de la tercera persona es; "+por3+"%");
        }
    }
}