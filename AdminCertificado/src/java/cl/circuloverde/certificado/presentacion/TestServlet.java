/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.PerfilSii;
import cl.circuloverde.certificado.entidades.UsrPerfilEmpresa;
import cl.circuloverde.certificado.entidades.UsuarioCv;
import cl.circuloverde.certificado.persistencia.EmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.PerfilSIISessionBean;
import cl.circuloverde.certificado.persistencia.UsrPerfilEmpresaSessionBean;
import cl.circuloverde.certificado.persistencia.UsuarioSessionBean;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet","/test"})
public class TestServlet extends HttpServlet {

  
    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;
    
    @EJB
    private EmpresaSessionBean objEmpresaSessionBean;
    
    @EJB
    private PerfilSIISessionBean objPerfilSIISessionBean;
    
    @EJB
    private UsrPerfilEmpresaSessionBean objUsrPerfilEmpresaSessionBean;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sesion=request.getSession();
        
        
        String rut_emp=request.getParameter("cmbEmpresa");
        String rut_usr=request.getParameter("idUsr");
        String autoriza=request.getParameter("cmbAutoriza");
        
        String adm=request.getParameter("chkAdm");
        String firmaDocto=request.getParameter("chkFD");
        String registros=request.getParameter("chkReg");
        String solicitaFolio=request.getParameter("chkSF");
        String anulaFolio=request.getParameter("chkAF");
        String enviaDocto=request.getParameter("chkED");
        String consulta=request.getParameter("chkConsult");
        
        
        if(adm!=null)
        {
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(adm));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
            
        }else if (firmaDocto!=null){
            
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(firmaDocto));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else if(registros!=null)
        {
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(registros));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else if(solicitaFolio!=null)
        {
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(solicitaFolio));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else if(anulaFolio!=null)
        {
            
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(anulaFolio));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else if(enviaDocto!=null)
        {
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(enviaDocto));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else if(consulta!=null)
        {
            UsrPerfilEmpresa asigna=new UsrPerfilEmpresa();
            UsuarioCv usr=this.objUsuarioSessionBean.usrXRut(rut_usr);
            Empresa emp=this.objEmpresaSessionBean.empresaXRut(rut_emp);
            PerfilSii perfil=this.objPerfilSIISessionBean.perfilXID(Integer.parseInt(consulta));
            
            asigna.setRutUsrCv(usr);
            asigna.setRutEmpresa(emp);
            asigna.setIdPerfil(perfil);
            asigna.setUsrSolicita(autoriza);
            Date date = new Date();
            asigna.setFechaSolicita(date);
            
            this.objUsrPerfilEmpresaSessionBean.asignaEmpresa(asigna);
            
        }else{
            
            String error="No se ha seleccionado ningun permiso";
            sesion.setAttribute("msj", error);
            
        }
        
        response.sendRedirect("DetUsr.jsp");
    }

    
   

}
