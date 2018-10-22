<%-- 
    Document   : add_new_title
    Created on : Oct 22, 2018, 4:32:46 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.io.*" %>
<%@include file="connection.jsp" %>
<header>
    <div class="title_div capital"><a class="list_item" href="index.jsp">How To Start</a></div>
</header>
<nav id="navbar">
    <ul class="nav_list">
        <% try {
            Connection con=(Connection)session.getAttribute("conn");
            PreparedStatement st=con.prepareStatement("select * from titles_tb");
            ResultSet rs=st.executeQuery();
            while(rs.next()) {%>
        <li><a class="list_item" href="<%="index.jsp?head="+rs.getString("titles_tb.title_id")+"&title="+rs.getString("titles_tb.title_name")%>"><%=rs.getString("titles_tb.title_name")%></a></li>
            <% }
            st.close();
            rs.close();
} catch(Exception e){out.println("Error: "+e);}
            %>
    </ul>
    <!--<div class="add_new_title_div">
        <a href="add_new_title.jsp" class="list_item"><img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New"></a>
    </div>-->
    </nav>
    <main id="main-doc">
        <div>Add A New Category</div>
    </main>
