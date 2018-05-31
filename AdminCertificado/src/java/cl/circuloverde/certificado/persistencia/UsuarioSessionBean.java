
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.UsuarioCv;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UsuarioSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    
    public List<UsuarioCv> listarUsuarios()
    {
        List<UsuarioCv> users=em.createNamedQuery("UsuarioCv.findAll", UsuarioCv.class).getResultList();
        
        return users;
    }
    
    public UsuarioCv usrXRut (String rut_usr)
    {
        UsuarioCv usr=null;
        
        try{
            usr=em.createNamedQuery("UsuarioCv.findByRutUsrCv", UsuarioCv.class).setParameter("rutUsrCv", rut_usr).getSingleResult();
            
        }catch(Exception ex)
        {
            usr=null;
        }
        
        return usr;
    }
    
    public List<UsuarioCv> usrXCargo(int sup,int geren)
    {
        List<UsuarioCv> users=null;
        try{
           
            users=em.createNamedQuery("UsuarioCv.findByCargo", UsuarioCv.class).setParameter("super", sup).setParameter("geren", geren).getResultList();
        }catch(Exception ex)
        {
            users=null;
        }
        
        return users;
    }
    
    
    public void actualizaUsr(UsuarioCv usr)
    {
        em.merge(usr);
    }
    
    public void crearUsr(UsuarioCv usr)
    {
        em.persist(usr);
    }
    
}
