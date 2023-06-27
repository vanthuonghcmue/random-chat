package vn.tma;

import io.quarkus.arc.log.LoggerName;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;

@QuarkusTest
public class LoggingTest {
    private static final Logger LOG_1 = Logger.getLogger(LoggingTest.class);
    @Test
    public void testLoggingWithInstance(){
        Exception ex = new Exception("Sample exception");
        LOG_1.info("Logging start...");
        LOG_1.error("ex:", ex);
        LOG_1.info("Logging end.");
        Assertions.assertTrue(true);
    }
    @Inject
    Logger log;
    @Test
    public void testLoggingInject(){
        log.info("Logging start...");
        log.info("Logging Inject...");
        log.info("Logging end.");
        Assertions.assertTrue(true);
    }

    @LoggerName("foo")
    Logger fooLog;
    @Test
    public void testLoggingInjectWithName(){
        fooLog.info("Logging start...");
        fooLog.info("Logging Inject with name 'food'");
        fooLog.info("Logging end.");
        Assertions.assertTrue(true);
    }
}