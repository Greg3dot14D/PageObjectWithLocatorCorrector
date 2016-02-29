package ru.greg3d.util;

import java.io.*;

public class IOHelper {

    public static final String ENCODING_WIN1251 = "windows-1251";
    public static final String ENCODING_UTF8 = "UTF-8";
    
	public static String readFileToString(String fileName, String encoding){
		
		StringBuilder sb = new StringBuilder("");
		try {
			BufferedReader br = new BufferedReader(
				      new InputStreamReader(
				          new FileInputStream(fileName),encoding));
			String line = "";
			try {
				while( (line = br.readLine()) != null){
					sb.append("\n" + line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			br.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	

}
