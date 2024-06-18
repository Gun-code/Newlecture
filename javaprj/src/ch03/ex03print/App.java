package ch03.ex03print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        int menu;
        String iname = "";
        int ikor = 0;
        int ieng = 0;
        int imath = 0;

        while (true) {
            {
                Scanner sc = new Scanner(System.in);

                System.out.printf("""
                        ┌───────────────────────────────┐
                        │            성적관리           │
                        └───────────────────────────────┘

                        1. 목록보기
                        2. 성적추가
                        3. 성적로드
                        4. 성적저장
                        5. 종료
                        메뉴를 숫자로 입력하세요
                        """);
                menu = sc.nextInt();

                System.out.println(menu);

            }
            if (menu == 1) {
                FileInputStream fis = new FileInputStream("javaprj/res/data.csv");
                Scanner sc = new Scanner(fis);
                Scanner scan = new Scanner(System.in);
                int i = 0;

                System.out.printf("""
                        ┌───────────────────────────────┐
                        │           성적 출력           │
                        └───────────────────────────────┘
                        """);

                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String tokens[] = line.split(",");

                    if (i == 0) {
                        System.out.printf("\t%s\t%s\t%s\t%s\t총합\t평균\t학점\n", tokens[0], tokens[1], tokens[2], tokens[3]);
                    } else {

                        int kor, eng, math;
                        String name = tokens[0];
                        String grade;

                        // 숫자 확인
                        if (!isNumeric(tokens[1]))
                            kor = 0;
                        else
                            kor = Integer.parseInt(tokens[1]);
                        if (0 > kor || kor > 100)
                            kor = 0;

                        if (!isNumeric(tokens[2]))
                            eng = 0;
                        else
                            eng = Integer.parseInt(tokens[2]);
                        if (0 > eng || eng > 100)
                            eng = 0;

                        if (!isNumeric(tokens[3]))
                            math = 0;
                        else
                            math = Integer.parseInt(tokens[3]);
                        if (0 > math || math > 100)
                            math = 0;

                        int total = kor + eng + math;// 총점
                        double avg = total / 3.0; // 평균

                        // 학점
                        if (avg >= 90)
                            grade = "A";
                        else if (avg >= 80)
                            grade = "B";
                        else if (avg >= 70)
                            grade = "c";
                        else if (avg >= 60)
                            grade = "D";
                        else if (avg >= 50)
                            grade = "E";
                        else
                            grade = "F";

                        System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", i, name, kor, eng, math, total, avg,
                                grade);
                    }
                    i++;
                }

                System.out.println("아무 키나 입력하면 메인메뉴로 돌아갑니다");
                scan.nextLine();
                sc.close();
                fis.close();

            } else if (menu == 2) {

                System.out.printf("""
                        ┌───────────────────────────────┐
                        │           성적 입력           │
                        └───────────────────────────────┘
                        """);

                Scanner sc = new Scanner(System.in);

                System.out.printf("name>");
                iname = sc.nextLine();
                System.out.printf("kor>");
                ikor = sc.nextInt();
                System.out.printf("eng>");
                ieng = sc.nextInt();
                System.out.printf("math>");
                imath = sc.nextInt();
                // system.out의 out은 이미 printstream이다.
                // 그 경우 가비지 컬렉터가 fout이 fos를 참조하지 않을 때까지 기다렸다가 가비지를 수거.
                // 메모리 낭비가 될 수 있다.
                System.out.println("아무 키나 입력하면 메인메뉴로 돌아갑니다");
                sc.nextLine();
            } else if (menu == 3) {
                Scanner scan = new Scanner(System.in);
                System.out.printf("""
                        ┌───────────────────────────────┐
                        │           성적 로드           │
                        └───────────────────────────────┘
                        """);
                if (iname == "")
                    System.out.println("성적을 추가하지 않았습니다.");
                else
                    System.out.printf("%s,%d,%d,%d\n", iname, ikor, ieng, imath);
                System.out.println("아무 키나 입력하면 메인메뉴로 돌아갑니다");
                scan.nextLine();
            } else if (menu == 4) {
                Scanner scan = new Scanner(System.in);

                System.out.printf("""
                        ┌───────────────────────────────┐
                        │           성적 저장           │
                        └───────────────────────────────┘
                        """);
                FileOutputStream fos = new FileOutputStream("javaprj/res/data.txt");
                PrintStream fout = new PrintStream(fos, true, Charset.forName("utf-8"));
                fout.printf("\n%s,%d,%d,%d", iname, ikor, ieng, imath);
                System.out.println("아무 키나 입력하면 메인메뉴로 돌아갑니다");
                scan.nextLine();
                fout.close(); // fout을 닫지 않고 fos를 닫을 경우 fout이 참조변수로 fos를 참조하고 있다.
                fos.close();

            } else if (menu == 5) {
                System.out.printf("""
                        ┌───────────────────────────────┐
                        │         시스템 종료           │
                        └───────────────────────────────┘
                        """);
                System.out.println("bye~");
                break;
            } else {
                continue;
            }
        }

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
