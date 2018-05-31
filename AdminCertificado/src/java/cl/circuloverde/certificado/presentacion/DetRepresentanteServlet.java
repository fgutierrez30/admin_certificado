
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.FirmaElectronica;
import cl.circuloverde.certificado.entidades.RptLegal;
import cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa;
import cl.circuloverde.certificado.persistencia.FirmaSessionBean;
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


@WebServlet(name = "DetRepresentanteServlet", urlPatterns = {"/DetRepresentanteServlet","/detRepresentante"})
public class DetRepresentanteServlet extends HttpServlet {

    
    @EJB
    private RptLegalSessionBean objRptLegalSessionBean;
    
    @EJB
    private RptPerfEmpSessionBean objRptPerfEmpSessionBean;
    
    @EJB
    private FirmaSessionBean objFirmaSessionBean;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String rut=request.getParameter("rut_rpt");
        
        RptLegal rpt=this.objRptLegalSessionBean.rptxRut(rut);
        List<RptlegalPerfilEmpresa> empXRpt=this.objRptPerfEmpSessionBean.empRpt(rut);
        List<RptlegalPerfilEmpresa> permisos=this.objRptPerfEmpSessionBean.empRptPermisos(rut);
        List<FirmaElectronica>firma=this.objFirmaSessionBean.firmasXRut(rut);
        
        sesion.setAttribute("firma", firma);
        sesion.setAttribute("permisos", permisos);
        sesion.setAttribute("empXRpt", empXRpt);
        sesion.setAttribute("rpt", rpt);
        response.sendRedirect("DetRptLegal.jsp");
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
