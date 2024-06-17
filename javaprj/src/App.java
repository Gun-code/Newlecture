import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        // System.out.printf("",);

        String name;
        int kor, eng, math;

        FileInputStream fis = new FileInputStream("javaprj/res/data.csv");
        Scanner scan = new Scanner(fis);

        while (scan.hasNextLine()) { // while 블록 시작
            String line = scan.nextLine();

            String[] tokens = line.split(",");
            name = tokens[0];
            System.out.println(tokens);

            if (!isNumeric(tokens[1]))
                kor = 0;
            else {
                kor = Integer.parseInt(tokens[1]);

                if (!(0 <= kor && kor <= 100))
                    kor = 0;
            }

            if (!isNumeric(tokens[2]))
                eng = 0;
            else {
                eng = Integer.parseInt(tokens[2]);

                if (!(0 <= eng && eng <= 100))
                    eng = 0;
            }

            if (!isNumeric(tokens[3]))
                math = 0;
            else {
                math = Integer.parseInt(tokens[3]);

                if (!(0 <= math && math <= 100))
                    math = 0;
            }

        } // while 블록 끝
        System.out.println();

        scan.close();
        fis.close();

    } // main 함수 끝

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
