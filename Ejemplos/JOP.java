import javax.swing.JOptionPane;

public class JOP {
 public static void main(String[] args) {

     String palabra;
     int numero;
     char letra;
     double promedio;

     palabra = JOptionPane.showInputDialog("Ingrese sus nombre"); // pregunta en el recuadro
     System.out.println(palabra);

     JOptionPane.showMessageDialog(null, "Jandry"); //Da el recuadro del comentario
     
     // para un numero
     numero = Integer.parseInt(JOptionPane.showInputDialog("Un numero")); // para lea un numero y lo convierta en entero
     System.out.println(numero+5);
     JOptionPane.showMessageDialog(null, numero+5);


     // para letra 
     letra = JOptionPane.showInputDialog("Su letra" + palabra).charAt(0);
     System.out.println(letra);

     //PROMEDIO

     promedio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese un valor"));
     JOptionPane.showMessageDialog(null,promedio);

 }
}
