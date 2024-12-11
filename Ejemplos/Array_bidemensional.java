import java.util.Random;

public class Array_bidemensional {
    public static void main(String[] args) {
        int array[][]=new int[3][3];  
        Random num = new Random();  
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                array [i][j] = num.nextInt(20);
            }
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("["+i+","+j+"]= "+array[i][j]);
            }
        }
    }
}