package br.com.thiaguten.javamail.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public abstract class ResourceUtils {

    public static ResourceBundle getResource(String resource) {
        if (resource == null)
            throw new IllegalArgumentException("resource must not be null");

        return ResourceBundle.getBundle(resource);
    }

    public static PropertyResourceBundle getPropertyResourceBundle(InputStream inputStream) {
        if (inputStream == null)
            throw new IllegalArgumentException("input stream must not be null");

        PropertyResourceBundle propertyResourceBundle = null;
        try {
            propertyResourceBundle = new PropertyResourceBundle(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyResourceBundle;
    }

    public static Properties convertResourceBundleToProperties(ResourceBundle resource) {
        if (resource == null)
            throw new IllegalArgumentException("resource must not be null");

        Properties properties = new Properties();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.put(key, resource.getString(key));
        }
        return properties;
    }

    public static InputStream getResourceAsStream(String resource) {
        if (resource == null)
            throw new IllegalArgumentException("resource must not be null");

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(resource);
    }

    public static Properties getProperties(String resource) {
        if (resource == null)
            throw new IllegalArgumentException("resource must not be null");

        InputStream resourceAsStream = getResourceAsStream(resource);
        if (resourceAsStream != null) {
            PropertyResourceBundle propertyResourceBundle = ResourceUtils.getPropertyResourceBundle(resourceAsStream);
            return convertResourceBundleToProperties(propertyResourceBundle);
        }
        return null;

    }

}
