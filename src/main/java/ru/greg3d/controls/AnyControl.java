package ru.greg3d.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.greg3d.factory.fielddecorator.LocatorCorrectorFieldDecorator;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class AnyControl{
	
	public AnyControl(WebDriver driver, LocatorCorrector corrector){
		PageFactory.initElements(new LocatorCorrectorFieldDecorator(driver, corrector), this);
	}
}
