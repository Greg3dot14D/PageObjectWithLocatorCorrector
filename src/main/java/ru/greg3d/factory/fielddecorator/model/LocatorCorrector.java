package ru.greg3d.factory.fielddecorator.model;

public class LocatorCorrector {
	private String whatReplace = "";
	private String thanReplace = "";
	
	public LocatorCorrector setWhat(String value){
		this.whatReplace = value;
		return this;
	}
	
	public LocatorCorrector setThan(String value){
		this.thanReplace = value;
		return this;
	}
	
	public String getCorrectedValue(String text){
		if (whatReplace.equals(null) || thanReplace.equals(null))
			return text;
		return text.replace(whatReplace, thanReplace);
	}
}