/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.RptPerfEmpSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "DetEmpresaServlet", urlPatterns = {"/DetEmpresaServlet","/detEmpresa"})
public class DetEmpresaServlet extends HttpServlet {

    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;
    
    @EJB
    private RptPerfEmpSessionBean objRptPerfEmpSessionBean;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rut=request.getParameter("rut_emp");
        Empresa empresa=this.objEmpresaSessionBean.empresaXRut(rut);
        
        List<RptlegalPerfilEmpresa> rpt=this.objRptPerfEmpSessionBean.rptEmp(rut);
        if(rpt==null)
        {
            RptlegalPerfilEmpresa rptNull=new RptlegalPerfilEmpresa();
            rptNull.getRutRptLegal().setRutRptLegal("Sin Asignar");
            rptNull.getRutRptLegal().setNomRptLegal("Sin Asignar");
            rptNull.getRutRptLegal().setApellRptLegal("Sin Asignar");
            rptNull.getRutRptLegal().setCorreoRptLegal("Sin Asignar");
            rptNull.getRutRptLegal().setEstadoRptLegal(2);
            rptNull.getRutRptLegal().setFirmaElectronicaList(null);
            
            rpt.add(rptNull);
            sesion.setAttribute("rpt", rpt);
            sesion.setAttribute("empresa", empresa);
        }else
        {
        sesion.setAttribute("rpt", rpt);
        sesion.setAttribute("empresa", empresa);
        }
        response.sendRedirect("DetEmpresa.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
