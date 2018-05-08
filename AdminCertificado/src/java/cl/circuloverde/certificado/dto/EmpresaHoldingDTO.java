
package cl.circuloverde.certificado.dto;

import cl.circuloverde.certificado.entidades.Empresa;
import cl.circuloverde.certificado.entidades.Holding;


public class EmpresaHoldingDTO {
    
    private Empresa empresa;
    private Holding holding;

    public EmpresaHoldingDTO() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Holding getHolding() {
        return holding;
    }

    public void setHolding(Holding holding) {
        this.holding = holding;
    }
    
    
    
}
