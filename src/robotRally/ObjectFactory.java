package robotRally;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the jaxb package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Map_QNAME = new QName("", "map");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MapType }
     */
    public MapType createMapType() {
        return new MapType();
    }

    /**
     * Create an instance of {@link LayerType }
     */
    public LayerType createLayerType() {
        return new LayerType();
    }

    /**
     * Create an instance of {@link PropertyType }
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link DataType }
     */
    public DataType createDataType() {
        return new DataType();
    }

    /**
     * Create an instance of {@link TilesetType }
     */
    public TilesetType createTilesetType() {
        return new TilesetType();
    }

    /**
     * Create an instance of {@link PropertiesType }
     */
    public PropertiesType createPropertiesType() {
        return new PropertiesType();
    }

    /**
     * Create an instance of {@link ObjectType }
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link ObjectgroupType }
     */
    public ObjectgroupType createObjectgroupType() {
        return new ObjectgroupType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MapType }{@code >}}
     */
    @XmlElementDecl(namespace = "", name = "map")
    public JAXBElement<MapType> createMap(MapType value) {
        return new JAXBElement<MapType>(_Map_QNAME, MapType.class, null, value);
    }

}
