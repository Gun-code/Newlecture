import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        
        // int chCode = 'E';
        // System.out.println(chCode);
        // System.out.printf("%c",chCode+1);

        FileOutputStream fos = new FileOutputStream("C:\\8th\\hello.txt");
        fos.write('E');
        // fos.close();
        System.out.println("작업완료");

    }
}
