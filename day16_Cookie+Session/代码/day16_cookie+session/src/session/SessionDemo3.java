import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 关闭客户端，不关闭服务器，两次获取的session不同
 * 若希望相同，让cookie持久化保存
 */
@WebServlet("/sessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);    //打印session的地址
        //手动关闭浏览器，再打印一次
        //两次结果不同

        //期望客户端关闭后，session也能相同
        Cookie c = new Cookie("JSESSIONID", session.getId());
        c.setMaxAge(60*60);
        response.addCookie(c);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
