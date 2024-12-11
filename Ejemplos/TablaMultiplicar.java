import java.util.Scanner;
public class TablaMultiplicar {
    public static void main(String[] args) {
        int n1;
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("¿Que numero de tabla quiere?: ");
            n1 = teclado.nextInt();
        }
        for (int i=1; i<=12; i++){
            System.out.println(i+"X"+n1+"="+i*n1);
        }
    }        
}
