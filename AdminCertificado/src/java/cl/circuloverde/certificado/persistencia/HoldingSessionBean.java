/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.Holding;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class HoldingSessionBean {

   @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
   
   
   public List<Holding> holdings()
   {
       
       List<Holding> holdings=null;
       
       try{
           
           holdings=em.createNamedQuery("Holding.findAll", Holding.class).getResultList();
           
       }catch(Exception ex)
       {
          holdings=null; 
       }
       
       return holdings;
   }
   
   
}
