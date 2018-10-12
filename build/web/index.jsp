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
    <div class="button_div flex_box">
        <a href="#acad_instructor" class="btn btn-outline-light">Academic for Instructor</a>
        <a href="#add_entry" class="btn btn-outline-light">Add Entry</a>
    </div>
</header>
<main>
    <div class="h3 center capital subtitle_div">Academic for Students</div>
    <div class="table_div">
        <table class="table table-bordered table-responsive-sm table-hover">
            <thead>
                <tr>
                    <td><b>Sr No.</b></td>
                    <td><b>Tilte</b></td>
                    <td><b>PPT</b></td>
                    <td><b>FAQs</b></td>
                </tr>
            </thead>
            <tbody>
            <%  
                try {
                Connection con = (Connection)session.getAttribute("conn");
                PreparedStatement st = con.prepareStatement("select pk,sr_no,title,guide_ppt from guides_master order by sr_no;");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
            %>
            <tr>
                <td><%=rs.getString("guides_master.sr_no")%> </td>
                <td><%=rs.getString("guides_master.title")%> </td>
                <td>
                    <a href="<%=rs.getString("guides_master.guide_ppt")%>" target="_blank">
                        <img src="images/ppt_icon2.png" alt="PPT" class="ppt_icon">
                    </a>
                </td>
                <td><a>FAQs</a></td>
            </tr>
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
    <div id="acad_instructor">
        <div class="h3 center capital subtitle_div">Academic for Instructor</div>
        <div class="table_div">
            <table class="table table-bordered table-responsive-sm table-hover">
                <thead>
                    <tr>
                        <td><b>Sr No.</b></td>
                        <td><b>Tilte</b></td>
                        <td><b>PPT</b></td>
                        <td><b>FAQs</b></td>
                    </tr>
                </thead>
                <tbody>
                <%  
                    try {
                    Connection con = (Connection)session.getAttribute("conn");
                    PreparedStatement st = con.prepareStatement("select pk,sr_no,title,guide_ppt from guides_master;");
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                %>
                <tr>
                    <td><%=rs.getString("guides_master.sr_no")%> </td>
                    <td><%=rs.getString("guides_master.title")%> </td>
                    <td>
                        <a href="<%=rs.getString("guides_master.guide_ppt")%>" target="_blank">
                            <img src="images/ppt_icon2.png" alt="PPT" class="ppt_icon">
                        </a>
                    </td>
                    <td><a>FAQs</a></td>
                </tr>
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
    </div>
    <div id="add_entry">
        <div class="h3 center capital subtitle_div">Add an Entry</div>
        <div>
            <form name="add_entry_form" action="add_entry.jsp" method="POST">
            </form>
        </div>
    </div>
</main>