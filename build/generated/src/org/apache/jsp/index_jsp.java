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

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        </header>\n");
      out.write("    <nav id=\"navbar\">\n");
      out.write("        <ul class=\"nav_list\">\n");
      out.write("        ");
 try {
            Connection con=(Connection)session.getAttribute("conn");
            PreparedStatement st=con.prepareStatement("select * from titles_tb");
            ResultSet rs=st.executeQuery();
            while(rs.next()) {
      out.write("\n");
      out.write("            <li><a class=\"list_item\" href=\"");
      out.print("index.jsp?head="+rs.getString("titles_tb.title_id")+"&title="+rs.getString("titles_tb.title_name"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("titles_tb.title_name"));
      out.write("</a></li>\n");
      out.write("            ");
 }
            st.close();
            rs.close();
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("<main id=\"main-doc\">\n");
      out.write("    <section>\n");
      out.write("        <div class=\"table_div\">\n");
      out.write("            ");

            if(request.getParameter("title").equals(null)){
      out.write("\n");
      out.write("            <div class=\"table_header\">How To Start</div> \n");
      out.write("            ");
}
            else {
      out.write("\n");
      out.write("                <div class=\"table_header\">");
      out.print(request.getParameter("title"));
      out.write("</div>\n");
      out.write("            ");
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
      out.write("                ");
 String title_id=request.getParameter("head");
                PreparedStatement st1 = con.prepareStatement("select sub_name,last_modified,sub_doc,faq_doc from subtitles_tb where title_id="+title_id);
                ResultSet rs1 = st1.executeQuery();
                while(rs1.next()){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(rs1.getString("subtitles_tb.sub_name"));
      out.write(" </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"");
      out.print(rs1.getString("subtitles_tb.sub_doc"));
      out.write("\" target=\"_blank\">\n");
      out.write("                            <img src=\"images/ppt_icon2.png\" alt=\"PPT\" class=\"ppt_icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                    <td>");
      out.print(rs1.getString("subtitles_tb.last_modified"));
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"");
      out.print(rs1.getString("subtitles_tb.faq_doc"));
      out.write("\" target=\"_blank\">\n");
      out.write("                            FAQs\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}       
                    st1.close();
                    rs1.close();
                }
                catch(Exception e)
                {
                        System.out.println("Error: "+e);
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
