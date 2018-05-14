/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa;
import cl.circuloverde.certificado.entidades.UsrPerfilEmpresa;
import cl.circuloverde.certificado.entidades.UsuarioCv;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.RptPerfEmpSessionBean;
import cl.circuloverde.certificado.persistencia.UsrPerfilEmpresaSessionBean;
import java.io.IOException;
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
    
    @EJB
    private UsrPerfilEmpresaSessionBean objUsrPerfilEmpresaSessionBean;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rut=request.getParameter("rut_emp");
        Empresa empresa=this.objEmpresaSessionBean.empresaXRut(rut);
        
        List<RptlegalPerfilEmpresa> rpt=this.objRptPerfEmpSessionBean.rptEmp(rut);
        List<RptlegalPerfilEmpresa> permisos=this.objRptPerfEmpSessionBean.acceso(rut);
        List<UsrPerfilEmpresa> usr=this.objUsrPerfilEmpresaSessionBean.usrEmp(rut);
        List<UsrPerfilEmpresa> usrPermisos=this.objUsrPerfilEmpresaSessionBean.usrPermisos(rut);
        
        
        
        if(rpt.isEmpty())
        {
            UsuarioCv usrNull=new UsuarioCv();
            usrNull.setNomUsrCv("");
            UsrPerfilEmpresa op=new UsrPerfilEmpresa();
            op.setRutUsrCv(usrNull);
            usr.add(op);
            usrPermisos.add(op);
            sesion.setAttribute("usrPermisos", usrPermisos);  
            sesion.setAttribute("usr", usr);
            
            
            RptlegalPerfilEmpresa rptNull=new RptlegalPerfilEmpresa();
                        
            rptNull.setEstadoAsigna(2);
            rpt.add(rptNull);
            sesion.setAttribute("rpt", rpt);
            sesion.setAttribute("empresa", empresa);
        }else if(usr.isEmpty())
        {   UsuarioCv usrNull=new UsuarioCv();
            usrNull.setNomUsrCv("Sin Asignar");
            UsrPerfilEmpresa op=new UsrPerfilEmpresa();
            op.setRutUsrCv(usrNull);
            usr.add(op);
            usrPermisos.add(op);
            sesion.setAttribute("rpt", rpt);
            sesion.setAttribute("empresa", empresa);
            sesion.setAttribute("usrPermisos", usrPermisos);  
            sesion.setAttribute("usr", usr);
        }else{
            sesion.setAttribute("usrPermisos", usrPermisos);  
            sesion.setAttribute("usr", usr);
            sesion.setAttribute("permisos", permisos);
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
