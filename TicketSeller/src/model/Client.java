package model;
//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2018.07.01 at 04:50:15 PM BRT 
//

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
* <p>Java class for client complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="client">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="CPF" type="{}cpfType"/>
*         &lt;element name="email" type="{}emailType"/>
*         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
*         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="passwd" type="{http://www.w3.org/2001/XMLSchema}string"/>
*         &lt;element name="permission" type="{http://www.w3.org/2001/XMLSchema}int"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "client", propOrder = {
 "cpf",
 "email",
 "id",
 "name",
 "passwd",
 "permission"
})
public class Client {

 @XmlElement(name = "CPF", required = true)
 protected String cpf;
 @XmlElement(required = true)
 protected String email;
 protected Integer id;
 @XmlElement(required = true)
 protected String name;
 @XmlElement(required = true)
 protected String passwd;
 protected int permission;

 /**
  * Gets the value of the cpf property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getCPF() {
     return cpf;
 }

 /**
  * Sets the value of the cpf property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setCPF(String value) {
     this.cpf = value;
 }

 /**
  * Gets the value of the email property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getEmail() {
     return email;
 }

 /**
  * Sets the value of the email property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setEmail(String value) {
     this.email = value;
 }

 /**
  * Gets the value of the id property.
  * 
  * @return
  *     possible object is
  *     {@link Integer }
  *     
  */
 public Integer getId() {
     return id;
 }

 /**
  * Sets the value of the id property.
  * 
  * @param value
  *     allowed object is
  *     {@link Integer }
  *     
  */
 public void setId(Integer value) {
     this.id = value;
 }

 /**
  * Gets the value of the name property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getName() {
     return name;
 }

 /**
  * Sets the value of the name property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setName(String value) {
     this.name = value;
 }

 /**
  * Gets the value of the passwd property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getPasswd() {
     return passwd;
 }

 /**
  * Sets the value of the passwd property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setPasswd(String value) {
     this.passwd = value;
 }

 /**
  * Gets the value of the permission property.
  * 
  */
 public int getPermission() {
     return permission;
 }

 /**
  * Sets the value of the permission property.
  * 
  */
 public void setPermission(int value) {
     this.permission = value;
 }

}