package com.softserve.edu.opencart.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
    public static final String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
    public static final String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";

    private Properties properties;
    private static PropertiesUtils instance;

    private PropertiesUtils(){
        properties = new Properties();
    }

    public static PropertiesUtils getInstance(){
        if(instance == null){
            instance = new PropertiesUtils();
        }
        return instance;
    }

    private void getProperties(String fileName){
        try(FileInputStream fis = new FileInputStream(fileName)){
            properties = new Properties();
            properties.load(fis);
        }catch (FileNotFoundException exception){
            throw new RuntimeException(String.format(FILE_NOT_FOUND_EXCEPTION, fileName), exception);
        }catch (IOException exception) {
            throw new RuntimeException(String.format(FILE_NOT_CLOSE_EXCEPTION, fileName), exception);
        }
    }

    public String getPropertyValue(String fileName, String property){
        if(properties.getProperty(property) == null){
            getProperties(fileName);
        }
        return properties.getProperty(property);
    }

    public void setPropertiesValue(String fileName, String key, String value){
        try (FileOutputStream fos = new FileOutputStream(fileName)){
            properties.setProperty(key, value);
            properties.store(fos, null);
        }catch (FileNotFoundException exception){
            throw new RuntimeException(String.format(FILE_NOT_FOUND_EXCEPTION, fileName), exception);
        }catch (IOException exception) {
            throw new RuntimeException(String.format(FILE_NOT_CLOSE_EXCEPTION, fileName), exception);
        }
    }
}
