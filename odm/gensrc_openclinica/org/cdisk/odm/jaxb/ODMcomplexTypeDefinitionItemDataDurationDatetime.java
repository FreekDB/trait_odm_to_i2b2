//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 02:44:20 PM CEST 
//


package org.cdisk.odm.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for ODMcomplexTypeDefinition-ItemDataDurationDatetime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ODMcomplexTypeDefinition-ItemDataDurationDatetime">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.cdisc.org/ns/odm/v1.3>durationDatetime">
 *       &lt;attGroup ref="{http://www.cdisc.org/ns/odm/v1.3}ItemDataAttributeSharedDefinition"/>
 *       &lt;attGroup ref="{http://www.cdisc.org/ns/odm/v1.3}ItemDataStarAttributeExtension"/>
 *       &lt;attGroup ref="{http://www.cdisc.org/ns/odm/v1.3}ItemDataStarAttributeDefinition"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ODMcomplexTypeDefinition-ItemDataDurationDatetime", propOrder = {
    "value"
})
public class ODMcomplexTypeDefinitionItemDataDurationDatetime {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "ItemOID", required = true)
    protected String itemOID;
    @XmlAttribute(name = "TransactionType")
    protected TransactionType transactionType;
    @XmlAttribute(name = "IsNull")
    protected YesOnly isNull;
    @XmlAttribute(name = "AuditRecordID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object auditRecordID;
    @XmlAttribute(name = "SignatureID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object signatureID;
    @XmlAttribute(name = "AnnotationID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object annotationID;
    @XmlAttribute(name = "MeasurementUnitOID")
    protected String measurementUnitOID;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the itemOID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemOID() {
        return itemOID;
    }

    /**
     * Sets the value of the itemOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemOID(String value) {
        this.itemOID = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the isNull property.
     * 
     * @return
     *     possible object is
     *     {@link YesOnly }
     *     
     */
    public YesOnly getIsNull() {
        return isNull;
    }

    /**
     * Sets the value of the isNull property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesOnly }
     *     
     */
    public void setIsNull(YesOnly value) {
        this.isNull = value;
    }

    /**
     * Gets the value of the auditRecordID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAuditRecordID() {
        return auditRecordID;
    }

    /**
     * Sets the value of the auditRecordID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAuditRecordID(Object value) {
        this.auditRecordID = value;
    }

    /**
     * Gets the value of the signatureID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSignatureID() {
        return signatureID;
    }

    /**
     * Sets the value of the signatureID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSignatureID(Object value) {
        this.signatureID = value;
    }

    /**
     * Gets the value of the annotationID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAnnotationID() {
        return annotationID;
    }

    /**
     * Sets the value of the annotationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAnnotationID(Object value) {
        this.annotationID = value;
    }

    /**
     * Gets the value of the measurementUnitOID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasurementUnitOID() {
        return measurementUnitOID;
    }

    /**
     * Sets the value of the measurementUnitOID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasurementUnitOID(String value) {
        this.measurementUnitOID = value;
    }

}
