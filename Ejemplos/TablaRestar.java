import java.util.Scanner;

public class TablaRestar {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.print("Ingrese el numero de la tabla de restar? ");
            int numero = teclado.nextInt(); 
            int i = 0; 

            System.out.println("Tabla de restar del " + numero + ":");
            while (i <= 12) {
                int resultado = numero - i;
                System.out.println(numero + " - " + i + " = " + resultado);
                i++; 
            }
        }
    }
}
