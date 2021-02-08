
package daw2.edu.fje;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the daw2.edu.fje package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarPunts_QNAME = new QName("http://fje.edu.daw2/", "ConsultarPunts");
    private final static QName _MoureJugadorResponse_QNAME = new QName("http://fje.edu.daw2/", "moureJugadorResponse");
    private final static QName _ConsultarPartides_QNAME = new QName("http://fje.edu.daw2/", "ConsultarPartides");
    private final static QName _AcabarJoc_QNAME = new QName("http://fje.edu.daw2/", "acabarJoc");
    private final static QName _ConsultarPartidesResponse_QNAME = new QName("http://fje.edu.daw2/", "ConsultarPartidesResponse");
    private final static QName _IniciarPartida_QNAME = new QName("http://fje.edu.daw2/", "iniciarPartida");
    private final static QName _ConsultarPuntsResponse_QNAME = new QName("http://fje.edu.daw2/", "ConsultarPuntsResponse");
    private final static QName _AcabarJocResponse_QNAME = new QName("http://fje.edu.daw2/", "acabarJocResponse");
    private final static QName _MoureJugador_QNAME = new QName("http://fje.edu.daw2/", "moureJugador");
    private final static QName _IniciarPartidaResponse_QNAME = new QName("http://fje.edu.daw2/", "iniciarPartidaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: daw2.edu.fje
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarPartidesResponse }
     * 
     */
    public ConsultarPartidesResponse createConsultarPartidesResponse() {
        return new ConsultarPartidesResponse();
    }

    /**
     * Create an instance of {@link IniciarPartida }
     * 
     */
    public IniciarPartida createIniciarPartida() {
        return new IniciarPartida();
    }

    /**
     * Create an instance of {@link ConsultarPuntsResponse }
     * 
     */
    public ConsultarPuntsResponse createConsultarPuntsResponse() {
        return new ConsultarPuntsResponse();
    }

    /**
     * Create an instance of {@link AcabarJocResponse }
     * 
     */
    public AcabarJocResponse createAcabarJocResponse() {
        return new AcabarJocResponse();
    }

    /**
     * Create an instance of {@link MoureJugador }
     * 
     */
    public MoureJugador createMoureJugador() {
        return new MoureJugador();
    }

    /**
     * Create an instance of {@link IniciarPartidaResponse }
     * 
     */
    public IniciarPartidaResponse createIniciarPartidaResponse() {
        return new IniciarPartidaResponse();
    }

    /**
     * Create an instance of {@link ConsultarPunts }
     * 
     */
    public ConsultarPunts createConsultarPunts() {
        return new ConsultarPunts();
    }

    /**
     * Create an instance of {@link MoureJugadorResponse }
     * 
     */
    public MoureJugadorResponse createMoureJugadorResponse() {
        return new MoureJugadorResponse();
    }

    /**
     * Create an instance of {@link ConsultarPartides }
     * 
     */
    public ConsultarPartides createConsultarPartides() {
        return new ConsultarPartides();
    }

    /**
     * Create an instance of {@link AcabarJoc }
     * 
     */
    public AcabarJoc createAcabarJoc() {
        return new AcabarJoc();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPunts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "ConsultarPunts")
    public JAXBElement<ConsultarPunts> createConsultarPunts(ConsultarPunts value) {
        return new JAXBElement<ConsultarPunts>(_ConsultarPunts_QNAME, ConsultarPunts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "moureJugadorResponse")
    public JAXBElement<MoureJugadorResponse> createMoureJugadorResponse(MoureJugadorResponse value) {
        return new JAXBElement<MoureJugadorResponse>(_MoureJugadorResponse_QNAME, MoureJugadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPartides }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "ConsultarPartides")
    public JAXBElement<ConsultarPartides> createConsultarPartides(ConsultarPartides value) {
        return new JAXBElement<ConsultarPartides>(_ConsultarPartides_QNAME, ConsultarPartides.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJoc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "acabarJoc")
    public JAXBElement<AcabarJoc> createAcabarJoc(AcabarJoc value) {
        return new JAXBElement<AcabarJoc>(_AcabarJoc_QNAME, AcabarJoc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPartidesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "ConsultarPartidesResponse")
    public JAXBElement<ConsultarPartidesResponse> createConsultarPartidesResponse(ConsultarPartidesResponse value) {
        return new JAXBElement<ConsultarPartidesResponse>(_ConsultarPartidesResponse_QNAME, ConsultarPartidesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarPartida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "iniciarPartida")
    public JAXBElement<IniciarPartida> createIniciarPartida(IniciarPartida value) {
        return new JAXBElement<IniciarPartida>(_IniciarPartida_QNAME, IniciarPartida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarPuntsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "ConsultarPuntsResponse")
    public JAXBElement<ConsultarPuntsResponse> createConsultarPuntsResponse(ConsultarPuntsResponse value) {
        return new JAXBElement<ConsultarPuntsResponse>(_ConsultarPuntsResponse_QNAME, ConsultarPuntsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AcabarJocResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "acabarJocResponse")
    public JAXBElement<AcabarJocResponse> createAcabarJocResponse(AcabarJocResponse value) {
        return new JAXBElement<AcabarJocResponse>(_AcabarJocResponse_QNAME, AcabarJocResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoureJugador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "moureJugador")
    public JAXBElement<MoureJugador> createMoureJugador(MoureJugador value) {
        return new JAXBElement<MoureJugador>(_MoureJugador_QNAME, MoureJugador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarPartidaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://fje.edu.daw2/", name = "iniciarPartidaResponse")
    public JAXBElement<IniciarPartidaResponse> createIniciarPartidaResponse(IniciarPartidaResponse value) {
        return new JAXBElement<IniciarPartidaResponse>(_IniciarPartidaResponse_QNAME, IniciarPartidaResponse.class, null, value);
    }

}
