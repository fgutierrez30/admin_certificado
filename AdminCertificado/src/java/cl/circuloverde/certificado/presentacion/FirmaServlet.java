/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.FirmaElectronica;
import cl.circuloverde.certificado.entidades.RptLegal;
import cl.circuloverde.certificado.persistencia.FirmaSessionBean;
import cl.circuloverde.certificado.persistencia.RptLegalSessionBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "FirmaServlet", urlPatterns = {"/FirmaServlet","/regFirma"})
public class FirmaServlet extends HttpServlet {

    @EJB
    private RptLegalSessionBean objRptLegalSessionBean;
   
    @EJB
    private FirmaSessionBean objFirmaSessionBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rut=request.getParameter("rut_rpt");
        RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut);
        sesion.setAttribute("rpt", rpt);
        response.sendRedirect("firma.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("idRpt");
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      try{  
        Date fcompra=sdf.parse(request.getParameter("txtfCompra"));
        Date fvcto=sdf.parse(request.getParameter("txtfVcto"));
        String clave=request.getParameter("txtClave");
        RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut);
        
        FirmaElectronica firma=new FirmaElectronica();
        firma.setFechaCompra(fcompra);
        firma.setFechaVcto(fvcto);
        firma.setClaveInstalacion(clave);
        firma.setRutRptLegal(rpt);
        
        this.objFirmaSessionBean.registraFirma(firma);
        
        
      }catch(Exception ex)
      {
          System.out.println(ex.getMessage());
      }
      
      response.sendRedirect("DetRptLegal.jsp");
    }

   
   
}
