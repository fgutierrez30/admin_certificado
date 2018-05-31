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
import javax.servlet.http.HttpSession;

/**
 *
 * @author fgutierrez
 */
@WebServlet(name = "EditaRptServlet", urlPatterns = {"/EditaRptServlet","/editaRpt"})
public class EditaRptServlet extends HttpServlet {

   @EJB
   private RptLegalSessionBean objRptLegalSessionBean;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String rut=request.getParameter("rut_rpt");
        RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut);
        sesion.setAttribute("rpt", rpt);
        response.sendRedirect("EditaRpt.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RptLegal rpt=new RptLegal();
        rpt.setRutRptLegal(request.getParameter("rut_rpt"));
        rpt.setNomRptLegal(request.getParameter("txtNombre"));
        rpt.setApellRptLegal(request.getParameter("txtApellido"));
        rpt.setCorreoRptLegal(request.getParameter("txtCorreo"));
        rpt.setEstadoRptLegal(Integer.parseInt(request.getParameter("cmbEstado")));
        
        this.objRptLegalSessionBean.actualizaRpt(rpt);
        
        response.sendRedirect("DetRptLegal.jsp");
       
    }

   
  

}
