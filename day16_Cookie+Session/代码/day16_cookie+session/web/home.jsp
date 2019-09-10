<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>itcast</title>
</head>
<body>

<%

    //1.获取所有Cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;   //没有cookie为lastTime
    //2.遍历cookie数组
    if(cookies != null && cookies.length > 0){
        for (Cookie cookie : cookies) {
            //3.获取cookie的名称
            String name = cookie.getName();
            //4.判断名称是否是：lastTime
            if("lastTime".equals(name)){
                //有该Cookie，不是第一次访问

                flag = true;//有lastTime的cookie

                //获取Cookie的value，时间
                String value = cookie.getValue();
                System.out.println("解码前："+value);
                //URL解码：
                value = URLDecoder.decode(value,"utf-8");
                System.out.println("解码后："+value);

                //设置Cookie的value
                //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
                Date date  = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                System.out.println("编码前："+str_date);
                //URL编码
                str_date = URLEncoder.encode(str_date,"utf-8");
                System.out.println("编码后："+str_date);
                cookie.setValue(str_date);
                //设置cookie的存活时间
                cookie.setMaxAge(60 * 60 * 24 * 30);    //一个月
                response.addCookie(cookie);

                %>
            <h1>欢迎回来，您上次访问时间为:<%= value %></h1>
            <input>

<%
                break;
            }
        }
    }

    if(cookies == null || cookies.length == 0 || flag == false){
        //没有，第一次访问

        //设置Cookie的value
        //获取当前时间的字符串，重新设置Cookie的值，重新发送cookie
        Date date  = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        System.out.println("编码前："+str_date);
        //URL编码
        str_date = URLEncoder.encode(str_date,"utf-8");
        System.out.println("编码后："+str_date);

        Cookie cookie = new Cookie("lastTime",str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
        response.addCookie(cookie);
%>

        <h1>您好，欢迎您首次访问</h1>
<span></span>

<%
    }

%>

<input>




</body>
</html>
