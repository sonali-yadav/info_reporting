<%-- 
    Document   : index
    Created on : Oct 11, 2018, 12:43:08 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*,java.io.*" %>
<%@include file="connection.jsp" %>
<nav id="navbar">
    <header>
        <div class="capital in_block title_div"><a class="list_item" href="index.jsp">How To Start</a></div>
    </header>
    <div class="search_div">
        <form action="home.jsp" method="POST">
            <input type="text" id="search_bar" placeholder="Search.." name="search" autofocus="autofocus">
            <button type="submit" id="srch_btn"><span class="fa fa-search" style="color:#fff;"></span></button>
        </form>
    </div>
    <ul class="nav_list">
        <% String srch = request.getParameter("search");
            ResultSet rs;
            PreparedStatement st;
            try {
                Connection con = (Connection) session.getAttribute("conn");
                if (srch == null) {
                    st = con.prepareStatement("select * from titles_tb");
                } else {
                    st = con.prepareStatement("select * from titles_tb where title_name like '%" + srch + "%'");
                }
                rs = st.executeQuery();
                while (rs.next()) {%>
        <li>
            <form action="home.jsp" name="title_form" method="POST">
                <input type="hidden" name="title" value=<%=rs.getString("titles_tb.title_name")%>>
                <input type="hidden" name="head" value=<%=rs.getString("titles_tb.title_id")%>>
                <input type="submit" value="<%=rs.getString("titles_tb.title_name")%>" name="title_submit" class="list_item nav_links">
            </form>
        </li>
        <% }%>
        <%    st.close();
                rs.close();
            } catch (Exception e) {
                out.println("Error in Title load: " + e);
            }
        %>
    </ul>
    <div class="add_new_title_div">
        <a href="add_new_title.jsp" class="list_item"><img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New"></a>
    </div>
</nav>
<main id="main-doc">
    <section class="main_header">
        <div>
            <div class="search_div_top">
                <% try {%>
                <form action="home.jsp" method="POST">
                    <input type="text" id="search_bar_top" placeholder="Search.." name="search_rec">
                    <input type="hidden" name="title" value=<%=request.getParameter("title")%>>
                    <input type="hidden" name="head" value=<%=request.getParameter("head")%>>
                    <button type="submit" id="srch_btn_top"><span class="fa fa-search" style="color:#fff;"></span></button>
                </form>
                <% } catch (Exception e) {
                    }%>
            </div>
        </div>
    </section>
    <section class="table_section">
        <div class="table_div">
            <% try {
                    if (request.getParameter("title") == null) {%>
            <div class="table_header"><span class="table_header_title">How To Start</span></div> 
            <%} else {%>
            <div class="table_header">
                <span class="table_header_title"><%=request.getParameter("title")%></span>
                <form action="add_new.jsp" method="POST" class="inline">
                    <input type="hidden" name="title" value=<%=request.getParameter("title")%>>
                    <input type="hidden" name="head" value=<%=request.getParameter("head")%>>
                    <button type="submit" name="add_new_submit" class="nav_links add_icon">
                        <img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New">
                    </button>
                </form>
                <form action="archiverecords.jsp" method="POST" class="inline">
                    <input type="hidden" name="title" value=<%=request.getParameter("title")%>>
                    <input type="hidden" name="head" value=<%=request.getParameter("head")%>>
                    <button type="submit" name="add_new_submit" class="list_item archive_link">Archives
                    </button>
                </form>
            </div>
            <%}
                } catch (Exception e) { //out.println("Error in table header and archives section: "+e);
                }
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
                    <%  try {
                            String title_id = request.getParameter("head");
                            String srec = request.getParameter("search_rec");
                            String sql = "";
                            Connection co = (Connection) session.getAttribute("conn");
                            if (request.getParameter("search_rec") == null) {
                                //out.println("1");
                                sql = "select sub_id,sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where archived=0 and title_id=" + title_id + " order by time_modified desc";
                            } else {
                                //out.println("2");
                                sql = "select sub_id,sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where archived=0 and title_id=" + title_id + " and sub_name like '%" + srec + "%'";
                            }

                            //out.println("sql= "+sql);
                            PreparedStatement st1 = co.prepareStatement(sql);
                            //out.println("statement prepared");
                            ResultSet rs1 = st1.executeQuery();
                            //out.println("query executed");
                            while (rs1.next()) {
                    %>
                    <tr>
                        <td class="description_box">
                            <form action="edit.jsp" name="title_form" method="POST" class="inline">
                                <input type="hidden" name="subid" value=<%=rs1.getString("subtitles_tb.sub_id")%>>
                                <button type="submit" class="list_item nav_links"><img src="images/edit2.png" alt="EDIT" class="pdf_icon"></button>
                            </form>
                            <%=rs1.getString("subtitles_tb.sub_name")%>
                        </td>
                        <td>
                            <% if (!(rs1.getString("subtitles_tb.sub_doc") == null)) {%>
                            <!--<form action="<%=rs1.getString("subtitles_tb.sub_doc")%>" method="POST" target="_blank">
                                <button type="submit" class="nav_links"><img src="images/pdf_icon.png" alt="PDF" class="pdf_icon"></button>
                            </form>-->
                            <a href="<%=rs1.getString("subtitles_tb.sub_doc")%>" target="_blank">
                                <img src="images/pdf_icon.png" alt="PDF" class="pdf_icon">
                            </a>
                            <% } else { %>
                            <img src="images/na.png" alt="N/A" class="pdf_icon">
                            <% }%>
                        </td>
                        <td><%=rs1.getString("subtitles_tb.last_modified")%></td>
                        <td>
                            <% if (!(rs1.getString("subtitles_tb.faq_doc") == null)) {%>
                            <a class="faq_btn list_item" href="<%=rs1.getString("subtitles_tb.faq_doc")%>" target="_blank">
                                FAQs
                            </a>
                            <% } else { %>
                            <img src="images/na.png" alt="N/A" class="pdf_icon">
                            <% } %> 
                        </td>
                    </tr>
                    <% }
                            st1.close();
                            rs1.close();
                        } catch (Exception e) {
                            //out.println("Error in table load & query: " + e);
                        }
                    %>
                </tbody>
            </table>
        </div>
    </section>
</main>