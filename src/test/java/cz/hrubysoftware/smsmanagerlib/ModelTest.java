package cz.hrubysoftware.smsmanagerlib;

import cz.hrubysoftware.smsmanagerlib.model.*;
import cz.hrubysoftware.smsmanagerlib.model.Number;
import junit.framework.TestCase;
import org.junit.Before;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

public class ModelTest extends TestCase {
    RequestDocument requestDocument;

    @Override
    @Before
    protected void setUp() throws Exception {
        requestDocument = new RequestDocument()
                .requestHeader(
                        new RequestHeader()
                                .username("test")
                                .password("a94a8fe5ccb19ba61c4c0873d391e987982fbbd3"))
                .requestList(new ArrayList<Request>() {{
                    add(
                            new Request()
                                    .type(Request.Type.high)
                                    .customId(987654321)
                                    .message(
                                            new Message()
                                                    .message("Test")
                                                    .type(Message.Type.Text)
                                    )
                                    .numbersList(new ArrayList<Number>() {{
                                        add(new Number().number("420777123456"));
                                    }}));

                }});
    }

    public void testXmlSerializer() throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(RequestDocument.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.marshal(requestDocument, writer);
        String result = "<RequestDocument><RequestHeader><Username>test</Username><Password>a94a8fe5ccb19ba61c4c0873d391e987982fbbd3</Password></RequestHeader><RequestList><Request Type=\"high\" CustomID=\"987654321\"><Message Type=\"Text\">Test</Message><NumbersList><Number>420777123456</Number></NumbersList></Request></RequestList></RequestDocument>";
        assertEquals(result.length(), writer.toString().length());
        assertEquals(result, writer.toString());
    }


}
