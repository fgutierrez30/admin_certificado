/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author fgutierrez
 */
@WebServlet(name = "EditaEmpresaServlet", urlPatterns = {"/EditaEmpresaServlet","/editaEmp"})
public class EditaEmpresaServlet extends HttpServlet {

    
    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;
    
    @EJB
    private HoldingSessionBean objHoldingSessionBean;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rut=request.getParameter("rut_emp");
        Empresa empresa=this.objEmpresaSessionBean.empresaXRut(rut);
        List<Holding> holding=this.objHoldingSessionBean.holdings();
        sesion.setAttribute("hdl", holding);
        sesion.setAttribute("emp", empresa);
        response.sendRedirect("EditaEmp.jsp");
                
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("rut_emp");
        int idHolding=Integer.parseInt(request.getParameter("cmbHolding"));
        Empresa emp= new Empresa();
        emp.setRutEmpresa(rut);
        emp.setRazonSocial(request.getParameter("txtRazonSocial"));
        emp.setEstadoEmp(Integer.parseInt(request.getParameter("cmbEstado")));
        emp.setMailContacto(request.getParameter("txtMailContacto"));
        emp.setMailSii(request.getParameter("txtMailSII"));
        emp.setMailAdm(request.getParameter("txtMailAdm"));
        Holding holding=this.objHoldingSessionBean.hdlXID(idHolding);
        emp.setIdHolding(holding);
        
        this.objEmpresaSessionBean.actualizaEmpresa(emp);
        
        response.sendRedirect("DetEmpresa.jsp");
        
        
        
    }

    

}
