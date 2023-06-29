package vn.tma.Services.Twilio;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VideoGrant;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.ConfigProvider;
import vn.tma.TwilioConfig;

@ApplicationScoped
public class TwilioService {
    @Inject
    TwilioConfig twilioConfig;
    String accountSid;
    String authToken;

    String apiKey;
    String apiSecret;

    public String createAccessToken( String identity, String roomSid ) {
        System.out.println("createAccessToken");

        // Create Video grant
        VideoGrant grant = new VideoGrant().setRoom(roomSid);

        // Create access token
        AccessToken token = new AccessToken.Builder(
                twilioConfig.accountSid(),
                twilioConfig.apiKey(),
                twilioConfig.apiSecret()
        ).identity(identity).grant(grant).build();
        return token.toJwt();
    }
}
