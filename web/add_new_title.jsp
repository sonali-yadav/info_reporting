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
            <li>
            <form action="home.jsp" name="title_form" method="POST">
                <input type="hidden" name="title" value=<%=rs.getString("titles_tb.title_name")%>>
                <input type="hidden" name="head" value=<%=rs.getString("titles_tb.title_id")%>>
                <input type="submit" value="<%=rs.getString("titles_tb.title_name")%>" name="title_submit" class="list_item nav_links">
            </form>
            </li>
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
        <section class="table_section">
        <div class="table_div">
            <div class="table_header capital"><span class="table_header_title">Add a new Category</span></div>
            <div class="form_container_div center">
                <form name="new_title_form" action="add_new_title.jsp" method="POST">
                    <label for="category_name">Category Name:</label>
                    <input type="text" name="category_name" id="category_name" required="required">
                    <div><input class="faq_btn list_item" id="submit_btn" type="submit" value="Submit" name="submit_title"></div>
                </form>
            </div>
        </div>
        <%
            try{
                Connection c=(Connection)session.getAttribute("conn");
                String tn=request.getParameter("category_name");
                if(!(tn.equals(null)))
                {
                PreparedStatement st1=c.prepareStatement("insert into titles_tb(title_name) values('"+tn+"')");
                int r=st1.executeUpdate();
                if(r==1){
        %>
        <div>Successfully added.</div>
        <%
            response.sendRedirect("index.jsp");
                }
else {
            %>
            <div>There was some problem. Please check your input and try again.</div>
        <%
            } }
}           catch(Exception e){ 
//out.println("Error: "+e);
}
        %>
        </section>
    </main>
