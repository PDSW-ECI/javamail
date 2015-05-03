package br.com.thiaguten.javamail.core.support;

import br.com.thiaguten.javamail.utils.ResourceUtils;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class MailConfiguration {

    private static final AtomicBoolean hasAlreadyBeenLoaded = new AtomicBoolean(false);
    private static Properties configuration = getConfiguration();

    public static Properties getConfiguration() {
        if (hasAlreadyBeenLoaded.getAndSet(true))
            return configuration;
        configuration = ResourceUtils.getProperties("javamail.properties");
        return configuration;
    }
}
