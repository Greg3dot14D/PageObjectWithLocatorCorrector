package ru.greg3d.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.controls.Buttons;
import ru.greg3d.factory.elements.Button;
import ru.greg3d.factory.elements.TextInput;
import ru.greg3d.factory.elements.html.SearchArrow;
import ru.greg3d.factory.elements.html.SearchArrowData;
import ru.greg3d.factory.fielddecorator.model.Corrector;

public class YandexPage extends AnyPage {

	@FindBy(css=SearchArrowData.button_css)
	private Button searchButton;
	
	@FindBy(id=SearchArrowData.input_id)
	private TextInput inputText;
	
	@FindBy(css=SearchArrowData.resultsList_css)
	private WebElement serpList;

	public YandexPage clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public YandexPage inputText(String text){
		inputText.sendKeys(text);
		return this;
	}
	
	@Corrector(than="text")
	@FindBy(xpath="//form")
	public SearchArrow arrow;
	
	public String getResultValueByIndex(int index){
		return arrow.getResultValueByIndex(index);
	}	
	
	public YandexPage (PageManager page) {
		super(page);
	}
	
	public YandexPage serchText(String text){
		arrow.inputText(text).clickSearchButton();
		return this;
	}
	
	public String getValueByIndex(int index){
		return arrow.getResultValueByIndex(index);
	}
}
