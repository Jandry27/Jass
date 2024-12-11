import java.util.Scanner; 
public class EJEMPLO5 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)){

            int horas_trabajadas;
            int sueldo_semanal;
            int valor_hora;

            System.out.println("Ingrese las horas trabajadas: ");
            horas_trabajadas = teclado.nextInt();
            
            System.out.println("Ingrese el valor de la hora por trabajo: ");
            valor_hora = teclado.nextInt();

            sueldo_semanal=(horas_trabajadas*valor_hora);

            System.out.println("El salario semanal de la persona es: "+sueldo_semanal );





        }
    }
    
}
