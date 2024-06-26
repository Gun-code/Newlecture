package ch03.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class WebClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("192.168.0.61", 8080);
        System.out.println(socket.isConnected());
        Scanner sc = new Scanner(socket.getInputStream());
        PrintStream ps = new PrintStream(socket.getOutputStream(),true);
        //Request-Line   = Method SP Request-URI SP HTTP-Version CRLF
        String requestLine = "GET /html/hello HTTP/1.1\r\n";
        String requestHeader = "Host: 192.168.0.14\r\n";
        ps.println(requestLine + requestHeader);
        System.out.println("작업완료");
    }
}