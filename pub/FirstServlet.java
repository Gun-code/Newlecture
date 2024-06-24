package pub;
// import javax.servlet.*; 톰캣 9버전까지 임폴트 패키지는 javax 이며, 10버전이후 jakarta로 변경됨.
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class FirstServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        System.out.println("Hello Servlet~!");
    }
    
}
