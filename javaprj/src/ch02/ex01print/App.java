package ch02.ex01print;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public static void main(String[] args) throws IOException {

        // ConsoleOutputStream cos = new ConsoleOutputStream();
        // PrintStream out = new PrintStream(cos);

        //PrintStream out = new PrintStream(System.out);
        // System.out.write(50); // 문자 코드로 출력하여 아스키코드 50인 숫자 2로 출력
        // System.out.print(50); // 문자열로 출력하여 50 출력
        // System.out.println(80);
        // System.out.print("ab\bcd\tef\"\ng\\"); // 문자열로 출력하여 34.45를 문자열로 출력

        int kor1;
        int kor2;
        int kor3;
        int total;
        double avg;

        kor1 = 30;
        kor2 = 40;
        kor3 = 100;

        total = kor1 + kor2 + kor3;
        avg = total / 3.0;


        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│            성적 출력            │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println();
        System.out.println("kor 1 : " + kor1);
        System.out.println("kor 2 : " + kor2);
        System.out.println("kor 3 : " + kor3);
        System.out.println("total : " + total);
        System.out.printf("avg : %.2f\n", avg);
        System.out.println("───────────────────────────────────");

        // system.out의 out은 이미 printstream이다.

        // out.close();
        FileOutputStream fos = new FileOutputStream("javaprj/res/data.txt");
        PrintStream fout = new PrintStream(fos);

        fout.printf("%d %d %d\n", kor1,kor2,kor3);
        
        fout.close();   // fout을 닫지 않고 fos를 닫을 경우  fout이 참조변수로 fos를 참조하고 있다.
        fos.close();    // 그 경우 가비지 컬렉터가 fout이 fos를 참조하지 않을 때까지 기다렸다가 가비지를 수거.
                        // 메모리 낭비가 될 수 있다.
    }
}
