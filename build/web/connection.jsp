<%-- 
    Document   : connection
    Created on : Oct 11, 2018, 12:43:33 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*" %>
<%@page import="java.io.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guides</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        </head>
    <body>
        <%
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://172.20.160.35:3306/guides_db","root","11tk@Automation");
                session.setAttribute("conn", conn);
                }
            catch(Exception e) {
            out.println("Not connected :" +e);
            }
        %>
    </body>
</html>