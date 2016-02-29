package ru.greg3d.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddFilmPage extends DefaultPage {

	private final String url = "/?go=add";
	
	@FindBy(name="name")
	private WebElement titleInput;
	
	@FindBy(name="year")
	private WebElement yearInput;
	
	@FindBy(name="duration")
	private WebElement durationInput;
	
	@FindBy(name="rating")
	private WebElement ratingInput;	
	
	// сохранили запись
	@FindBy(css="img[title='Save']")
	private WebElement imgSave;
	
	public AddFilmPage(PageManager page) {
		super(page);
	}

	public AddFilmPage imgSaveClick(){
		imgSave.click();
		return this;
	}
	
	public AddFilmPage titleInput(String text){
		titleInput.click();
		titleInput.sendKeys(text);
		return this;
	}
	
	public AddFilmPage titleInputClear(){
		anyInputClear(titleInput);
		return this;
	}	
	
	public AddFilmPage yearInput(String text){
		yearInput.click();
		yearInput.sendKeys(text);
		return this;
	}
	
	public AddFilmPage yearInputClear(){
		anyInputClear(yearInput);
		return this;
	}	
	
	public AddFilmPage ratingInput(String text){
		ratingInput.click();
		ratingInput.sendKeys(text);
		return this;
	}
	
	public AddFilmPage ratingInputClear(){
		anyInputClear(ratingInput);
		return this;
	}
	
	public AddFilmPage durationInput(String text){
		durationInput.click();
		durationInput.sendKeys(text);
		return this;
	}
	
	public AddFilmPage durationInputClear(){
		anyInputClear(durationInput);
		return this;
	}
	
}
