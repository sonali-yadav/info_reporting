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
      out.write("        <title>How To Start</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" \n");
      out.write("              integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" \n");
      out.write("              crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
                Class.forName("com.mysql.jdbc.Driver");
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
      out.write("    <div class=\"title_div center capital\"><div class=\"h2\">How To Start</div></div>\n");
      out.write("    <div class=\"button_div\">\n");
      out.write("        <a href=\"#acad_instructor\" class=\"btn btn-outline-light\">Academic for Instructor</a>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("<main>\n");
      out.write("    <div class=\"h3 center capital subtitle_div\">Academic for Students</div>\n");
      out.write("    <div class=\"table_div\">\n");
      out.write("        <table class=\"table table-bordered table-responsive-sm table-hover\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <td><b>Sr No.</b></td>\n");
      out.write("                    <td><b>Tilte</b></td>\n");
      out.write("                    <td><b>PPT</b></td>\n");
      out.write("                    <td><b>FAQs</b></td>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");
  
                try {
                Connection con = (Connection)session.getAttribute("conn");
                PreparedStatement st = con.prepareStatement("select sr_no,title,guide_ppt from guides_master where group_id=1 order by sr_no;");
                ResultSet rs = st.executeQuery();
                while(rs.next()){
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(rs.getString("guides_master.sr_no"));
      out.write(" </td>\n");
      out.write("                <td>");
      out.print(rs.getString("guides_master.title"));
      out.write(" </td>\n");
      out.write("                ");
 String s=rs.getString("guides_master.sr_no");
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"");
      out.print(rs.getString("guides_master.guide_ppt"));
      out.write("\" target=\"_blank\">\n");
      out.write("                        <img src=\"images/ppt_icon2.png\" alt=\"PPT\" class=\"ppt_icon\">\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("                <td><a target=\"_blank\" href=");
      out.print( "\"faq.jsp?srno="+ rs.getString("guides_master.sr_no")+"\"");
      out.write(">FAQs</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}       
                st.close();
                rs.close();
            }
            catch(Exception e)
            {
                    System.out.println("Error: "+e);
            }
            
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"acad_instructor\">\n");
      out.write("        <div class=\"h3 center capital subtitle_div\">Academic for Instructor</div>\n");
      out.write("        <div class=\"table_div\">\n");
      out.write("            <table class=\"table table-bordered table-responsive-sm table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><b>Sr No.</b></td>\n");
      out.write("                        <td><b>Tilte</b></td>\n");
      out.write("                        <td><b>PPT</b></td>\n");
      out.write("                        <td><b>FAQs</b></td>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");
  
                    try {
                    Connection con = (Connection)session.getAttribute("conn");
                    PreparedStatement st = con.prepareStatement("select sr_no,title,guide_ppt from guides_master where group_id=2 order by sr_no;");
                    ResultSet rs = st.executeQuery();
                    while(rs.next()){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(rs.getString("guides_master.sr_no"));
      out.write(" </td>\n");
      out.write("                    <td>");
      out.print(rs.getString("guides_master.title"));
      out.write(" </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"");
      out.print(rs.getString("guides_master.guide_ppt"));
      out.write("\" target=\"_blank\">\n");
      out.write("                            <img src=\"images/ppt_icon2.png\" alt=\"PPT\" class=\"ppt_icon\">\n");
      out.write("                        </a>\n");
      out.write("                    </td>\n");
      out.write("                    <td><a>FAQs</a></td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}       
                    st.close();
                    rs.close();
                }
                catch(Exception e)
                {
                        System.out.println("Error: "+e);
                }
                
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
