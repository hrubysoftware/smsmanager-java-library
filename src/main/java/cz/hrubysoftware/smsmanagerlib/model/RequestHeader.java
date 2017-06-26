package cz.hrubysoftware.smsmanagerlib.model;

import javax.xml.bind.annotation.XmlElement;

public class RequestHeader {

    @XmlElement(name = "Username", nillable = false)
    String username;

    @XmlElement(name = "Password", nillable = false)
    String password;
}
