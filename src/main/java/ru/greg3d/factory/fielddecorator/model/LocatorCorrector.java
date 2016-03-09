package ru.greg3d.factory.fielddecorator.model;

import java.lang.reflect.Field;

/**
 * Class makes dinamic replacement of "whatReplace" to "thanReplace" in method CorrectedAbstractAnnotations.buildByFromShortFindBy 
 * 
 * @author Greg3D
 *         Date: 09.03.16
 */
public class LocatorCorrector {
	private String whatReplace = "";
	private String thanReplace = "";
	
	public LocatorCorrector setWhat(String value){
		this.whatReplace = value;
		return this;
	}
	
	public LocatorCorrector setWhat(Class<?> clazz){
		if(clazz.isAnnotationPresent(Corrector.class))
			this.whatReplace = ((Corrector)clazz.getAnnotation(Corrector.class)).what();
		return this;
	}
	
	public LocatorCorrector setThan(Field field){
		if(field.isAnnotationPresent(Corrector.class))
			this.thanReplace = field.getAnnotation(Corrector.class).than();
		return this;
	}	
	
	public LocatorCorrector setThan(String value){
		this.thanReplace = value;
		return this;
	}
	
	public void test(){
		System.out.println("what :" + this.whatReplace);
		System.out.println("than :" + this.thanReplace);
	}
	
	public String getCorrectedValue(String text){
		if (whatReplace.equals("") || thanReplace.equals(""))
			return text;
//		if (whatReplace.equals("") && thanReplace.equals(""))
//			return text;
//		if(whatReplace.equals("") && !thanReplace.equals("")){
//			throw new IllegalArgumentException(("whatReplace value is empty"));
//		}
		return text.replace(whatReplace, thanReplace);
	}
	

}
