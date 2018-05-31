
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.Holding;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.HoldingSessionBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "NuevaEmpresaServlet", urlPatterns = {"/NuevaEmpresaServlet","/nvaEmpresa"})
public class NuevaEmpresaServlet extends HttpServlet {

  
    @EJB
    private HoldingSessionBean objHoldingSessionBean;
    
    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<Holding> hdl=this.objHoldingSessionBean.holdings();
        sesion.setAttribute("holding", hdl);
        response.sendRedirect("NuevaEmpresa.jsp");
        
    }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("txtRut");
        String razonSocial=request.getParameter("txtRazonSocial");
        String maiContacto=request.getParameter("txtMailContacto");
        String mailSII=request.getParameter("txtMailSII");
        String mailAdm=request.getParameter("txtMailAdmin");
        int id_holding=Integer.parseInt(request.getParameter("cmbHolding"));
        Holding hdl=this.objHoldingSessionBean.hdlXID(id_holding);
        int estado=Integer.parseInt(request.getParameter("cmbEstado"));
        
        Empresa emp=new Empresa();
        
        emp.setRutEmpresa(rut);
        emp.setRazonSocial(razonSocial);
        emp.setMailContacto(maiContacto);
        emp.setMailSii(mailSII);
        emp.setMailAdm(mailAdm);
        emp.setIdHolding(hdl);
        emp.setEstadoEmp(estado);
        
        this.objEmpresaSessionBean.creaEmpresa(emp);
        
        response.sendRedirect("Home.jsp");
        
    }

 

}
