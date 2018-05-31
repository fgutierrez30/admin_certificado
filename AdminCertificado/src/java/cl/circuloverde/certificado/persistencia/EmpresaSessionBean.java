
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.Empresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EmpresaSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    public List<Empresa> empresasVigentes()
    {
        return em.createNamedQuery("Empresa.findByEstadoEmp", Empresa.class).setParameter("estadoEmp",0).getResultList();
        
    
    }
    

      

    public Empresa empresaXRut(String rut)
    {
      return em.createNamedQuery("Empresa.findByRutEmpresa", Empresa.class).setParameter("rutEmpresa", rut).getSingleResult();
    }
   
    
    public List<Empresa> empresaXHolding (int id_holding)
    {
        List<Empresa> empresa=null;
        
        try{
            empresa=em.createNamedQuery("Empresa.findByHolding",Empresa.class).setParameter("id_holding", id_holding).getResultList();
            
        }catch(Exception ex)
        {
            return empresa;
        }
        
        return empresa;
    }
    
    
    public void actualizaEmpresa(Empresa emp)
    {
        em.merge(emp);
    }
    
    
    public void creaEmpresa(Empresa emp)
    {
        em.persist(emp);
    }

}
