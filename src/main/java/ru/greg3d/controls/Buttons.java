package ru.greg3d.controls;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.elements.Button;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class Buttons extends CorrectedBlock implements HomeButtons{

	//@FindBy(css = "img[title='"+ _WHAT_ID +"']")
	@FindBy(css = "img[title='fake']")
	public Button imgAddMovie;
	
	@FindBy(css = "img[title='fake_']")
	public Button imgFakeMovie;	
	
	
	public Buttons(WebDriver driver, LocatorCorrector corrector)  {
		super(driver, corrector.setWhat("fake"));
		//super(driver, corrector);
	}
	
	public Button imgAddMovie(){
		return imgAddMovie;
	}
}
