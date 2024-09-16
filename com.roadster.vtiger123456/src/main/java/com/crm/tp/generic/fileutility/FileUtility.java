package com.crm.tp.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	/**
	 * 
	 * Reading the data from the properties file and passing the key
	 * @param key
	 * @return data
	 * @throws Throwable
	 */
	public String getCommonDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./TestData/GlobalData.properties");
		Properties prop = new Properties();
		prop.load(fis);
			String	data=prop.getProperty(key);
		return data;
		
	}

}
