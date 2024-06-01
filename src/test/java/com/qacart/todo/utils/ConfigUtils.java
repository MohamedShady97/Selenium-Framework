package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {


    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        String env= System.getProperty("env","PRODUCTION");
        PropertiesUtils propertiesUtils = new PropertiesUtils();

        switch (env){
            case "PRODUCTION":
                properties=propertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties=propertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/LOCAL.properties");
                break;
            default:
                throw new RuntimeException("Environment is not supported");
        }

    }

    public static ConfigUtils getInstance(){
        if (configUtils==null) {
             configUtils = new ConfigUtils();
        }
        return configUtils;

    }

    public String getBaseUrl() {

        String prop = properties.getProperty("baseUrl");
        if (prop != null)
            return prop;
        throw new RuntimeException("could not find the baseUrl");

    }

    public String getEmail() {

        String prop = properties.getProperty("email");
        if (prop != null)
            return prop;
        throw new RuntimeException("could not find the email");

    }
    public String getpassword() {

        String prop = properties.getProperty("password");
        if (prop != null)
            return prop;
        throw new RuntimeException("could not find the password");

    }
}