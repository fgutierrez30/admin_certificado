/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.Holding;
import cl.circuloverde.certificado.entidades.UsuarioCv;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.HoldingSessionBean;
import cl.circuloverde.certificado.persistencia.UsuarioSessionBean;
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
@WebServlet(name = "AsignaUsr", urlPatterns = {"/AsignaUsr","/asignaEmpresa"})
public class AsignaUsrServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;
    
    @EJB
    private HoldingSessionBean objHoldingSessionBean;
    
    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rutUsr=request.getParameter("rut_usr");
        
        
        List<Holding> holdings=this.objHoldingSessionBean.holdings();
        
        UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rutUsr);
        
        List<UsuarioCv>jefes=this.objUsuarioSessionBean.usrXCargo(3, 4);
        
        sesion.setAttribute("usrCV", usr);
        sesion.setAttribute("holding", holdings);
        sesion.setAttribute("autoriza", jefes);
        
        response.sendRedirect("asignaUsr.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        int id=Integer.parseInt(request.getParameter("id_holding"));
        
        List<Empresa> lempresa=this.objEmpresaSessionBean.empresaXHolding(id);
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<lempresa.size();i++)
        {
            sb.append(lempresa.get(i).getRutEmpresa()+ "_" +lempresa.get(i).getRazonSocial()+ ":");
            out.write(sb.toString());
        }
        
    }

     

}
