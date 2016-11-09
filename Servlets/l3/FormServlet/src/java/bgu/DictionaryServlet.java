/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bgu;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aliaksei_Habruseu
 */
@WebServlet(name = "DictionaryServlet", urlPatterns = {"/DictionaryServlet"})
public class DictionaryServlet extends HttpServlet {
    
    TranslateServise service = new TranslateServise();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            boolean result = service.addWord(request.getParameter("txt"), request.getParameter("trans"));
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DictionaryServlet</title>");            
            out.println("</head>");
            out.println("<body>");            
            out.println("<h2 style='color: green'>Word was added "+((result) ? "succesfully" : "unsuccesfully")+"</h2>");
            out.println("<h3>Word " + request.getParameter("txt")+ " was added to database!</h3> All words: " + service.getAllWords(true).size());
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex) {
            System.out.println("Error - " + ex.getMessage());
            this.performOutput(response, ex.getMessage());
        }
    }
    
    protected void performOutput(HttpServletResponse response, String body) {
        try (PrintWriter out = response.getWriter()) {                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DictionaryServlet</title>");            
            out.println("</head>");
            out.println("<body>");        
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex) {
            System.out.println("Error - " + ex.getMessage());          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
