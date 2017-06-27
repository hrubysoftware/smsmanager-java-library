package cz.hrubysoftware.smsmanagerlib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Data
@Accessors(fluent = true)
@XmlRootElement(name = "RequestDocument")
public class RequestDocument {

    @XmlElement(name = "RequestHeader")
    RequestHeader requestHeader;

    @XmlElementWrapper(name = "RequestList")
    @XmlElement(name = "Request")
    Collection<Request> requestList;
}
