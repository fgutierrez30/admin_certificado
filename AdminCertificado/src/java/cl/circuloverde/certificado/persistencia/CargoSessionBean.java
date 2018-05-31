/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.CargoUsr;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CargoSessionBean {

   @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
   
   public List<CargoUsr>listarCargo()
   {
       return em.createNamedQuery("CargoUsr.findAll", CargoUsr.class).getResultList();
   }
   
   
   public CargoUsr cargoXID(int id)
   {
       return em.createNamedQuery("CargoUsr.findByIdCargoUsr", CargoUsr.class).setParameter("idCargoUsr", id).getSingleResult();
   }
}
