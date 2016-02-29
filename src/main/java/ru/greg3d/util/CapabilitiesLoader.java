package ru.greg3d.util;
import org.json.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesLoader {

	public static DesiredCapabilities loadCapabilities(String fileName, String capabilitiesName){
		String json = IOHelper.readFileToString(fileName, IOHelper.ENCODING_UTF8);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		try{
		JSONObject obj = new JSONObject(json);
    	
		for(Object name : obj.getJSONObject(capabilitiesName).names()){
    		cap.setCapability(name.toString(), obj.getJSONObject(capabilitiesName).getString(name.toString()));
    	}
		}catch(org.json.JSONException e){
			System.out.println(e.getMessage());
		}
		return cap;
	}
}
