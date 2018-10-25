<%-- 
    Document   : edit
    Created on : Oct 24, 2018, 12:07:49 PM
    Author     : acer
--%>

<%-- 
    Document   : add_new
    Created on : Oct 22, 2018, 4:33:15 PM
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
        <%  try {
                Connection con = (Connection) session.getAttribute("conn");
                PreparedStatement st = con.prepareStatement("select * from titles_tb");
                ResultSet rs = st.executeQuery();
                String subid = request.getParameter("subid");
                while (rs.next()) {%>
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
        %>
    </ul>
    <div class="add_new_title_div">
        <a href="add_new_title.jsp" class="list_item"><img src="images/add_icon.png" alt="ADD" class="add_icon" title="Add New"></a>
    </div>
</nav>
<main id="main-doc">
    <section class="table_section">
    <div class="table_div">
        <div class="table_header capital table_header_title">Edit Record</div>
        <div class="form_container_div">
            <% st=con.prepareStatement("select * from subtitles_tb where sub_id="+subid);
            rs=st.executeQuery();
            while(rs.next()) {
            %>
            <form name="edit_subtitle_form" action="edit.jsp" method="GET">
                <div><label for="description">Description:</label></div>
                <div><input type="text" name="description" id="description" required="required" value="<%=rs.getString("subtitles_tb.sub_name")%>"></div>
                <div class="label_t"><label for="doc_link">Link to Document:</label></div>
                    <div><input type="text" name="doc_link" id="doc_link" value="<%=rs.getString("subtitles_tb.sub_doc")%>"></div>
                    <div class="label_t"><label for="faq_link">Link to FAQ:</label></div>
                        <div><input type="text" name="faq_link" id="faq_link" value="<%=rs.getString("subtitles_tb.faq_doc")%>"></div>
                        <input type="hidden" name="subid" value=<%=subid%>>
                        <div class="label_t"><label>Visible to? (Check all that apply)</label></div>
                        <div>
                            <div>
                                <% if(rs.getString("subtitles_tb.access_code").charAt(0)=='1') { %>
                                <input type="checkbox" id="st" name="audience" value="s" checked="checked">
                                <% } else {%>
                                <input type="checkbox" id="st" name="audience" value="s">
                                <% }%>
                                <label for="st">Students</label>
                            </div>
                            <div>
                                <% if(rs.getString("subtitles_tb.access_code").charAt(1)=='1') { %>
                                <input type="checkbox" id="fa" name="audience" value="f" checked="checked">
                                <% } else {%>
                                <input type="checkbox" id="fa" name="audience" value="f">
                                <% }%>
                                <label for="fa">Faculty</label>
                            </div>
                            <div>
                                <% if(rs.getString("subtitles_tb.access_code").charAt(2)=='1') { %>
                                <input type="checkbox" id="em" name="audience" value="e" checked="checked">
                                <% } else {%>
                                <input type="checkbox" id="em" name="audience" value="e">
                                <% }%>
                                <label for="em">Employee</label>
                            </div>
                            <div>
                                <% if(rs.getString("subtitles_tb.access_code").charAt(3)=='1') { %>
                                <input type="checkbox" id="ad" name="audience" value="a" checked="checked">
                                <% } else {%>
                                <input type="checkbox" id="ad" name="audience" value="a">
                                <% }%>
                                <label for="ad">Admin</label>
                            </div>
                        </div>
                        <!--<div class="label_t"><label>Archived</label></div>
                        <div>
                            <div>
                                <input type="radio" id="yes" name="archived" value="1">
                                <label for="yes">Yes</label>
                            </div>
                            <div>
                                <input type="radio" id="no" name="archived" value="0" checked="checked">
                                <label for="no">No</label>
                            </div>
                        </div>-->
                        <input type="hidden" value="<%=rs.getString("subtitles_tb.title_id")%>" name="head">
                        <% } %>
                        <div><input class="faq_btn list_item" id="submit_btn" type="submit" value="Submit" name="submit_record"></div>
                        </form>
                    </div>
                </div>
                <%
                    String head="", desc = "", sql = "",sql1="", lf = "", ld = "",arch="";
                    int s = 0, f = 0, e = 0, a = 0;
                    desc = request.getParameter("description");
                    ld = request.getParameter("doc_link");
                    lf = request.getParameter("faq_link");
                    //arch=request.getParameter("archived");
                    head=request.getParameter("head");
                    if(!(ld.equals(""))) {
                        ld="'"+ld+"'";
                    }
                    if(!(lf.equals(""))) {
                        lf="'"+lf+"'";
                    }
                    if (ld.equals("")) {
                        ld = "NULL";
                    }
                    if (lf.equals("")) {
                        lf = "NULL";
                    }
                    String[] access = request.getParameterValues("audience");
                    //out.println("desc= " + desc);
                    //out.println("ld= " + ld);
                    //out.println("lf= " + lf);
                    for (String i : access) {
                        if (i.equals("s")) {
                            s = 1;
                        } else if (i.equals("f")) {
                            f = 1;
                        } else if (i.equals("e")) {
                            e = 1;
                        } else if (i.equals("a")) {
                            a = 1;
                        }
                    }
                    String access_code = "" + s + f + e + a;
                    //out.println("access_code= " + access_code);
                    subid = request.getParameter("subid");
                    //out.println("subid= " + subid);
                    
                    if (!(desc.equals(null) && subid.equals(""))) {
                        sql1="insert into subtitles_tb(archived,sub_name,title_id,last_modified,time_modified,access_code,sub_doc,faq_doc) values(0,'" + desc + "'," + head + ",CURDATE(),NOW(),'" + access_code + "'," + ld + "," + lf + ")";
                        sql = "update subtitles_tb set archived=1 where sub_id="+subid;
                        PreparedStatement st1 = con.prepareStatement(sql1);
                        int r = st1.executeUpdate();
                        //out.println(sql1);
                        //out.println("r= "+r);
                        st1=con.prepareStatement(sql);
                        int rt=st1.executeUpdate();
                        //out.println(sql);
                        //out.println("rt= "+rt);
                        response.sendRedirect("home.jsp");
                        }
                    } catch (Exception e) {
                        //out.println("Error: " + e);
                    }
                %>
                </section>
                </main>