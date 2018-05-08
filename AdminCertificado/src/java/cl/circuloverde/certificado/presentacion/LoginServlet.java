/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Login;
import cl.circuloverde.certificado.persistencia.LoginSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet","/login"})
public class LoginServlet extends HttpServlet {

    
  @EJB
  private LoginSessionBean objLoginSessionBean;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        
        String usr=request.getParameter("txtusr");
        String pass=request.getParameter("txtclave");
        Login valida=this.objLoginSessionBean.login(usr, pass);
        
        if(valida!=null && valida.getEstadoLogin()==1)
        {
            sesion.setAttribute("usrLogin", valida);
            response.sendRedirect("Home.jsp");
        }else
        {
            sesion.setAttribute("msgError", "Usuario o Clave Incorrecto");
            response.sendRedirect("Login.jsp");
        }
        
    }

   

}
