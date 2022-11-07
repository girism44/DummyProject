package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This method contains reusable methods of the property file
 * @author Hp
 *
 */
public class PropertyFileutility {
Properties property;
	
	/**
	 * This method initializes property file
	 * @param filePath 
	 */
	public void propertyFileInitialization(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to fetch data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		
		return property.getProperty(key);
	}

	
}
