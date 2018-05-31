/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Holding;
import cl.circuloverde.certificado.persistencia.HoldingSessionBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HoldingServlet", urlPatterns = {"/HoldingServlet","/hdlServlet"})
public class HoldingServlet extends HttpServlet {

    
    @EJB
    private HoldingSessionBean objHoldingSessionBean;
    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("Holding.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre=request.getParameter("txtNombre");
        Holding hdl=new Holding();
        
        hdl.setNomHolding(nombre);
        this.objHoldingSessionBean.crearHolding(hdl);
        
        response.sendRedirect("Home.jsp");
        
    }

   

}
