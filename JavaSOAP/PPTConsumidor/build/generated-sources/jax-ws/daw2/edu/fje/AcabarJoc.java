
package daw2.edu.fje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para acabarJoc complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acabarJoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acabarJoc", propOrder = {
    "codiP"
})
public class AcabarJoc {

    protected int codiP;

    /**
     * Obtiene el valor de la propiedad codiP.
     * 
     */
    public int getCodiP() {
        return codiP;
    }

    /**
     * Define el valor de la propiedad codiP.
     * 
     */
    public void setCodiP(int value) {
        this.codiP = value;
    }

}
