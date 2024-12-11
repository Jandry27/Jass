import javax.swing.JOptionPane;

public class Bidimensional {
    public static void main(String[] args) {
        int array [][]= new int [4][4];// recorre filas
        for (int i=0; i<4;i++){
            for (int j=0; j<4; j++){//recorre columnas
                array[i][j] = i*j;

            }
        }
        for (int i=0; i<4;i++){
            for (int j=0; j<4; j++){
                //array[i][j] = i*j;
                System.out.println("matriz["+i+","+j+"]="+array[i][j]);
    }
    
}
