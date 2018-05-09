
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
    
<<<<<<< HEAD
      
=======
    public Empresa empresaXRut(String rut)
    {
      return em.createNamedQuery("Empresa.findByRutEmpresa", Empresa.class).setParameter("rutEmpresa", rut).getSingleResult();
    }
   
>>>>>>> 62704c0b3ba89f0fe62bd6ae9f4541d134b81b2a
}
