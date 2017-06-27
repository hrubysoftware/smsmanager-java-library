package cz.hrubysoftware.smsmanagerlib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.Collection;
import java.util.Date;

@Accessors(fluent = true)
@Data
public class Request {

    @XmlAttribute(name = "Type", required = true)
    Type type;

    @XmlAttribute(name = "CustomID")
    Integer customId;

    @XmlAttribute(name = "Sender")
    String sender;

    @XmlAttribute(name = "Time")
    Date time;

    @XmlAttribute(name = "Expiration")
    Date expiration;

    @XmlElement(name = "Message", nillable = false)
    Message message;

    @XmlElementWrapper(name = "NumbersList")
    @XmlElement(name = "Number", nillable = false)
    Collection<Number> numbersList;

    @XmlType(namespace = "request")
    public enum Type {
        high, economy, lowcost
    }
}
