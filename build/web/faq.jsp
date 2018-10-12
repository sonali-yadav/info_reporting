<%-- 
    Document   : faq
    Created on : Oct 12, 2018, 4:06:30 PM
    Author     : acer
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.io.*" %>
<%@include file="connection.jsp" %>
<header>
    <div class="title_div center capital"><div class="h2">How To Start</div></div>
</header>
<main>
    <div class="h3 center capital subtitle_div">Frequently Asked Questions</div>
    <div class="table_div">
        <%  
            try {
                Connection con = (Connection)session.getAttribute("conn");
                String sno=request.getParameter("srno");
                PreparedStatement st = con.prepareStatement("select faq_q_no,faq_q,faq_ans from faq_master where sr_no="+sno+" order by faq_q_no;");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
        %>
        <div class="subtitle_div question_div">
            <div class="h4 subtitle_div"><%=rs.getString("faq_master.faq_q")%></div>
            <div><%=rs.getString("faq_master.faq_ans")%></div>
        </div>
            <%}       
                st.close();
                rs.close();
            }
            catch(Exception e)
            {
                    System.out.println("Error: "+e);
            }
            %>
            </tbody>
        </table>
    </div>
</main>
