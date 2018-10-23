<%-- 
    Document   : index
    Created on : Oct 11, 2018, 12:43:08 PM
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
            %>
        </ul>
        <div class="add_new_title_div">
            <a href="add_new_title.jsp" class="list_item"><img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New"></a>
        </div>
        
    </nav>
<main id="main-doc">
    <section>
        <div class="table_div">
            <%
            if(request.getParameter("title").equals(null)){%>
            <div class="table_header">How To Start</div> 
            <%}
            else {%>
                <div class="table_header">
                    <%=request.getParameter("title")%>
                    <a href="<%="add_new.jsp?title="+request.getParameter("title")+"&head="+request.getParameter("head")%>"><img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New"></a>
                </div>
            <%}
            %>
            <table class="tables" cellspacing="0">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Document</th>
                        <th>Last Updated</th>
                        <th>FAQ</th>
                    </tr>
                </thead>
                <tbody class="table_body">
                <% String title_id=request.getParameter("head");
                PreparedStatement st1 = con.prepareStatement("select sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where title_id="+title_id);
                ResultSet rs1 = st1.executeQuery();
                while(rs1.next()){
                %>
                <tr>
                    <td><%=rs1.getString("subtitles_tb.sub_name")%> </td>
                    <td>
                        <a href="<%=rs1.getString("subtitles_tb.sub_doc")%>" target="_blank">
                            <img src="images/pdf_icon.png" alt="PPT" class="ppt_icon">
                        </a>
                    </td>
                    <td><%=rs1.getString("subtitles_tb.last_modified")%></td>
                    <td>
                        <a class="faq_btn list_item" href="<%=rs1.getString("subtitles_tb.faq_doc")%>" target="_blank">
                            FAQs
                        </a>
                    </td>
                </tr>
                <%}       
                    st1.close();
                    rs1.close();
                }
                catch(Exception e)
                {
                        System.out.println("Error: "+e);
                }
                %>
                </tbody>
            </table>
        </div>
    </section>
</main>