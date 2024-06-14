package ch03.ex01string;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("javaprj/res/data.csv");
        Scanner sc = new Scanner(fis);

        sc.nextLine();
        
        {
            String line = sc.nextLine();

            String[] words = line.split(",");

            String name = words[0];
            int kor = Integer.parseInt(words[1]);
            int eng = Integer.parseInt(words[2]);
            int math = Integer.parseInt(words[3]);

            System.out.println(line);

            System.out.printf("name : %s, kor : %d, eng : %d, math : %d\n", name, kor, eng, math);
        }
        {
            String line = sc.nextLine();

            String[] words = line.split(",");

            String name = words[0];
            int kor = Integer.parseInt(words[1]);
            int eng = Integer.parseInt(words[2]);
            int math = Integer.parseInt(words[3]);

            System.out.println(line);

            System.out.printf("name : %s, kor : %d, eng : %d, math : %d\n", name, kor, eng, math);
        }
        sc.close();
        fis.close();
    }
}
