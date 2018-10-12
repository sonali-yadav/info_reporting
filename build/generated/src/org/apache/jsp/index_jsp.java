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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/guides_db","admin","tiger");
                session.setAttribute("conn", conn);
                out.println("Connected");
            }
            catch(Exception e) {
            out.println("Not connected");
            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("<center><h1>Payroll Report</h1></center>\n");
      out.write("<center>\n");
      out.write("    <table border=\"1\" cellspacing=\"0\">\n");
      out.write("        <tr>\n");
      out.write("            <td><b>Sr No.</b></td>\n");
      out.write("            <td><b>Tilte</b></td>\n");
      out.write("            <td><b>PPT</b></td>\n");
      out.write("            <td><b>FAQs</b></td>\n");
      out.write("        </tr>\n");
      out.write("        ");
  
            try {
            Connection con = (Connection)session.getAttribute("conn");
            out.println("1");
            PreparedStatement st = con.prepareStatement("select pk,sr_no,title,guide_ppt from guides_master;");
            out.println("2");
            ResultSet rs = st.executeQuery();
            out.println("3");
            while(rs.next()){
           
      out.write("\n");
      out.write("                   <tr>\n");
      out.write("                       <td>");
      out.print(rs.getString("guides_master.sr_no"));
      out.write(" </td>\n");
      out.write("                       <td>");
      out.print(rs.getString("guides_master.title"));
      out.write(" </td>\n");
      out.write("                       <td> ");
      out.print(rs.getString("guides_master.guide_ppt"));
      out.write("</td>\n");
      out.write("                       <td>FAQs</td>\n");
      out.write("                   </tr>\n");
      out.write("                   ");
}       
                        st.close();
			rs.close();
        }
        catch(Exception e)
        {
        	System.out.println("Error: "+e);
        }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </center>");
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
