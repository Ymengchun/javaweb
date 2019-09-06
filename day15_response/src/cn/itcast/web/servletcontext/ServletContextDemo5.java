package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 获取文件的真实(服务器)路径
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ServletContext功能：
        1. 获取MIME类型：
        2. 域对象：共享数据
        3. 获取文件的真实(服务器)路径
        */
        
        //通过HttpServlet获取ServletContext对象
        ServletContext context = this.getServletContext();

        //1.在/web下创建b.txt
        //2.访问
        String b = context.getRealPath("/b.txt");   //web目录下资源访问
        System.out.println(b);
        // File file = new File(realPath);

        //1.在/WEB-INF下创建c.txt
        //2.访问
        String c = context.getRealPath("/WEB-INF/c.txt");   //WEB-INF目录下的资源访问
        System.out.println(c);

        //1.在/src下创建a.txt
        //2.访问
        String a = context.getRealPath("/WEB-INF/classes/a.txt");   //src目录下的资源访问
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
