package robotRally;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for objectgroupType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="objectgroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="object" type="{}objectType" minOccurs="0"/>
 *         &lt;element name="properties" type="{}propertiesType" minOccurs="0"/>
 *         &lt;element name="data" type="{}dataType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="offsetx" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="offsety" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objectgroupType", propOrder = {
        "object",
        "properties",
        "data"
})
public class ObjectgroupType {

    protected ObjectType object;
    protected PropertiesType properties;
    protected DataType data;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "offsetx")
    protected String offsetx;
    @XmlAttribute(name = "offsety")
    protected String offsety;
    @XmlAttribute(name = "width")
    protected String width;
    @XmlAttribute(name = "height")
    protected String height;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjectgroupType{");
        sb.append("object=").append(object);
        sb.append(", properties=").append(properties);
        sb.append(", data=").append(data);
        sb.append(", id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", offsetx='").append(offsetx).append('\'');
        sb.append(", offsety='").append(offsety).append('\'');
        sb.append(", width='").append(width).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Gets the value of the object property.
     *
     * @return possible object is
     * {@link ObjectType }
     */
    public ObjectType getObject() {
        return object;
    }

    /**
     * Sets the value of the object property.
     *
     * @param value allowed object is
     *              {@link ObjectType }
     */
    public void setObject(ObjectType value) {
        this.object = value;
    }

    /**
     * Gets the value of the properties property.
     *
     * @return possible object is
     * {@link PropertiesType }
     */
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     *
     * @param value allowed object is
     *              {@link PropertiesType }
     */
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link DataType }
     */
    public DataType getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link DataType }
     */
    public void setData(DataType value) {
        this.data = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the offsetx property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOffsetx() {
        return offsetx;
    }

    /**
     * Sets the value of the offsetx property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOffsetx(String value) {
        this.offsetx = value;
    }

    /**
     * Gets the value of the offsety property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOffsety() {
        return offsety;
    }

    /**
     * Sets the value of the offsety property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOffsety(String value) {
        this.offsety = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHeight(String value) {
        this.height = value;
    }

}
