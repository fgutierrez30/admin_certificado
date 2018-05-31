/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.RptLegal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class RptLegalSessionBean {

   
    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    
    
      public List<RptLegal> rptsLegal()
     {
         List<RptLegal> rpts=null;
         
         try{
             rpts=em.createNamedQuery("RptLegal.findAll", RptLegal.class).getResultList();
             
         }catch(Exception ex)
         {
             rpts=null;
         }
         
         return rpts;
     }
    
      
      public RptLegal rptxRut(String rut)
      {
          return em.createNamedQuery("RptLegal.findByRutRptLegal", RptLegal.class).setParameter("rutRptLegal", rut).getSingleResult();
      }
    
      
      public void actualizaRpt(RptLegal rpt)
      {
        RptLegal rptAct=em.find(RptLegal.class, rpt.getRutRptLegal());
        rptAct.setNomRptLegal(rpt.getNomRptLegal());
        rptAct.setApellRptLegal(rpt.getApellRptLegal());
        rptAct.setCorreoRptLegal(rpt.getCorreoRptLegal());
        rptAct.setEstadoRptLegal(rpt.getEstadoRptLegal());
        em.merge(rptAct);
      }
      
      
      public void crearRpt(RptLegal rpt)
      {
          em.persist(rpt);
      }
}
