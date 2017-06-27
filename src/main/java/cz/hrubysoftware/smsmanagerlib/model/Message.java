package cz.hrubysoftware.smsmanagerlib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@Data
@Accessors(fluent = true)
public class Message {

    @XmlAttribute(name = "Type")
    Type type;

    @XmlValue
    String message;

    @XmlType(namespace = "message")
    public enum Type {
        Text
    }

}
