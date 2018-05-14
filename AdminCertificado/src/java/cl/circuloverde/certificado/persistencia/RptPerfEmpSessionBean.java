/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.persistencia;

import cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.weld.util.collections.ListView;

/**
 *
 * @author dsantander
 */
@Stateless
public class RptPerfEmpSessionBean {

    @PersistenceContext(name = "AdminCertificadoPU")
    
    private EntityManager em;
    
    public List<RptlegalPerfilEmpresa> rptEmp(String rutEmpresa)
    {
        List<RptlegalPerfilEmpresa> rpt= null;
    try{    
    rpt=em.createNamedQuery("RptlegalPerfilEmpresa.rptXemp", RptlegalPerfilEmpresa.class).setParameter("rutEmp", rutEmpresa).getResultList();
     }catch(Exception ex){
     rpt=null;
    }  
    return rpt;
    }
    
    
     public List<RptlegalPerfilEmpresa> acceso(String rutEmpresa)
    {
       List<RptlegalPerfilEmpresa> rpt= null;
    try{    
    rpt=em.createNamedQuery("RptlegalPerfilEmpresa.permisos", RptlegalPerfilEmpresa.class).setParameter("rutEmp", rutEmpresa).getResultList();
     }catch(Exception ex){
     rpt=null;
    }  
    return rpt;
    }
    
    
}
