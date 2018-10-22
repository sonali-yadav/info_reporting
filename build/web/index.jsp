<%-- 
    Document   : index
    Created on : Oct 11, 2018, 12:43:08 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.io.*" %>
<%@include file="connection.jsp" %>
<header>
    <div class="title_div center capital"><div class="h2">How To Start</div></div>
</header>
<main>
    <section>
        <ul>
        <% try {
            Connection con=(Connection)session.getAttribute("conn");
            PreparedStatement st=con.prepareStatement("select * from titles_tb");
            ResultSet rs=st.executeQuery();
            while(rs.next()) {%>
            <li><a href="<%="index.jsp?head="+rs.getString("titles_tb.title_id")%>"><%=rs.getString("titles_tb.title_name")%></a></li>
            <% }
            st.close();
            rs.close();
            %>
        </ul>
    </section>
    <section>
        <div class="table_div" style="border:1px solid #cacaca;">
            <table border="1">
                <!--<thead>
                    <tr>
                        <th>Title Name</th>
                        <th>PPT</th>
                        <th>Last Updated</th>
                        <th>FAQs</th>
                    </tr>
                </thead>-->
                <tbody>
                <% String title_id=request.getParameter("head");
                //out.println("1");
                PreparedStatement st1 = con.prepareStatement("select sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where title_id="+title_id);
                //out.println("2");
                ResultSet rs1 = st1.executeQuery();
                //out.println("3");
                while(rs1.next()){
                %>
                <tr>
                    <td><%=rs1.getString("subtitles_tb.sub_name")%> </td>
                    <td>
                        <a href="<%=rs1.getString("subtitles_tb.sub_doc")%>" target="_blank">
                            <img src="images/ppt_icon2.png" alt="PPT" class="ppt_icon">
                        </a>
                    </td>
                    <td><%=rs1.getString("subtitles_tb.last_modified")%></td>
                    <td>
                        <a href="<%=rs1.getString("subtitles_tb.faq_doc")%>" target="_blank">
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