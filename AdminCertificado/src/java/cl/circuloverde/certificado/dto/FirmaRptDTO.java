
package cl.circuloverde.certificado.dto;

import cl.circuloverde.certificado.entidades.FirmaElectronica;
import cl.circuloverde.certificado.entidades.RptLegal;

/**
 *
 * @author fgutierrez
 */
public class FirmaRptDTO {
    
    private FirmaElectronica firma;
    private RptLegal rpt;

    public FirmaElectronica getFirma() {
        return firma;
    }

    public void setFirma(FirmaElectronica firma) {
        this.firma = firma;
    }

    public RptLegal getRpt() {
        return rpt;
    }

    public void setRpt(RptLegal rpt) {
        this.rpt = rpt;
    }
    
    
    
}
