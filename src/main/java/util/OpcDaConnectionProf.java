package util;

import com.hurence.opc.auth.NtlmCredentials;
import com.hurence.opc.da.OpcDaConnectionProfile;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class OpcDaConnectionProf {
    private final static String COM_CLS_ID = "F8527792-6B53-4D49-9E81-3099CF2BC8DB";
    private final static String OPC_DOMAIN_NAME = "Broker";
    private final static String USER = "user";
    private final static String PASSWORD = "1985";
    private final static String CONNECTION_URL = "localhost:1883";
    private final static long TIMEOUT = 1L;

   public static OpcDaConnectionProfile getProfile() {
       OpcDaConnectionProfile connectionProfile = new OpcDaConnectionProfile();
       try {
           connectionProfile .withComClsId(COM_CLS_ID)
                   .withCredentials(new NtlmCredentials()
                           .withDomain(OPC_DOMAIN_NAME)
                           .withUser(USER)
                           .withPassword(PASSWORD))
                   .withConnectionUri(new URI(CONNECTION_URL))
                   .withSocketTimeout(Duration.of(TIMEOUT, ChronoUnit.SECONDS));
        } catch (URISyntaxException e) {
            throw new RuntimeException("Can't create profile OPC DA connector",e);
        }
        return connectionProfile;
    }

}
