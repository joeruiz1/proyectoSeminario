/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.CrudFactura;
import DAO.CrudLibro;
import VO.Factura;
import VO.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Manuel
 */
public class CrearFactura extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rq = request.getRequestDispatcher("insertarFactura.jsp");

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean resultado=false;

        String id = request.getParameter("id");
        String nombreLi = request.getParameter("nombreLi");
        String numEm = request.getParameter("numEm");
        String cliente = request.getParameter("nombre");

        int fac = Integer.parseInt(id);
        int em = Integer.parseInt(numEm);

        if (id.trim().length() != 0 && nombreLi.trim().length() != 0) {

            CrudFactura cr = new CrudFactura();
            CrudLibro cl = new CrudLibro();
            Libro li = new Libro();
            
            
            li=cl.extraerLibro(nombreLi);
            Factura f=new Factura(cliente, nombreLi, li.getId(), fac, li.getPrecio(), em);
            
            cr.facturar(f);
            
            RequestDispatcher rq = request.getRequestDispatcher("insertarFactura.jsp");

            if (resultado == true) {
                request.setAttribute("resultado", true);
            } else {
                request.setAttribute("resultado", false);
            }

            rq.forward(request, response);
       
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
