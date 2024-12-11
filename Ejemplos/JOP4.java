import javax.swing.JOptionPane;

public class JOP4 {

    public static void main(String[] args) {

        String numero;
        int angulo;

        numero = JOptionPane.showMessageDialog(null, "Ingrese un angulo de 0 y 180°");
        angulo = Integer.parseInt(numero);

        if (angulo <=0 ; angulo >=180){
            JOptionPane.showMessageDialog(null,"El ángulo ingresado no está en el rango válido (0-180°).");

        }

    
}
