/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.RptLegal;
import cl.circuloverde.certificado.persistencia.RptLegalSessionBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fgutierrez
 */
@WebServlet(name = "NuevoRptServlet", urlPatterns = {"/NuevoRptServlet","/nvoRpt"})
public class NuevoRptServlet extends HttpServlet {

  @EJB
  private RptLegalSessionBean objRptLegalSessionBean;
  

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.sendRedirect("NuevoRpt.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("txtRut");
        String nombre=request.getParameter("txtNombre");
        String apellido=request.getParameter("txtApellido");
        String correo=request.getParameter("txtCorreo");
        int estado=Integer.parseInt(request.getParameter("cmbEstado"));
        
        RptLegal rpt=new RptLegal();
        rpt.setRutRptLegal(rut);
        rpt.setNomRptLegal(nombre);
        rpt.setApellRptLegal(apellido);
        rpt.setCorreoRptLegal(correo);
        rpt.setEstadoRptLegal(estado);
        
        this.objRptLegalSessionBean.crearRpt(rpt);
        
        response.sendRedirect("RepLegal.jsp");
        
    }

   
}
