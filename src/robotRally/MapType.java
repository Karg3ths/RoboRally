package robotRally;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for mapType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="mapType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="tileset" type="{}tilesetType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="layer" type="{}layerType"/>
 *         &lt;element name="objectgroup" type="{}objectgroupType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tiledversion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="renderorder" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tilewidth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tileheight" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="infinite" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nextlayerid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nextobjectid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mapType", propOrder = {
        "tilesetOrLayerOrObjectgroup"
})
public class MapType {

    @XmlElements({
            @XmlElement(name = "tileset", type = TilesetType.class),
            @XmlElement(name = "layer", type = LayerType.class),
            @XmlElement(name = "objectgroup", type = ObjectgroupType.class)
    })
    protected List<Object> tilesetOrLayerOrObjectgroup;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "tiledversion")
    protected String tiledversion;
    @XmlAttribute(name = "orientation")
    protected String orientation;
    @XmlAttribute(name = "renderorder")
    protected String renderorder;
    @XmlAttribute(name = "width")
    protected String width;
    @XmlAttribute(name = "height")
    protected String height;
    @XmlAttribute(name = "tilewidth")
    protected String tilewidth;
    @XmlAttribute(name = "tileheight")
    protected String tileheight;
    @XmlAttribute(name = "infinite")
    protected String infinite;
    @XmlAttribute(name = "nextlayerid")
    protected String nextlayerid;
    @XmlAttribute(name = "nextobjectid")
    protected String nextobjectid;

    /**
     * Gets the value of the tilesetOrLayerOrObjectgroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tilesetOrLayerOrObjectgroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTilesetOrLayerOrObjectgroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TilesetType }
     * {@link LayerType }
     * {@link ObjectgroupType }
     */
    public List<Object> getTilesetOrLayerOrObjectgroup() {
        if (tilesetOrLayerOrObjectgroup == null) {
            tilesetOrLayerOrObjectgroup = new ArrayList<Object>();
        }
        return this.tilesetOrLayerOrObjectgroup;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the tiledversion property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTiledversion() {
        return tiledversion;
    }

    /**
     * Sets the value of the tiledversion property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTiledversion(String value) {
        this.tiledversion = value;
    }

    /**
     * Gets the value of the orientation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOrientation(String value) {
        this.orientation = value;
    }

    /**
     * Gets the value of the renderorder property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRenderorder() {
        return renderorder;
    }

    /**
     * Sets the value of the renderorder property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRenderorder(String value) {
        this.renderorder = value;
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

    /**
     * Gets the value of the tilewidth property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTilewidth() {
        return tilewidth;
    }

    /**
     * Sets the value of the tilewidth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTilewidth(String value) {
        this.tilewidth = value;
    }

    /**
     * Gets the value of the tileheight property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTileheight() {
        return tileheight;
    }

    /**
     * Sets the value of the tileheight property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTileheight(String value) {
        this.tileheight = value;
    }

    /**
     * Gets the value of the infinite property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInfinite() {
        return infinite;
    }

    /**
     * Sets the value of the infinite property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInfinite(String value) {
        this.infinite = value;
    }

    /**
     * Gets the value of the nextlayerid property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNextlayerid() {
        return nextlayerid;
    }

    /**
     * Sets the value of the nextlayerid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNextlayerid(String value) {
        this.nextlayerid = value;
    }

    /**
     * Gets the value of the nextobjectid property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNextobjectid() {
        return nextobjectid;
    }

    /**
     * Sets the value of the nextobjectid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNextobjectid(String value) {
        this.nextobjectid = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MapType{");
        sb.append("tilesetOrLayerOrObjectgroup=").append(tilesetOrLayerOrObjectgroup);
        sb.append(", version='").append(version).append('\'');
        sb.append(", tiledversion='").append(tiledversion).append('\'');
        sb.append(", orientation='").append(orientation).append('\'');
        sb.append(", renderorder='").append(renderorder).append('\'');
        sb.append(", width='").append(width).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", tilewidth='").append(tilewidth).append('\'');
        sb.append(", tileheight='").append(tileheight).append('\'');
        sb.append(", infinite='").append(infinite).append('\'');
        sb.append(", nextlayerid='").append(nextlayerid).append('\'');
        sb.append(", nextobjectid='").append(nextobjectid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
