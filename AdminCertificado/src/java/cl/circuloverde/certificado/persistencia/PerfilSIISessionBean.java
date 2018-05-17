/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.PerfilSii;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class PerfilSIISessionBean {

   @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
   
   
   public PerfilSii perfilXID(int id)
   {
     return em.createNamedQuery("PerfilSii.findByIdPerfil", PerfilSii.class).setParameter("idPerfil", id).getSingleResult();
   }
   
}
