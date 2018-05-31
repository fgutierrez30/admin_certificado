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
     
     
   
     
     public List<RptlegalPerfilEmpresa> empRpt(String rutRpt)
    {
        List<RptlegalPerfilEmpresa> rpt= null;
    try{    
    rpt=em.createNamedQuery("RptlegalPerfilEmpresa.empXrpt", RptlegalPerfilEmpresa.class).setParameter("rutRpt", rutRpt).getResultList();
     }catch(Exception ex){
     rpt=null;
    }  
    return rpt;
    }
     
     
     
       public List<RptlegalPerfilEmpresa> empRptPermisos(String rutRpt)
    {
        List<RptlegalPerfilEmpresa> rpt= null;
    try{    
    rpt=em.createNamedQuery("RptlegalPerfilEmpresa.empXrptPermisos", RptlegalPerfilEmpresa.class).setParameter("rutRpt", rutRpt).getResultList();
     }catch(Exception ex){
     rpt=null;
    }  
    return rpt;
    }
     
     
     public void asignaEmpresa(RptlegalPerfilEmpresa permiso)
         {
             em.persist(permiso);
         }
   
    
    
}
