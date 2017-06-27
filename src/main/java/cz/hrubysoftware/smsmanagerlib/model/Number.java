package cz.hrubysoftware.smsmanagerlib.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlValue;

@Data
@Accessors(fluent = true)
public class Number {

    @XmlValue
    String number;

}
