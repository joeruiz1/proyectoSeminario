/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CrudLibro;
import DAO.Online;
import VO.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Manuel
 */
public class ComprasOnline extends HttpServlet {

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
            throws ServletException, IOException, URISyntaxException {
        response.setContentType("text/html;charset=UTF-8");
        
          try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rq = request.getRequestDispatcher("online.jsp");

            Online cru = new Online();

            ArrayList<VO.ComprasOnline> com = null;
            com = (ArrayList<VO.ComprasOnline>) cru.mostarFacturas();
            if (com.size() > 0) {

                request.setAttribute("com", com);
            } else {
                request.setAttribute("com", null);
            }
            rq.forward(request, response);
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
          try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rq = request.getRequestDispatcher("online.jsp");

            CrudLibro cru = new CrudLibro();

            ArrayList<Libro> lis = null;
            lis = (ArrayList<Libro>) cru.listarLibros();
            if (lis.size() > 0) {

                request.setAttribute("lis", lis);
            } else {
                request.setAttribute("lis", null);
            }
            rq.forward(request, response);
        }

        
        
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
       boolean resultado = false;
        
        String idc=request.getParameter("id");
        String libro=request.getParameter("nombreLi");
        String nombreCliente=request.getParameter("cliente");
        String dir=request.getParameter("dir");
        String tel=request.getParameter("tele");
        String tarjeta=request.getParameter("tar");
        
        int id=Integer.parseInt(idc);
        int telefono=Integer.parseInt(tel);
        int tar=Integer.parseInt(tarjeta);
        
           if (libro.trim().length() != 0 && nombreCliente.trim().length() != 0) {

           try {
               Online cd=new Online();
               CrudLibro cl = new CrudLibro();
               Libro li = new Libro();
               
               li = cl.extraerLibro(libro);
               VO.ComprasOnline d = new VO.ComprasOnline(nombreCliente, libro, li.getId(), id, li.getPrecio(), tar, telefono, dir);
               
               cd.facturar(d);
               
               RequestDispatcher rq = request.getRequestDispatcher("InsertarDeseos.jsp");
               
               if (resultado == true) {
                   request.setAttribute("resultado", true);
               } else {
                   request.setAttribute("resultado", false);
               }
               
               rq.forward(request, response);
           } catch (URISyntaxException ex) {
               Logger.getLogger(ComprasOnline.class.getName()).log(Level.SEVERE, null, ex);
           }

        }
        

        
        
        
        
        
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
