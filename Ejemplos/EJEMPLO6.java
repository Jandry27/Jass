import java.util.Scanner;
public class EJEMPLO6 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner (System.in)){
            int valor1;
            int valor2;
            int suma;
            int resta;
            int multi;
            double divi;


            System.out.println("Primer numero: ");
            valor1 = teclado.nextInt();

            System.out.println("Segundo numero: ");
            valor2 = teclado.nextInt();

            suma= valor1+valor2;
            resta=valor1-valor2;
            multi=valor1*valor2;
            divi=valor1/valor2;

            System.out.println("LA SUMA ES: " + suma);

            System.out.println("LA RESTA ES: " + resta);

            System.out.println("LA MULTIPLICACION ES: " + multi);
            
            System.out.println("LA DIVISION ES: " + divi);
        }
    }
}
