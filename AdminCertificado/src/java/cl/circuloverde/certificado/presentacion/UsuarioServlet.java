/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.UsuarioCv;
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


@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet","/usrServlet"})
public class UsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;
  

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        List<UsuarioCv> users=this.objUsuarioSessionBean.listarUsuarios();
        sesion.setAttribute("usuariosCV", users);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
 

}
