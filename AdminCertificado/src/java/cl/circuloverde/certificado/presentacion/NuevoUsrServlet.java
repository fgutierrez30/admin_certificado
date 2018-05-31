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


@WebServlet(name = "NuevoUsrServlet", urlPatterns = {"/NuevoUsrServlet","/nvoUsr"})
public class NuevoUsrServlet extends HttpServlet {

    @EJB
    private CargoSessionBean objCargoSessionBean;
    
    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion=request.getSession();
        List<CargoUsr> cargos=this.objCargoSessionBean.listarCargo();
        sesion.setAttribute("cargo", cargos);
        response.sendRedirect("NuevoUsr.jsp");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rut=request.getParameter("txtRut");
        String nombre=request.getParameter("txtNombre");
        String apellido=request.getParameter("txtApellido");
        int id_cargo=Integer.parseInt(request.getParameter("cmbCargo"));
        CargoUsr cargo=this.objCargoSessionBean.cargoXID(id_cargo);
        int estado=Integer.parseInt(request.getParameter("cmbEstado"));
        
        UsuarioCv usr=new UsuarioCv();
        usr.setRutUsrCv(rut);
        usr.setNomUsrCv(nombre);
        usr.setApellUsrCv(apellido);
        usr.setTipoUsrCv(cargo);
        usr.setEstadoUsrCv(estado);
        
        this.objUsuarioSessionBean.crearUsr(usr);
        response.sendRedirect("Usuarios.jsp");
    }

   

}
