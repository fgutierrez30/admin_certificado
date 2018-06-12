
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.Holding;
import cl.circuloverde.certificado.entidades.PerfilSii;
import cl.circuloverde.certificado.entidades.RptLegal;
import cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.HoldingSessionBean;
import cl.circuloverde.certificado.persistencia.PerfilSIISessionBean;
import cl.circuloverde.certificado.persistencia.RptLegalSessionBean;
import cl.circuloverde.certificado.persistencia.RptPerfEmpSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AsignaRptServlet", urlPatterns = {"/AsignaRptServlet","/asigEmpRpt"})
public class AsignaRptServlet extends HttpServlet {

    @EJB
    private HoldingSessionBean objHoldingSessionBean;
    
    @EJB
    private RptLegalSessionBean objRptLegalSessionBean;
    
    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;
    
    @EJB
    private PerfilSIISessionBean objPerfilSIISessionBean;
    
    @EJB
    private RptPerfEmpSessionBean objRptPerfEmpSessionBean;
   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String rut_rpt=request.getParameter("rut_rpt");
        List<Holding> holdings=this.objHoldingSessionBean.holdings();
        RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
        
        sesion.setAttribute("rpt", rpt);
        sesion.setAttribute("holding", holdings);
        
        response.sendRedirect("asignaRpt.jsp");
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
                
        String rut_emp=request.getParameter("cmbEmpresa");
        String rut_rpt=request.getParameter("idRpt");
                
        String adm=request.getParameter("chkAdm");
        String firmaDocto=request.getParameter("chkFD");
        String registros=request.getParameter("chkReg");
        String solicitaFolio=request.getParameter("chkSF");
        String anulaFolio=request.getParameter("chkAF");
        String enviaDocto=request.getParameter("chkED");
        String consulta=request.getParameter("chkConsult");
        
        if(adm!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(adm));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(firmaDocto!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(firmaDocto));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(registros!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(registros));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(solicitaFolio!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(solicitaFolio));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(anulaFolio!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(anulaFolio));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(enviaDocto!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(enviaDocto));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(consulta!=null)
        {
            RptlegalPerfilEmpresa permiso=new RptlegalPerfilEmpresa();
            RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut_rpt);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(consulta));
            permiso.setIdPerfil(perfil);
            permiso.setRutEmpresa(emp);
            permiso.setRutRptLegal(rpt);
            this.objRptPerfEmpSessionBean.asignaEmpresa(permiso);
            
        }
        if(consulta==null && enviaDocto==null && anulaFolio==null && solicitaFolio==null && registros==null && firmaDocto==null && adm==null)
        {
            String error="No se ha seleccionado ningun permiso";
            sesion.setAttribute("msj", error);
        }
        
        response.sendRedirect("DetRptLegal.jsp");
       
    }

    
}
