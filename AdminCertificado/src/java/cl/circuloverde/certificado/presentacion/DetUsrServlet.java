/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.UsrPerfilEmpresa;
import cl.circuloverde.certificado.entidades.UsuarioCv;
import cl.circuloverde.certificado.persistencia.UsrPerfilEmpresaSessionBean;
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
@WebServlet(name = "DetUsrServlet", urlPatterns = {"/DetUsrServlet","/detUsr"})
public class DetUsrServlet extends HttpServlet {
    
    @EJB
    private UsrPerfilEmpresaSessionBean objUsrPerfilEmpresaSessionBean;
    
    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rutUsr=request.getParameter("rut_usr");
        List<UsrPerfilEmpresa>detUsr=this.objUsrPerfilEmpresaSessionBean.usrEmpresas(rutUsr);
        List<UsrPerfilEmpresa>permisos=this.objUsrPerfilEmpresaSessionBean.empPermisos(rutUsr);
        UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rutUsr);
        
        
        sesion.setAttribute("empresasUsr", detUsr);
        sesion.setAttribute("empPermisos", permisos);
        sesion.setAttribute("usuario", usr);
       response.sendRedirect("DetUsr.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }

   

}
