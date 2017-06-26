package cz.hrubysoftware.smsmanagerlib;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;


public class SmsManagerTest extends TestCase {

    SmsManager smsManager;

    @Before
    public void setUp() throws Exception {
        this.smsManager = new SmsManager("username", "password");
    }

    @Test
    public void testGetUsername() {
        assertEquals(smsManager.getUsername(), "username");
    }

    @Test
    public void testGetPassword() {
        assertEquals(smsManager.getSha1password(), "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8");
    }


}