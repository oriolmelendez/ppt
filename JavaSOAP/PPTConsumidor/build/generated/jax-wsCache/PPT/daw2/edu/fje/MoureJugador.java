
package daw2.edu.fje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para moureJugador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="moureJugador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="jugador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipusMoviment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moureJugador", propOrder = {
    "codiP",
    "jugador",
    "tipusMoviment"
})
public class MoureJugador {

    protected int codiP;
    protected String jugador;
    protected String tipusMoviment;

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

    /**
     * Obtiene el valor de la propiedad jugador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJugador() {
        return jugador;
    }

    /**
     * Define el valor de la propiedad jugador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJugador(String value) {
        this.jugador = value;
    }

    /**
     * Obtiene el valor de la propiedad tipusMoviment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipusMoviment() {
        return tipusMoviment;
    }

    /**
     * Define el valor de la propiedad tipusMoviment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipusMoviment(String value) {
        this.tipusMoviment = value;
    }

}
