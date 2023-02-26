package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected FileInputStream fileInputStream;
    protected Properties properties;

    public ConfProperties() {
        try{
            fileInputStream = new FileInputStream("src/test/resources/conf.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try{
                    fileInputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String getProperty (String key){
        return properties.getProperty(key);
    }
}
