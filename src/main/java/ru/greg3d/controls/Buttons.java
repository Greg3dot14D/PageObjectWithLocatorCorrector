package ru.greg3d.controls;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.container.AbstractContainer;
import ru.greg3d.factory.elements.Button;
import ru.greg3d.factory.fielddecorator.model.Corrector;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

@Corrector(what="fake")
public class Buttons extends AbstractContainer implements HomeButtons{

	//@FindBy(css = "img[title='"+ _WHAT_ID +"']")
	@FindBy(css = "img[title='fake']")
	public Button imgAddMovie;
	
	@FindBy(css = "img[title='fake_']")
	public Button imgFakeMovie;	
	
	public Button imgAddMovie(){
		return imgAddMovie;
	}
}
