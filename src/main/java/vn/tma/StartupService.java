package vn.tma;


import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;
import jakarta.enterprise.event.Observes;

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
