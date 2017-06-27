package cz.hrubysoftware.smsmanagerlib;


import cz.hrubysoftware.smsmanagerlib.exception.SmsFormatException;
import cz.hrubysoftware.smsmanagerlib.exception.SmsTransportException;
import cz.hrubysoftware.smsmanagerlib.model.Message;
import cz.hrubysoftware.smsmanagerlib.model.Number;
import cz.hrubysoftware.smsmanagerlib.model.RequestDocument;
import cz.hrubysoftware.smsmanagerlib.model.RequestHeader;
import lombok.Data;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

@Data
public class SmsManager {
    private static final String ENDPOINT_URL = "https://xml-api.smsmanager.cz/Send";
    private OkHttpClient client = new OkHttpClient();
    private String username;
    private String sha1password;

    public SmsManager(String username, String password) {
        this.username = username;
        this.sha1password = DigestUtils.sha1Hex(password.getBytes());
    }

    public void sendMessage(String message, String... numbers) throws SmsFormatException, SmsTransportException {
        RequestDocument requestDocument = new RequestDocument()
                .requestHeader(new RequestHeader()
                        .username(username)
                        .password(sha1password))
                .requestList(new ArrayList<cz.hrubysoftware.smsmanagerlib.model.Request>() {{
                    add(new cz.hrubysoftware.smsmanagerlib.model.Request()
                            .type(cz.hrubysoftware.smsmanagerlib.model.Request.Type.high)
                            .customId(0)
                            .message(new Message()
                                    .message(message)
                                    .type(Message.Type.Text))
                            .numbersList(new ArrayList<Number>() {{
                                for (String number : numbers) add(new Number().number(number));
                            }}));
                }});

        try {
            String data = serializeRequest(requestDocument);
            post(ENDPOINT_URL, data);
        } catch (JAXBException e) {
            throw new SmsFormatException("Malformed message.", e);
        } catch (IOException e) {
            throw new SmsTransportException("Failed to send a message", e);
        }


    }

    private String serializeRequest(RequestDocument requestDocument) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(RequestDocument.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FRAGMENT, true);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.marshal(requestDocument, writer);
        return writer.toString();
    }

    private String post(String url, String data) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add("XMLDATA", data)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
