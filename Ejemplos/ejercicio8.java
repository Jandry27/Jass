import java.util.Scanner;
public class ejercicio8 {
    public static void main(String[] args){
        @SuppressWarnings("resource")
        Scanner teclado = new Scanner (System.in);

        int edad;
        int pulsaciones;

        System.out.println("Ingrese su edad: ");
        edad = teclado.nextInt();

        pulsaciones = (220-edad)/10;
        System.out.println("Este es su numero de pulsaciones dependiendo su edad: " + pulsaciones);

    }
}
