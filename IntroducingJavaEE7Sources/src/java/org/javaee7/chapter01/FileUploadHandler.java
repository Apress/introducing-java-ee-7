/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.chapter01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Example of upload handler
 * @author Juneau
 */
@MultipartConfig
@WebServlet(name = "FileUploadHandler", urlPatterns = {"/uploadFile"})
public class FileUploadHandler extends HttpServlet {

    private final static Logger LOGGER = 
            Logger.getLogger(FileUploadHandler.class.getCanonicalName());


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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
                                           HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        final String filepath = request.getParameter("destination");
        final Part filePart = request.getPart("myfile");
        final String fileName = getFileName(filePart);

        
        final PrintWriter writer = response.getWriter();

        try(
            OutputStream out = new FileOutputStream(new File(filepath + File.separator + fileName));
            InputStream filecontent = filePart.getInputStream()){


            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + filepath);
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    new Object[]{fileName, filepath});
            out.flush();

        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are " +
                   "trying to upload a file to a protected or nonexistent location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                    new Object[]{fne.getMessage()});
        } finally {
            
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    /**
     * This method demonstrates an example for obtaining form data when a servlet
     * is not marked for multipart/form-data
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void processRequestNoMultipart(HttpServletRequest request, 
                                           HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        final String filepath = request.getParameter("destination");
        final String path = request.getServletPath();
        final String fileName = getFileName(path, request);
        final PrintWriter writer = response.getWriter();

        try(
            
            InputStream filecontent = request.getInputStream();
            OutputStream out = new FileOutputStream(new File(filepath + File.separator + request.getLocalName()))){
            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + filepath);
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                    new Object[]{fileName, filepath});
            out.flush();

        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are " +
                   "trying to upload a file to a protected or nonexistent location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
                    new Object[]{fne.getMessage()});
        } finally {
            
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    private String getFileName(final String path, HttpServletRequest req){
        String name;
        if (path.length() > 0 && path.charAt(0) == '/'){
            name = path.substring(1);
        } else {
            name = path;
        }
        
        name.replace('/', File.pathSeparatorChar);
        return req.getServletContext().getRealPath(name);
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
