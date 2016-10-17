
package org.javaee7.chapter01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ReadListenerServlet"}, asyncSupported=true)
public class ReadListenerServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter output = response.getWriter()) {
            System.out.println("got response");
            output.println("<html>");
            output.println("<head>");
            output.println("<title>Servlet ReadTestServlet</title>");
            output.println("</head>");
            output.println("<body>");
            output.println("<h1>Servlet ReadTestServlet at " + request.getContextPath() + "</h1>");
            output.println("<br/>Please take a look at the server log to see messages...<br/>");

            AsyncContext context = request.startAsync();;
            ServletInputStream input = request.getInputStream();
            input.setReadListener(new ReadListenerImpl(input, context));


            
            output.println("</body>");
            output.println("</html>");
        } catch (Exception ex){
            System.out.println("Exception Occurred: " + ex);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
