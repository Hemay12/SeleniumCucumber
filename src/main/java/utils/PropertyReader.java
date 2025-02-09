package utils;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;


public class PropertyReader {
	
	public static String propertyReader(String key) {
		String value = null;
		
		try (InputStream input = new FileInputStream("/BDD_start/config.property"))
        {
            // object creation for Property class
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            //getProperty will fetch the value according to the key
            value=prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return value;
	}
}
