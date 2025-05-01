package utils;

import java.io.*;
import java.util.Properties;

    public class PropertiesFileReader {
        private static Properties properties;

        // method to load the properties file
        public void getProperties() {
            try {
                 properties = new Properties();
                InputStream input = new FileInputStream("src/test/java/resources/Prop.properties");
                properties.load(input);

            } catch (Exception e) {
                System.out.println("cause of exception is "+e.getCause());
            }
        }

        public static void loadProperties() {
            try {
                FileInputStream fis = new FileInputStream("src/test/java/resources/Prop.properties");
                properties = new Properties();
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load configuration file.");
            }
        }

        public static String getProperty(String key) {
            if (properties == null) {
                loadProperties();
            }
            return properties.getProperty(key);
        }

    }
