package service;

public class LoggingConfProperties extends ConfProperties {
    private ConfProperties properties;

    public LoggingConfProperties(ConfProperties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        var value = properties.getProperty(key);
        System.out.println("key: " + key + " value: " + value);
        return value;
    }
}
