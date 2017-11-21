package Controladores;

import DAO.CrudDeseos;
import DAO.CrudFactura;
import DAO.CrudLibro;
import VO.Deseos;
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
 * @author Alejandro
 */
public class CrearDeseos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rq = request.getRequestDispatcher("insertarDeseos.jsp");

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

        boolean resultado = false;

        String id_deseo = request.getParameter("id_deseo");
        String nombre_libro = request.getParameter("nombre_libro");

        int idDes = Integer.parseInt(id_deseo);

        if (id_deseo.trim().length() != 0 && nombre_libro.trim().length() != 0) {

            CrudDeseos cd = new CrudDeseos();
            CrudLibro cl = new CrudLibro();
            Libro li = new Libro();

            li = cl.extraerLibro(nombre_libro);
            Deseos d = new Deseos(idDes, li.getId(), nombre_libro, li.getPrecio());

            cd.deseos(d);

            RequestDispatcher rq = request.getRequestDispatcher("insertarDeseos.jsp");

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
