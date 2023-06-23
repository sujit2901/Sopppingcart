package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import javax.servlet.http.HttpSession;
import Dao.CartDao;
import model.CartProduct;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Loc-Off-Mall</title>   \n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    \n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" >\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\"/>\n");
      out.write("    \n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar secondary-alt p-4 navbar-expand-lg bg-body-tertiary\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\"><img src=\"assets/images/logo.PNG\" style=\"width:5rem;\"/></a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse px-5\" id=\"navbarSupportedContent\">\n");
      out.write("          <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("            <li class=\"nav-item mx-2\">\n");
      out.write("              <a class=\"nav-link active px-4 py-2\" aria-current=\"page\" href=\"index.jsp\">Home</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item mx-2\">\n");
      out.write("              <a class=\"nav-link px-4 py-2\" href=\"#\">Shop By Category</a>\n");
      out.write("            </li>\n");
      out.write("              <li class=\"nav-item mx-2\">\n");
      out.write("              <a class=\"nav-link px-4 py-2\" href=\"Orders.jsp\">My Orders</a>\n");
      out.write("            </li>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("          <div class=\"d-flex\" role=\"search\">\n");
      out.write("            \n");
      out.write("              <a href=\"cart.jsp\" class=\"t-decor\"><button class=\"btn btn-outline-success bg-light secondary-alt p-3\" type=\"submit\" style=\"background-color:#fff!important;border-radius:50%;border:1px solid #ec406c;\"><i class=\"fa-solid fa-cart-shopping fa-bounce fa-xl\" style=\"color:#ec406c;background-color:#fff;\" ></i></button></a> &nbsp;&nbsp;\n");
      out.write("              &nbsp;&nbsp;\n");
      out.write("             <a href=\"Profile.jsp\" class=\"t-decor\"><button class=\"btn btn-outline-success bg-light secondary-alt p-3\" style=\"background-color:#fff!important;border-radius:50%;border:1px solid #ec406c;\"><i class=\"fa-solid fa-user fa-flip fa-xl\" style=\"color:#ec406c;background-color:#fff;\" ></i></button></a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("    \n");
      out.write('\n');

    // Retrieve the session object

    Integer id = (Integer) session.getAttribute("Id");
    if (id == null) {
        response.sendRedirect("Login.jsp");
    } else {

        // Use the value as needed
    }

      out.write("\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-3\"></div>\n");
      out.write("        <div class=\"col-sm-6 py-3\">\n");
      out.write("            <div class=\"card mb-3 secondary\">\n");
      out.write("                <h3 class=\"card-title text-center py-3\"> Your Cart</h3>\n");
      out.write("                ");

                    // Create an instance of ProductDAO
                   
                    CartDao cartDAO = new CartDao(session);

                    // Retrieve all products
                    List<CartProduct> products = cartDAO.getAllProducts();
                    int total=0;
                
      out.write("\n");
      out.write("                 ");
 for (CartProduct product : products) {
                     total+=(product.getQuantity()*product.getPrice());
                 
      out.write("\n");
      out.write("                <div class=\"c-center\">\n");
      out.write("                    <div class=\"card mb-3 p-2\" style=\"width: 540px;\">\n");
      out.write("                        <div class=\"row g-0\">\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <img src=\"");
      out.print( product.getImage());
      out.write("\" class=\"img-fluid rounded-start\" style=\"width:10rem;\" alt=\"...\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-8\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h5 class=\"card-title\">");
      out.print( product.getName());
      out.write("</h5>\n");
      out.write("                                    <p class=\"card-text\">Price:  ");
      out.print( product.getPrice());
      out.write("\n");
      out.write("                                        <br />\n");
      out.write("                                        Quantity :\n");
      out.write("                                        <a href=\"UpdateCart?incre=false&quant=");
      out.print( product.getQuantity());
      out.write("&id=");
      out.print( product.getId());
      out.write("\" class=\"t-decor\">\n");
      out.write("                                           <i class=\"fa-solid fa-minus\" style=\"color:#ff5a4c;\"></i>\n");
      out.write("                                        </a>\n");
      out.write("                                        <input class=\"p-1 text-center\" style=\"width:40px!important\" type=\"number\" aria-disabled=\"true\" value=\"");
      out.print( product.getQuantity());
      out.write("\"/> \n");
      out.write("                                        <a href=\"UpdateCart?incre=true&quant=");
      out.print( product.getQuantity());
      out.write("&id=");
      out.print( product.getId());
      out.write("\" class=\"t-decor\"><i class=\"fa-solid fa-plus\" style=\"color:#ff5a4c;\"></i></a></p>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\"> \n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h3 class=\"card-title text-center py-3\"> Total Cart Value:</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\"></div>\n");
      out.write("                    <div class=\"col-sm-4\">\n");
      out.write("                        <h3 Id=\"totalsum\" runat=\"server\" class=\"card-title primary text-center py-3\"> &#x20b9;");
      out.print( total);
      out.write("</h3>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\"> \n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6 py-3\">\n");
      out.write("                        <button class=\"btn primary px-3 py-3 w-100\">\n");
      out.write("                            <b class=\"text-light\"><a href=\"PlaceOrder\" class=\"t-decor\" style=\"color:#fff\">CheckOut The Cart </a><i class=\"fa-solid fa-cart-shopping fa-xl\" style=\"color:#fff;\"></i> </b>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<footer>\n");
      out.write("    Designed and Developed By KJSIM\n");
      out.write("</footer>\n");
      out.write("    </body>\n");
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
