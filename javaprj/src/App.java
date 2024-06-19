import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("javaprj/res/data.txt");
        Scanner scan = new Scanner(fis);

        String full = scan.nextLine();
        int b = Integer.parseInt(full.substring(0, 2));
        System.out.println(Character.getNumericValue(b));

        int i = 0;
        int j = 2;

        while (true) {

            int a = Integer.parseInt(full.substring(i, j));
            i += 2;
            j += 2;
            if (a == 32) {
                break;
            }
            System.out.printf("%d", Character.getNumericValue(a));

        }
        System.out.println();
        i = 0;
        j = 2;

        while (true) {

            int a = Integer.parseInt(full.substring(i, j));
            i += 2;
            j += 2;
            if (a == 13) {
                break;
            }
            if (a == 32) {
                System.out.print(" ");
            } else
                System.out.printf("%d", Character.getNumericValue(a));

        }
    }
}
