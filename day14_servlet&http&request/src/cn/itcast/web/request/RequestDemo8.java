import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发
 * 数据共享，存储数据到request域中
 */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8888被访问了。。。");
        //转发到demo9资源
        /*
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
        requestDispatcher.forward(request, response);   //传递request和respond对象到requestDemo9
        */

        //演示数据共享，存储数据到request域中
        request.setAttribute("msg","hello");

        request.getRequestDispatcher("/requestDemo9").forward(request,response);    //链式编程，改进以上代码
        //request.getRequestDispatcher("http://www.itcast.cn").forward(request,response);   //无法访问，因为该资源不再服务器中

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
