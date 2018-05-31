/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.CargoUsr;
import cl.circuloverde.certificado.entidades.UsuarioCv;
import cl.circuloverde.certificado.persistencia.CargoSessionBean;
import cl.circuloverde.certificado.persistencia.UsuarioSessionBean;
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
@WebServlet(name = "EditaUsrServlet", urlPatterns = {"/EditaUsrServlet","/editaUsr"})
public class EditaUsrServlet extends HttpServlet {

   @EJB
   private UsuarioSessionBean objUsuarioSessionBean;
  
   @EJB
   private CargoSessionBean objCargoSessionBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        String rut=request.getParameter("rut_usr");
        UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut);
        List<CargoUsr> cargo=this.objCargoSessionBean.listarCargo();
        sesion.setAttribute("cargos", cargo);
        sesion.setAttribute("usuario", usr);
        response.sendRedirect("EditaUsr.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("rut_usr");
        int id_cargo=Integer.parseInt(request.getParameter("cmbCargo"));
        
        UsuarioCv usr=new UsuarioCv();
        usr.setRutUsrCv(rut);
        usr.setNomUsrCv(request.getParameter("txtNombre"));
        usr.setApellUsrCv(request.getParameter("txtApellido"));
        CargoUsr cargo=this.objCargoSessionBean.cargoXID(id_cargo);
        usr.setTipoUsrCv(cargo);
        usr.setEstadoUsrCv(Integer.parseInt(request.getParameter("cmbEstado")));
        this.objUsuarioSessionBean.actualizaUsr(usr);
        response.sendRedirect("DetUsr.jsp");
       
    }

   

}
