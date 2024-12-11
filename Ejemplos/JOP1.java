import javax.swing.JOptionPane;

public class JOP1 {
    public static void main(String[] args){
        int valor1;
        int valor2;
        int valor3;
        int resultado;

         valor1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero")); 
         System.out.println(valor1);

         valor2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero")); 
         System.out.println(valor2);

         valor3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tercer numero numero")); 

         resultado = valor1 + valor2 + valor3;

         JOptionPane.showMessageDialog(null, "La suma de los tres números es: " + resultado);

        
    }
}
