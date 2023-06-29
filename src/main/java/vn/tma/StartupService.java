package vn.tma;


import com.twilio.Twilio;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import jakarta.enterprise.event.Observes;
import vn.tma.Services.Twilio.TwilioService;

@ApplicationScoped
public class StartupService {
    private static final Logger LOG = Logger.getLogger(StartupService.class);

    /**
     * Run some tasks while application starting up
     *
     * @param event
     */
    public void onStart(@Observes StartupEvent event) {
        LOG.info("Staring up...");
    }

}
