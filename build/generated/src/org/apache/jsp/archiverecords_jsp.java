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

public final class archiverecords_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<nav id=\"navbar\">\n");
      out.write("    <header>\n");
      out.write("        <div class=\"capital in_block title_div\"><a class=\"list_item\" href=\"index.jsp\">How To Start</a></div>\n");
      out.write("    </header>\n");
      out.write("    <div class=\"search_div\">\n");
      out.write("        <form action=\"home.jsp\" method=\"POST\">\n");
      out.write("            <input type=\"text\" id=\"search_bar\" placeholder=\"Search..\" name=\"search\" autofocus=\"autofocus\">\n");
      out.write("            <button type=\"submit\" id=\"srch_btn\"><span class=\"fa fa-search\" style=\"color:#fff;\"></span></button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <ul class=\"nav_list\">\n");
      out.write("        ");
 String srch = request.getParameter("search");
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
                while (rs.next()) {
      out.write("\n");
      out.write("        <li>\n");
      out.write("            <form action=\"home.jsp\" name=\"title_form\" method=\"POST\">\n");
      out.write("                <input type=\"hidden\" name=\"title\" value=");
      out.print(rs.getString("titles_tb.title_name"));
      out.write(">\n");
      out.write("                <input type=\"hidden\" name=\"head\" value=");
      out.print(rs.getString("titles_tb.title_id"));
      out.write(">\n");
      out.write("                <input type=\"submit\" value=\"");
      out.print(rs.getString("titles_tb.title_name"));
      out.write("\" name=\"title_submit\" class=\"list_item nav_links\">\n");
      out.write("            </form>\n");
      out.write("        </li>    ");
 }
      out.write("\n");
      out.write("            ");
    st.close();
                    rs.close();
                } catch (Exception e) {
                    out.println("Error in Title load: " + e);
                }
            
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <div class=\"add_new_title_div\">\n");
      out.write("        <a href=\"add_new_title.jsp\" class=\"list_item\"><img src=\"images/add_icon.png\" alt=\"ADD\" class=\"add_icon\" title=\"Add New\"></a>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<main id=\"main-doc\">\n");
      out.write("    <section class=\"main_header\">\n");
      out.write("        <div class=\"\">\n");
      out.write("            <div class=\"search_div_top\">\n");
      out.write("                ");
 try {
      out.write("\n");
      out.write("                <form action=\"archiverecords.jsp\" method=\"POST\">\n");
      out.write("                    <input type=\"text\" id=\"search_bar_top\" placeholder=\"Search..\" name=\"search_rec\">\n");
      out.write("                    <input type=\"hidden\" name=\"title\" value=");
      out.print(request.getParameter("title"));
      out.write(">\n");
      out.write("                    <input type=\"hidden\" name=\"head\" value=");
      out.print(request.getParameter("head"));
      out.write(">\n");
      out.write("                    <button type=\"submit\" id=\"srch_btn_top\"><span class=\"fa fa-search\" style=\"color:#fff;\"></span></button>\n");
      out.write("                </form>\n");
      out.write("                ");
 } catch (Exception e) {
                    }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"table_section\">\n");
      out.write("        <div class=\"table_div\">\n");
      out.write("            ");
 try {
                    if (request.getParameter("title") == null) {
      out.write("\n");
      out.write("            <div class=\"table_header\"><span class=\"table_header_title\">How To Start</span></div> \n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            <div class=\"table_header\">\n");
      out.write("                <span class=\"table_header_title\">");
      out.print(request.getParameter("title"));
      out.write("</span>\n");
      out.write("            </div>\n");
      out.write("            ");
}
                } catch (Exception e) { //out.println("Error in table header and archives section: "+e);
                }
            
      out.write("\n");
      out.write("            <table class=\"tables\" cellspacing=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Title</th>\n");
      out.write("                        <th>Document</th>\n");
      out.write("                        <th>Last Updated</th>\n");
      out.write("                        <th>FAQ</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody class=\"table_body\">\n");
      out.write("                    ");
  try {
                            String title_id = request.getParameter("head");
                            String srec = request.getParameter("search_rec");
                            String sql = "";
                            Connection co = (Connection) session.getAttribute("conn");
                            if (request.getParameter("search_rec") == null) {
                                //out.println("1");
                                sql = "select sub_id,sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where archived=1 and title_id=" + title_id + " order by time_modified desc";
                            } else {
                                //out.println("2");
                                sql = "select sub_id,sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where archived=1 and title_id=" + title_id + " and sub_name like '%" + srec + "%'";
                            }

                            //out.println("sql= "+sql);
                            PreparedStatement st1 = co.prepareStatement(sql);
                            //out.println("statement prepared");
                            ResultSet rs1 = st1.executeQuery();
                            //out.println("query executed");
                            while (rs1.next()) {
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td class=\"description_box\">\n");
      out.write("                            ");
      out.print(rs1.getString("subtitles_tb.sub_name"));
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 if (!(rs1.getString("subtitles_tb.sub_doc") == null)) {
      out.write("\n");
      out.write("                            <a href=\"");
      out.print(rs1.getString("subtitles_tb.sub_doc"));
      out.write("\" target=\"_blank\">\n");
      out.write("                                <img src=\"images/pdf_icon.png\" alt=\"PDF\" class=\"pdf_icon\">\n");
      out.write("                            </a>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                            <img src=\"images/na.png\" alt=\"N/A\" class=\"pdf_icon\">\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td>");
      out.print(rs1.getString("subtitles_tb.last_modified"));
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            ");
 if (!(rs1.getString("subtitles_tb.faq_doc") == null)) {
      out.write("\n");
      out.write("                            <a class=\"faq_btn list_item\" href=\"");
      out.print(rs1.getString("subtitles_tb.faq_doc"));
      out.write("\" target=\"_blank\">\n");
      out.write("                                FAQs\n");
      out.write("                            </a>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                            <img src=\"images/na.png\" alt=\"N/A\" class=\"pdf_icon\">\n");
      out.write("                            ");
 } 
      out.write(" \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
                            st1.close();
                            rs1.close();
                        } catch (Exception e) {
                            out.println("Error in table load & query: " + e);
                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("</main>");
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
