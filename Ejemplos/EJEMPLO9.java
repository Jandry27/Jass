import java.util.Scanner;
public class EJEMPLO9 {
    /**
     * @param args
     */
    public static void main(String[] args){
        try (Scanner teclado = new Scanner(System.in)) {
          {
          double total;
          
          
          System.out.println("Escribe el presupuesto anual: ");
          total=teclado.nextDouble(); 

          System.out.println("El area de Ginecobstetricia le corresponde: "+ total *.40);
          System.out.println("El area de Traumatologia le corresponde: "+total*.30);
          System.out.println("El area de Pediatria le corresponde: "+total*.30);


  }
        } 
  } 
}
