
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.FirmaElectronica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FirmaSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    
    public List<FirmaElectronica> firmasXRut (String rut)
    {
        List<FirmaElectronica> firma=null;
        
        try{
            firma=em.createNamedQuery("FirmaElectronica.findByRut", FirmaElectronica.class).setParameter("rutRpt", rut).getResultList();
            
        }catch(Exception ex)
        {
           firma=null; 
        }
        
        return firma;
    }
    
    
    public void registraFirma(FirmaElectronica firma)
         {
             em.persist(firma);
         }
    
    
}
