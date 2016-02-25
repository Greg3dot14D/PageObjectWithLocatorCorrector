package ru.greg3d.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class Buttons extends AnyControl implements HomeButtons{

	//@FindBy(css = "img[title='"+ _WHAT_ID +"']")
	@FindBy(css = "img[title='fake']")
	public WebElement imgAddMovie;
	
	@FindBy(css = "img[title='fake_']")
	public WebElement imgFakeMovie;	
	
	
	public Buttons(WebDriver driver, LocatorCorrector corrector)  {
		super(driver, corrector.setWhat("fake"));
		//super(driver, corrector);
	}
	
	public void ImgAddMovieClick(){
		imgAddMovie.click();
	}
	
	public void ImgFakeMovieClic(){
		imgFakeMovie.click();
	}
	
}
