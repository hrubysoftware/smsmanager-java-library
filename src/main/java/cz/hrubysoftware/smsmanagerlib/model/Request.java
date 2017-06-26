package cz.hrubysoftware.smsmanagerlib.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;
import java.util.Date;

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

    @XmlElement(name = "NumbersList", nillable = false)
    Collection<Number> numbersList;

    enum Type {
        high, economy, lowcost
    }
}
