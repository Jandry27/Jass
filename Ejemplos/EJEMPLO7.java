import java.util.Scanner;
public class EJEMPLO7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);{
        
        double venta1, venta2, venta3, comision, sueldo;

        System.out.println("Escribe las 3 ventas del mes:");
        venta1 = teclado.nextDouble();
        venta2 = teclado.nextDouble();
        venta3 = teclado.nextDouble();

        System.out.println("Escribe el sueldo base:");
        sueldo = teclado.nextDouble();

        comision = (venta1 + venta2 + venta3) * 0.10;

        System.out.println("El sueldo base es: " + sueldo);
        System.out.println("La comisión del mes es: " + comision);
        System.out.println("El sueldo total del mes es: " + (sueldo + comision));

        teclado.close();
        }
    }
}