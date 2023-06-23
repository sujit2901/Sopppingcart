package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("\n");
      out.write("        <title>Login Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"primary-alt\">\n");
      out.write("        ");

// Retrieve the session object
        Integer id = (Integer) session.getAttribute("Id");
        if (id != null) {
            response.sendRedirect("index.jsp");
        } 
            
        
// Use the value as needed
    
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${data}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <div class=\"u-center\">\n");
      out.write("                <div class=\"card mb-3 secondary\" style=\"max-width: 800px;\">\n");
      out.write("                    <div class=\"row g-0\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <img src=\"assets/images/login_img.jpg\"\n");
      out.write("                                 style=\"border-radius:20px;height:100%\" class=\"img-fluid\" alt=\"...\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 p-3\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h5 class=\"card-title\">USER LOGIN </h5>\n");
      out.write("                                <form action=\"UserLogin\" method=\"post\">\n");
      out.write("                                    <label for=\"exampleFormControlInput1\" class=\"form-label\"\n");
      out.write("                                           for=\"name\">Email:</label>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input class=\"form-control\" type=\"email\" id=\"useremail\" name=\"useremail\" required></asp:TextBox>\n");
      out.write("                                    <br>\n");
      out.write("                                    <label for=\"exampleFormControlInput1\" class=\"form-label\"\n");
      out.write("                                           for=\"name\">Password:</label>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input class=\"form-control\" type=\"password\" id=\"userpassword\" name=\"userpassword\"  required/>\n");
      out.write("                                    <br>\n");
      out.write("                                    <button id=\"userlogin\" type=\"submit\" class=\"btn primary px-3 py-2 w-100\" >Login</button>\n");
      out.write("                                    <br>\n");
      out.write("                                    <br>\n");
      out.write("                                    Don't have an account? <a class=\"t-decor\" href=\"Register.jsp\">Sign\n");
      out.write("                                        Up</a>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script\n");
      out.write("        src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n");
      out.write("    ></script>\n");
      out.write("\n");
      out.write("</html>\n");
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
