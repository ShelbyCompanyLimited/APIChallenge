package helpers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {


    public Properties properties;
    String currentDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\settings.properties";
    public final String propertyFilePath = currentDirectory;


    public ReadFromPropertiesFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public int getId() {
        String id = properties.getProperty("id");
        if (id != null) return Integer.parseInt(id);
        else throw new RuntimeException("ID is not specified in Property File");
    }

    public String getName() {
        String name = properties.getProperty("name");
        if (name != null) return name;
        else throw new RuntimeException("Name is not specified in Property File");
    }

    public int getCategoryId() {
        String categoryId = properties.getProperty("categoryId");
        if (categoryId != null) return Integer.parseInt(categoryId);
        else throw new RuntimeException("categoryId is not specified in Property File");
    }

    public String getCategoryName() {
        String categoryName = properties.getProperty("categoryName");
        if (categoryName != null) return categoryName;
        else throw new RuntimeException("categoryName Error Message is not specified in Property File");
    }

    public String getPhotoUrl() {
        String photoUrl = properties.getProperty("photoUrl");
        if (photoUrl != null) return photoUrl;
        else throw new RuntimeException("photoUrl is not specified in Property File");
    }

    public int getTagId() {
        String tagId = properties.getProperty("tagId");
        if (tagId != null) return Integer.parseInt(tagId);
        else throw new RuntimeException("tagId is not specified in Property File");
    }
    public String getTagName() {
        String tagName = properties.getProperty("tagName");
        if (tagName != null) return tagName;
        else throw new RuntimeException("tagName is not specified in Property File");
    }
    public String getStatus() {
        String getStatus = properties.getProperty("status");
        if (getStatus != null) return getStatus;
        else throw new RuntimeException("getStatus is not specified in Property File");
    }

}