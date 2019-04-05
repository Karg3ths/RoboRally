package robotRally;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propertiesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="propertiesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="property" type="{}propertyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propertiesType", propOrder = {
        "property"
})
public class PropertiesType {

    @XmlElement(required = true)
    protected PropertyType property;

    /**
     * Gets the value of the property property.
     *
     * @return possible object is
     * {@link PropertyType }
     */
    public PropertyType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     *
     * @param value allowed object is
     *              {@link PropertyType }
     */
    public void setProperty(PropertyType value) {
        this.property = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropertiesType{");
        sb.append("property=").append(property);
        sb.append('}');
        return sb.toString();
    }
}
