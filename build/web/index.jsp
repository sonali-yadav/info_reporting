<%-- 
    Document   : index
    Created on : Oct 25, 2018, 12:07:17 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.io.*" %>
<%@include file="connection.jsp" %>

<header>
    <div class="title_div capital"><a class="list_item" href="index.jsp">How To Start</a></div>
</header>
<%
    response.sendRedirect("home_user.jsp");
%>