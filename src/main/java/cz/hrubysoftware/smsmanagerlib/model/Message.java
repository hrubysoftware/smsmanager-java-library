package cz.hrubysoftware.smsmanagerlib.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Message {

    @XmlAttribute
    Type type;

    @XmlValue
    String message;

    enum Type {
        Text
    }

}
