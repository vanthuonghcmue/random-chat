package vn.tma.services;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.tma.services.twilio.TwilioService;
import vn.tma.TwilioConfig;

@QuarkusTest
public class TwilioServiceTest {
    @Inject
    TwilioService twilioService;

    @Inject
    TwilioConfig twilioConfig;
    @Inject
    @ConfigProperty(name = "twilio.api-key")
    String apiKey;

    @Test
    public void testCreateAccessTokenWork(){
        System.out.println(apiKey);
        String identity = "user";
        String roomId = "123";
        String token = twilioService.createAccessToken(identity, roomId);
        System.out.println("-----------------------------------------------");
        System.out.println(token);
        System.out.println("-----------------------------------------------");
        Assertions.assertNotNull(token);
    }
}
