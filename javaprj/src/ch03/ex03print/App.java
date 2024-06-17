package ch03.ex03print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        // ConsoleOutputStream cos = new ConsoleOutputStream();
        // PrintStream out = new PrintStream(cos);

        // PrintStream out = new PrintStream(System.out);
        // System.out.write(50); // 문자 코드로 출력하여 아스키코드 50인 숫자 2로 출력
        // System.out.print(50); // 문자열로 출력하여 50 출력
        // System.out.println(80);
        // System.out.print("ab\bcd\tef\"\ng\\"); // 문자열로 출력하여 34.45를 문자열로 출력

        // int kor1;
        // int kor2;
        // int kor3;
        // int total;
        // double avg;

        FileInputStream fis = new FileInputStream("javaprj/res/data.csv");
        Scanner sc = new Scanner(fis);
        int i = 0;

        // kor1 = sc.nextInt();
        // kor2 = sc.nextInt();
        // kor3 = sc.nextInt();

        // total = kor1 + kor2 + kor3;
        // avg = total / 3.0;

        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│            성적 출력            │");
        System.out.println("└─────────────────────────────────┘");
        System.out.println();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String tokens[] = line.split(",");

            if (i == 0) {
                System.out.printf("\t%s\t%s\t%s\t%s\t총합\t평균\n", tokens[0], tokens[1], tokens[2], tokens[3]);
            } else {

                int kor, eng, math;
                String name = tokens[0];

                if (!isNumeric(tokens[1])) 
                    kor = 0;    
                 else{ 
                    kor = Integer.parseInt(tokens[1]);                    
                    if (0 > kor || kor > 100)
                    kor = 0;
                }          
                

                if (!isNumeric(tokens[2]))
                    eng = 0;
                else
                    {eng = Integer.parseInt(tokens[2]);
                    if (0 > eng || eng > 100)
                    eng = 0;
                }
                if (!isNumeric(tokens[3]))
                    math = 0;
                else{
                    math = Integer.parseInt(tokens[3]);
                    if (0 > math || math > 100)
                    math = 0;
                }
                int total = kor + eng + math;
                double avg = total / 3.0;

                System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\n", i, name, kor, eng, math, total, avg);
            }
            i++;
        }

        sc.close();
        fis.close();
        // System.out.println("kor 1 : " + kor1);
        // System.out.println("kor 2 : " + kor2);
        // System.out.println("kor 3 : " + kor3);
        // System.out.println("total : " + total);
        // System.out.printf("avg : %.2f\n", avg);
        System.out.println("───────────────────────────────────");

        // System.out.println();
        // System.out.println("┌─────────────────────────────────┐");
        // System.out.println("│ 성적 입력 │");
        // System.out.println("└─────────────────────────────────┘");
        // System.out.println();

        // Scanner sc1 = new Scanner(System.in);

        // System.out.printf("kor1>");
        // kor1 = sc1.nextInt();
        // System.out.printf("kor2>");
        // kor2 = sc1.nextInt();
        // System.out.printf("kor3>");
        // kor3 = sc1.nextInt();
        // system.out의 out은 이미 printstream이다.

        // out.close();
        // FileOutputStream fos = new FileOutputStream("javaprj/res/data.txt");
        // PrintStream fout = new PrintStream(fos,true,Charset.forName("utf-8"));

        // fout.printf("%d %d %d\n", kor1,kor2,kor3);

        // fout.close(); // fout을 닫지 않고 fos를 닫을 경우 fout이 참조변수로 fos를 참조하고 있다.
        // fos.close(); // 그 경우 가비지 컬렉터가 fout이 fos를 참조하지 않을 때까지 기다렸다가 가비지를 수거.
        // 메모리 낭비가 될 수 있다.
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
