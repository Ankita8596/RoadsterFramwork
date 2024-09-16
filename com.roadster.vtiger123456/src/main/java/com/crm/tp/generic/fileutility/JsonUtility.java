package com.crm.tp.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	/**
	 * Read the data from the json and pass the key as string
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJson(String key) throws Throwable {
		FileReader fileR = new FileReader("./TestData/GlobalData.properties");
	    JSONParser parser = new JSONParser();
		Object obj = parser.parse(fileR);
		JSONObject map=(JSONObject)obj;
		String data = (String)map.get(key);
	    return data;
}
}
