/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.presentacion;


import cl.circuloverde.certificado.entidades.RptLegal;
import cl.circuloverde.certificado.persistencia.RptLegalSessionBean;
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
 * @author dsantander
 */
@WebServlet(name = "RepresentanteServlet", urlPatterns = {"/RepresentanteServlet","/RepresentanteVigente"})
public class RepresentanteServlet extends HttpServlet {

    
  @EJB
  private RptLegalSessionBean objRptLegalSessionBean;
 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
                 HttpSession sesion=request.getSession();
                 List<RptLegal> rpts=this.objRptLegalSessionBean.rptsLegal();
                 sesion.setAttribute("rpts", rpts);
       
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

   
}
