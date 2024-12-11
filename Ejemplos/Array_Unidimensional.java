import java.util.Random;

public class Array_Unidimensional {
    public static void main(String[] args) {
        int array [] = new int [6];
        Random num = new Random();
        for (int i = 0; i<6 ;i++){
            
            array[i] = num.nextInt(20);
        }

        for (int i = 0; i < 6; i++){
            System.out.println("[" +i+ "] = "+array[i]);
        }

    }
}