package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
// name : 서블릿 이름
// urlPatterns : url 매핑
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 서블릿이 호출되면 service 메소드가 실행된다.
        System.out.println(">>> HelloServlet.service");

        System.out.println(">>> request = " + request); // org.apache.catalina.connector.RequestFacade@2e560fda
        System.out.println(">>> response = " + response); // org.apache.catalina.connector.ResponseFacade@38b0faa9

        // 파라미터 받아오기 (쿼리스트링)
        String userName = request.getParameter("username");
        System.out.println(">>> userName : " + userName);

        // 응답 메시지 보내기 - header 정보에 들어감
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello, " + userName);

    }
}
