package cn.itcast.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 一张简单的验证码
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int width = 100;
        int height = 50;

        //1.创建验证码图片对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();   //画笔对象
        g.setColor(Color.PINK); //设置画笔为粉色
        g.fillRect(0,0,width,height);  //填充

        //2.2 画边框
        g.setColor(Color.BLUE); //蓝色边框
        g.drawRect(0, 0, width-1, height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";  //字符集合

        Random ran = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());  //生成随机下标，范围0~length-1
            //获取字符
            char ch = str.charAt(index);    //随机字符
            //2.3写验证码
            g.drawString(ch+"",width/5*i,height/2);
        }


        //2.4 画干扰线
        g.setColor(Color.GREEN);    //绿色

        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);    //[0,width)的随机数
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

        //4.在register.html中设置"单击更换验证码"事件

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
