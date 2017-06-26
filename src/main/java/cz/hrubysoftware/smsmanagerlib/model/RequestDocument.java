package cz.hrubysoftware.smsmanagerlib.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;

public class RequestDocument {

    @XmlElement(name = "RequestHeader")
    RequestHeader requestHeader;

    @XmlElement(name = "RequestList")
    Collection<Request> requestList;
}
