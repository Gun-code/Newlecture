package ch03.ex04test10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("javaprj/res/nums.data");
        Scanner scan = new Scanner(fis);

        int sum = 0;
        int limit = 0;

        for(int i=0; limit<3; ){
            int num = Integer.parseInt(scan.nextLine());
            if (i == 2) {
                sum += num;
                System.out.println("sum is " + sum);
                
                i = 0;
                sum = 0;
                limit++;
            } else {
                sum += num;
                i++;
            }
            
        }

    }
}
