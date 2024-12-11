import javax.swing.JOptionPane;
public class JOP2 {
    public static void main(String[] args) {

        double venta1, venta2, venta3, comision, sueldo, sueldo_total;

        JOptionPane.showMessageDialog(null, "Escriba las 3 primeras ventas del mes");
        
        venta1 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Primera Venta del mes"));
        venta2 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Segunda Venta del mes"));
        venta3 = Double.parseDouble(JOptionPane.showInputDialog("Escriba la Tercera Venta del mes"));
        
        sueldo = Double.parseDouble(JOptionPane.showInputDialog("Escriba su sueldo base"));

        comision = (venta1 + venta2 + venta3) * 0.10;
        sueldo_total = sueldo + comision;

        JOptionPane.showMessageDialog(null, "El sueldo base es: " + sueldo);
        JOptionPane.showMessageDialog(null, "La comisión es: " + comision);
        JOptionPane.showMessageDialog(null, "El sueldo total es: " + sueldo_total);

    }

}
