package robotRally;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for tilesetType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tilesetType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="firstgid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="source" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tilesetType", propOrder = {
        "value"
})
public class TilesetType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "firstgid")
    protected String firstgid;
    @XmlAttribute(name = "source")
    protected String source;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TilesetType{");
        sb.append("value='").append(value).append('\'');
        sb.append(", firstgid='").append(firstgid).append('\'');
        sb.append(", source='").append(source).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the firstgid property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstgid() {
        return firstgid;
    }

    /**
     * Sets the value of the firstgid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstgid(String value) {
        this.firstgid = value;
    }

    /**
     * Gets the value of the source property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSource(String value) {
        this.source = value;
    }

}
