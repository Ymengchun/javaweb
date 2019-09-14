<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el隐式对象</title>
</head>
<body>
    <h4>获取request对象</h4>
    ${pageContext.request}<br>

    <h4>在jsp页面动态获取虚拟目录</h4>
    ${pageContext.request.contextPath}

<%
    response.sendRedirect(request.getContextPath() + "");
%>
</body>
</html>
