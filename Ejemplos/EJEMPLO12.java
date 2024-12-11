import java.util.Scanner;

public class EJEMPLO12 {

    public static void main(String[] args) {
        
        try (Scanner teclado = new Scanner(System.in)){

            int numerador, denominador;

            System.out.println("Ingrese el primer numero: ");
            numerador = teclado.nextInt();
            System.out.println("Ingrese el segundo numero: ");
            denominador = teclado.nextInt();

            if (denominador == 0){
                System.out.println("ERROR, El denominador no puede ser 0.");
            }else{
                double resultado = (double) numerador / denominador;
                System.out.println("El resultado de la division es: "+ resultado);
            }
        }
    }    
}
