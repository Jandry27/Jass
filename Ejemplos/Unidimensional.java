import javax.swing.JOptionPane;

public class Unidimensional {
    
    public static void main(String[] args) {

        int array[] = new int [4];
        int valor;

        for (int i=0; i<4; i++){ // llenar el vector 

           valor =Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor"));
            array[i] = i * 2; //llenar el valor j *2

            array [i]=valor;
        }

    for(int i =0; i<4;i++){
        System.out.println("Vector ["+i+"]="+array[i]);
    }
        
    }
}
