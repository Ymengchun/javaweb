<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@include file="top.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <!--
        <h1>hello</h1>
    -->
    <%--
        <%
            System.out.println("hi~~~~");
        %>
    --%>
	<%--

    <input>
	--%>

    <%
        pageContext.setAttribute("msg","hello");
    %>

    <%=pageContext.getAttribute("msg")%>



</body>
</html>
