import javax.swing.JOptionPane;

public class JOP3 {
    public static void main(String[] args) {
    
        String numero = JOptionPane.showInputDialog("Ingrese el ángulo entre 0 y 180°: ");
        int angulo = Integer.parseInt(numero);

        if (angulo <= 0 || angulo >= 180) {
            JOptionPane.showMessageDialog(null, "El ángulo ingresado no está en el rango válido (0-180°).");
        } else {
            if (angulo < 90) {
                JOptionPane.showMessageDialog(null, "Es un ángulo agudo.");
            } else if (angulo > 90) {
                JOptionPane.showMessageDialog(null, "Es un ángulo obtuso.");
            } else {
                JOptionPane.showMessageDialog(null, "Es un ángulo recto.");
            }
        }
    }
}
