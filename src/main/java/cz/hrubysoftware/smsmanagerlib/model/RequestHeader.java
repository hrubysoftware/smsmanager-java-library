package cz.hrubysoftware.smsmanagerlib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlElement;

@Accessors(fluent = true)
@Data
public class RequestHeader {

    @XmlElement(name = "Username", nillable = false)
    String username;

    @XmlElement(name = "Password", nillable = false)
    String password;
}
