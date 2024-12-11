import java.util.Scanner;
public class EJEMPLO10 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            {
                
                double precio,ganancia,venta;
                
                System.out.println("Escriba el precio del articulo: ");
                
                precio=teclado.nextDouble();

                ganancia= precio*.30;
                venta = precio + ganancia;

                System.out.println("Usted debe vender el articulo a $"+venta +"para tener una ganancia de 30%");
      }
        }
    }
}
