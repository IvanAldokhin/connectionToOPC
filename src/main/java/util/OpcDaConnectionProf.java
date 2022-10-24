package util;

import com.hurence.opc.auth.NtlmCredentials;
import com.hurence.opc.da.OpcDaConnectionProfile;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class OpcDaConnectionProf {
    private final static String COM_CLS_ID = "F8582CF2-88FB-11D0-B850-00C0F0104305";
    private final static String OPC_DOMAIN_NAME = "OPC-DOMAIN";
    private final static String USER = "USER";
    private final static String PASSWORD = "opc";
    private final static String CONNECTION_URL = "opc.da://192.168.99.100";
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
