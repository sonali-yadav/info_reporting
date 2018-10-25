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
                String head = request.getParameter("head");
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
        <div class="table_header capital"><span class="table_header_title">Add a new record to <%=request.getParameter("title")%></span></div>
        <div class="form_container_div">
            <form name="new_subtitle_form" action="add_new.jsp" method="POST">
                <div class="label_t"><label for="description">Description:</label></div>
                <div><input type="text" name="description" id="description" required="required"></div>
                <div class="label_t"><label for="doc_link">Link to Document:</label>
                    <div><input type="text" name="doc_link" id="doc_link"></div>
                    <div class="label_t"><label for="faq_link">Link to FAQ:</label>
                        <div><input type="text" name="faq_link" id="faq_link"></div>
                        <input type="hidden" name="head" value=<%=head%>>
                               <div class="label_t"><label>Visible to? (Check all that apply)</label></div>
                        <div>
                            <div>
                                <input type="checkbox" id="st" name="audience" value="s">
                                <label for="st">Students</label>
                            </div>
                            <div>
                                <input type="checkbox" id="fa" name="audience" value="f">
                                <label for="fa">Faculty</label>
                            </div>
                            <div>
                                <input type="checkbox" id="em" name="audience" value="e">
                                <label for="em">Employee</label>
                            </div>
                            <div>
                                <input type="checkbox" id="ad" name="audience" value="a">
                                <label for="ad">Admin</label>
                            </div>
                        </div>
                        <div><input class="faq_btn list_item" id="submit_btn" type="submit" value="Submit" name="submit_record"></div>
                        </form>
                    </div>
                </div>
                <%
                    String desc = "", sql = "", lf = "", ld = "";
                    int s = 0, f = 0, e = 0, a = 0;
                    desc = request.getParameter("description");
                    ld = request.getParameter("doc_link");
                    lf = request.getParameter("faq_link");
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
                    head = request.getParameter("head");
                    //out.println("head= " + head);
                    
                    if (!(desc.equals(null) && head.equals(""))) {
                        sql = "insert into subtitles_tb(archived,sub_name,title_id,last_modified,time_modified,access_code,sub_doc,faq_doc) values(0,'" + desc + "'," + head + ",CURDATE(),NOW(),'" + access_code + "'," + ld + "," + lf + ")";
                        //out.println(sql);
                        PreparedStatement st1 = con.prepareStatement(sql);
                        int row = st1.executeUpdate();
                        if(row==1)
                            out.println("Success");
                        }
                    response.sendRedirect("home.jsp");
                    } catch (Exception e) {
                        //out.println("Error: " + e);
                    }
                %>
                </section>
                </main>