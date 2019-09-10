<%--
  Created by IntelliJ IDEA.
  User: fqy
  Date: 2018/6/8
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>在jsp中书写java代码</title>
  </head>
  <body>


      <%
        System.out.println("hello jsp");
        int i = 5;

        String contextPath = request.getContextPath();  //内置对象request，未声明也可以直接用
        out.print(contextPath); //内置对象out

        response.getWriter().write("response.....");    //内置对象response
      %>

      <%!
        int i = 3;
      %>

      <%= "hello" %>
          System.out.println("hello jsp");
          <h1>hi~ jsp!</h1>

  </body>
</html>
