import java.util.Scanner; 
public class EJEMPLO4 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner (System.in)){
            int ganados;
            int perdidos;
            int empatados;
            int puntos_totales;

            System.out.println("Partidos ganados: ");
            ganados = teclado.nextInt();

            System.out.println("Partidos perdidos: ");
            perdidos = teclado.nextInt();

            System.out.println("Partidos empatados: ");
            empatados = teclado.nextInt();

            puntos_totales=(ganados*3)+(empatados*1)+(perdidos*0);

            System.out.println("El puntaje total del equipo es: " + puntos_totales );

            
        }

    }
}
