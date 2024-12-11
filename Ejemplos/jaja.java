import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class jaja {
    public static void main(String[] args) {

        double venta1, venta2, venta3, comision, sueldo, sueldo_total;

        // Mostrar un mensaje inicial
        JOptionPane.showMessageDialog(null, "Escriba las 3 primeras ventas del mes");

        // Solicitar las tres ventas
        venta1 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Primera Venta del mes"));
        venta2 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Segunda Venta del mes"));
        venta3 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Tercera Venta del mes"));

        // Solicitar el sueldo base
        sueldo = Double.parseDouble(JOptionPane.showInputDialog("Escriba su sueldo base"));

        // Calcular la comisión como el 10% del total de las ventas
        comision = (venta1 + venta2 + venta3) * 0.10;

        // Calcular el sueldo total
        sueldo_total = sueldo + comision;

        // Crear un formato para mostrar los resultados con 2 decimales
        DecimalFormat formato = new DecimalFormat("#0.00");

        // Mostrar los resultados con formato
        JOptionPane.showMessageDialog(null, "El sueldo base es: " + formato.format(sueldo));
        JOptionPane.showMessageDialog(null, "La comisión es: " + formato.format(comision));
        JOptionPane.showMessageDialog(null, "El sueldo total es: " + formato.format(sueldo_total));
    }
}