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

public final class add_005fnew_005ftitle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</header>\n");
      out.write("<nav id=\"navbar\">\n");
      out.write("    <ul class=\"nav_list\">\n");
      out.write("        ");
 try {
            Connection con=(Connection)session.getAttribute("conn");
            PreparedStatement st=con.prepareStatement("select * from titles_tb");
            ResultSet rs=st.executeQuery();
            while(rs.next()) {
      out.write("\n");
      out.write("        <li><a class=\"list_item\" href=\"");
      out.print("index.jsp?head="+rs.getString("titles_tb.title_id")+"&title="+rs.getString("titles_tb.title_name"));
      out.write('"');
      out.write('>');
      out.print(rs.getString("titles_tb.title_name"));
      out.write("</a></li>\n");
      out.write("            ");
 }
            st.close();
            rs.close();
} catch(Exception e){out.println("Error: "+e);}
            
      out.write("\n");
      out.write("    </ul>\n");
      out.write("    <!--<div class=\"add_new_title_div\">\n");
      out.write("        <a href=\"add_new_title.jsp\" class=\"list_item\"><img src=\"images/add_icon.png\" alt=\"ADD\" class=\"add_icon\" title=\"Add New\"></a>\n");
      out.write("    </div>-->\n");
      out.write("    </nav>\n");
      out.write("    <main id=\"main-doc\">\n");
      out.write("        <div class=\"table_div\">\n");
      out.write("            <div class=\"table_header capital\">Add a new Category</div>\n");
      out.write("            <div class=\"form_container_div center\">\n");
      out.write("                <form name=\"new_title_form\" action=\"add_new_title.jsp\" method=\"POST\">\n");
      out.write("                    <label for=\"category_name\">Category Name:</label>\n");
      out.write("                    <input type=\"text\" name=\"category_name\" id=\"category_name\" required=\"required\">\n");
      out.write("                    <div><input class=\"faq_btn list_item\" id=\"submit_btn\" type=\"submit\" value=\"Submit\" name=\"submit_title\"></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

            try{
                Connection c=(Connection)session.getAttribute("conn");
                String tn=request.getParameter("category_name");
                if(!(tn.equals(null)))
                {
                PreparedStatement st1=c.prepareStatement("insert into titles_tb(title_name) values('"+tn+"')");
                int r=st1.executeUpdate();
                if(r==1){
        
      out.write("\n");
      out.write("        <div>Successfully added.</div>\n");
      out.write("        ");

                }
else {
            
      out.write("\n");
      out.write("            <div>There was some problem. Please check your input and try again.</div>\n");
      out.write("        ");

            } }
}           catch(Exception e){ 
//out.println("Error: "+e);
}
        
      out.write("\n");
      out.write("    </main>\n");
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
