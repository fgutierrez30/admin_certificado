/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.Login;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fgutierrez
 */
@Stateless
public class LoginSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    public Login login(String usr,String clave)
    {
        int log=0;
        Login login=new Login();
        
        try{
        login=em.createNamedQuery("Login.findByUsrClave", Login.class).setParameter("usr", usr).setParameter("clave", clave).getSingleResult();
        }catch(Exception ex){
            login=null;
        }
        
                
        
        return login;
    }
    
    
    
}
