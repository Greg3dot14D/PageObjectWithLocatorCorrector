package ru.greg3d.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import ru.greg3d.factory.fielddecorator.LocatorCorrectorFieldDecorator;

public class PageManager {

	private WebDriver driver;

	public HomePage homePage;
	public DefaultPage defaultPage;
	public AddFilmPage addFilmPage;
	public MoviePage moviePage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
		homePage = initElements(new HomePage(this));
		defaultPage = initElements(new DefaultPage(this));
		addFilmPage = initElements(new AddFilmPage(this));
		moviePage = initElements(new MoviePage(this));
	}

	private <T extends Page> T initElements(T page) {
		//PageFactory.initElements(driver, page);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
		// page);
		//PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
		//* PageFactory.initElements(new lcFieldDecorator(driver, corrector), this);
		PageFactory.initElements(new LocatorCorrectorFieldDecorator(driver, page.getLocatorCorrector()), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
