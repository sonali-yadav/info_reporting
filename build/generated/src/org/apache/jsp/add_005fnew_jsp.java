package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public final class add_005fnew_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/connection.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Guides</title>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Open+Sans\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/guides_db","admin","tiger");
                session.setAttribute("conn", conn);
                }
            catch(Exception e) {
            out.println("Not connected :" +e);
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <div class=\"title_div capital\"><a class=\"list_item\" href=\"index.jsp\">How To Start</a></div>\n");
      out.write("</header>\n");
      out.write("<nav id=\"navbar\">\n");
      out.write("    <ul class=\"nav_list\">\n");
      out.write("        ");
  try {
                Connection con = (Connection) session.getAttribute("conn");
                PreparedStatement st = con.prepareStatement("select * from titles_tb");
                ResultSet rs = st.executeQuery();
                String head = request.getParameter("head");
                while (rs.next()) {
      out.write("\n");
      out.write("        <li>\n");
      out.write("            <a class=\"list_item\" href=\"");
      out.print("index.jsp?head=" + rs.getString("titles_tb.title_id") + "&title=" + rs.getString("titles_tb.title_name"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("titles_tb.title_name"));
      out.write("</a>\n");
      out.write("        </li>\n");
      out.write("        ");
 }
            st.close();
            rs.close();
        
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <div class=\"add_new_title_div\">\n");
      out.write("        <a href=\"add_new_title.jsp\" class=\"list_item\"><img src=\"images/add_icon.png\" alt=\"ADD\" class=\"add_icon\" title=\"Add New\"></a>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<main id=\"main-doc\">\n");
      out.write("    <section class=\"table_section\">\n");
      out.write("    <div class=\"table_div\">\n");
      out.write("        <div class=\"table_header capital\">Add a new record to ");
      out.print(request.getParameter("title"));
      out.write("</div>\n");
      out.write("        <div class=\"form_container_div\">\n");
      out.write("            <form name=\"new_subtitle_form\" action=\"add_new.jsp\" method=\"POST\">\n");
      out.write("                <div class=\"label_t\"><label for=\"description\">Description:</label></div>\n");
      out.write("                <div><input type=\"text\" name=\"description\" id=\"description\" required=\"required\"></div>\n");
      out.write("                <div class=\"label_t\"><label for=\"doc_link\">Link to Document:</label>\n");
      out.write("                    <div><input type=\"text\" name=\"doc_link\" id=\"doc_link\"></div>\n");
      out.write("                    <div class=\"label_t\"><label for=\"faq_link\">Link to FAQ:</label>\n");
      out.write("                        <div><input type=\"text\" name=\"faq_link\" id=\"faq_link\"></div>\n");
      out.write("                        <input type=\"hidden\" name=\"head\" value=");
      out.print(head);
      out.write(">\n");
      out.write("                               <div class=\"label_t\"><label>Visible to? (Check all that apply)</label></div>\n");
      out.write("                        <div>\n");
      out.write("                            <div>\n");
      out.write("                                <input type=\"checkbox\" id=\"st\" name=\"audience\" value=\"s\">\n");
      out.write("                                <label for=\"st\">Students</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <input type=\"checkbox\" id=\"fa\" name=\"audience\" value=\"f\">\n");
      out.write("                                <label for=\"fa\">Faculty</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <input type=\"checkbox\" id=\"em\" name=\"audience\" value=\"e\">\n");
      out.write("                                <label for=\"em\">Employee</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div>\n");
      out.write("                                <input type=\"checkbox\" id=\"ad\" name=\"audience\" value=\"a\">\n");
      out.write("                                <label for=\"ad\">Admin</label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div><input class=\"faq_btn list_item\" id=\"submit_btn\" type=\"submit\" value=\"Submit\" name=\"submit_record\"></div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");

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
                    response.sendRedirect("index.jsp");
                    } catch (Exception e) {
                        //out.println("Error: " + e);
                    }
                
      out.write("\n");
      out.write("                </section>\n");
      out.write("                </main>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
