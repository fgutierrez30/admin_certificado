
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.UsrPerfilEmpresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class UsrPerfilEmpresaSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    
    public List<UsrPerfilEmpresa> usrEmp(String rut)
    {
        List<UsrPerfilEmpresa> usr=null;
        try{
          usr=em.createNamedQuery("UsrPerfilEmpresa.findUSRxEmp", UsrPerfilEmpresa.class).setParameter("rutEmp", rut).getResultList();  
        }catch(Exception ex)
        {
            usr=null;
        }
        return usr;
    }
    
      public List<UsrPerfilEmpresa> usrPermisos(String rut)
    {
        List<UsrPerfilEmpresa> usr=null;
        try{
          usr=em.createNamedQuery("UsrPerfilEmpresa.findUSRxEmpPer", UsrPerfilEmpresa.class).setParameter("rutEmp", rut).getResultList();  
        }catch(Exception ex)
        {
            usr=null;
        }
        return usr;
    }
      
      
      public List<UsrPerfilEmpresa> usrEmpresas(String rutUsr)
      {
          List<UsrPerfilEmpresa> usrEmpresa=null;
          try{
          usrEmpresa=em.createNamedQuery("UsrPerfilEmpresa.findEmpxUsr", UsrPerfilEmpresa.class).setParameter("rutUsr", rutUsr).getResultList();
          }catch(Exception ex)
          {
              usrEmpresa=null;
          }
          
          return usrEmpresa;
      }
      
      
      
         public List<UsrPerfilEmpresa> empPermisos(String rut_usr)
    {
        List<UsrPerfilEmpresa> usr=null;
        try{
          usr=em.createNamedQuery("UsrPerfilEmpresa.findEmpxUsrPer", UsrPerfilEmpresa.class).setParameter("rutUsr", rut_usr).getResultList();  
        }catch(Exception ex)
        {
            usr=null;
        }
        return usr;
    }
         
         
         public void asignaEmpresa(UsrPerfilEmpresa permiso)
         {
             em.persist(permiso);
         }
}
