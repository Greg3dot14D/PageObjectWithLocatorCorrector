package ru.greg3d.factory.elements.html;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ru.greg3d.factory.container.AbstractContainer;
import ru.greg3d.factory.elements.*;
import ru.greg3d.factory.fielddecorator.model.Corrector;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

@Corrector(what="YYY")
public class SearchArrow extends AbstractContainer{
	
	@FindBy(css=SearchArrowData.button_css)
	private Button searchButton;
	
	@FindBy(id=SearchArrowData.input_id)
	private TextInput inputText;
	
	@FindBy(css=SearchArrowData.resultsList_css)
	private WebElement serpList;

	public SearchArrow clickSearchButton(){
		searchButton.click();
		return this;
	}
	
	public SearchArrow inputText(String text){
		inputText.sendKeys(text);
		return this;
	}
	
	public String getResultValueByIndex(int index){
		return serpList.findElements(By.className("serp-item")).get(index).getText().split("\n")[0];
	}
}
