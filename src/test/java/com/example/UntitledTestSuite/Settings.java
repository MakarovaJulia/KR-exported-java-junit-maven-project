package com.example.UntitledTestSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static String fileDirectory = "./settings.xml";
    private static final Properties properties;
    private static String baseUrl;
    private static String username;
    private static String password;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(fileDirectory)){
            properties = new Properties();
            properties.loadFromXML(fileInputStream);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl(){
        if(baseUrl == null){
            baseUrl = properties.getProperty("baseURL");
        }
        return baseUrl;
    }

    public static String getUsername(){
        if(username == null){
            username = properties.getProperty("username");
        }
        return username;
    }

    public static String getPassword(){
        if(password == null){
            password = properties.getProperty("password");
        }
        return password;
    }
}
