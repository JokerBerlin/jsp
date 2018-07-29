/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Canchito
 */

//el ciclo de vida del servlet comienza cuando se llama la primera vez, pero no
//se crea nueva instancia cuando se crea una nueva solicitud
//por tanto servlets se crea una sola vez y con esa instancia se van llamando
//los metodos cuantas veces sea necesario pero de ese solo objeto

@WebServlet(name = "ServletSumar", urlPatterns = {"/ServletSumar"})
public class ServletSumar extends HttpServlet {

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
        String primer = request.getParameter("primer");
        String segundo = request.getParameter("segundo");
        
        int ipr, iseg, respuesta;
        
        try{
            ipr = Integer.parseInt(primer);
            iseg = Integer.parseInt(segundo);
        }catch(NumberFormatException nfe){
            ipr = 0;
            iseg = 0;
        }
        
        respuesta = ipr+iseg;
        int valor = factorial(ipr);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSumar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>La suma es: " +respuesta + "</h1>");
            out.println("<h1>Factorial es: " +valor + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public int factorial(int n){
        if(n>0){
            return n * factorial(n-1);
        }else if(n==0){
            return 1;
        }
        return n;
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
