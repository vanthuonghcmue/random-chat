package vn.tma;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConfigMapping(prefix = "twilio")
public interface TwilioConfig {
    String accountSid();
    String authToken();
    String apiKey();
    String apiSecret();
}
