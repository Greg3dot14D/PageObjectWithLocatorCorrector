package ru.greg3d.applogic.implementations;

import org.openqa.selenium.WebDriver;

import ru.greg3d.applogic.interfaces.ApplicationManager;
import ru.greg3d.applogic.interfaces.FilmHelper;
import ru.greg3d.applogic.interfaces.NavigationHelper;
import ru.greg3d.applogic.interfaces.UserHelper;
import ru.greg3d.applogic.interfaces.YandexHelper;
import ru.greg3d.browsers.BrowserDriver;
import ru.greg3d.browsers.TracingWebDriver;
import ru.greg3d.util.*;

public class ApplicationManager1 implements ApplicationManager {

	private UserHelper userHelper;
	private FilmHelper filmHelper;
	private NavigationHelper navHelper;
	private YandexHelper yandexHelper;

	private WebDriver driver;
	private String baseUrl;

	public ApplicationManager1(){
		this(null);
	}
	
	public ApplicationManager1(String capabilitiesName) {
		this.baseUrl = PropertyLoader.loadProperty("site.url");
		//driver = new TracingWebDriver(BrowserDriver.getEventFiringWebDriver(BrowserDriver.newDriver("JIAYU G4S")))
		//		.getWrappedDriver();
		//driver = new TracingWebDriver(BrowserDriver.getEventFiringWebDriver(BrowserDriver.newDriver("firefox")));		
		driver = new TracingWebDriver(BrowserDriver.getEventFiringWebDriver(BrowserDriver.newDriver(capabilitiesName)));
		userHelper = new UserHelper1(this);
		filmHelper = new FilmHelper1(this);
		navHelper = new NavigationHelper1(this);
		yandexHelper = new YandexHelper1(this);

		getNavigationHelper().openMainPage();
	}

	@Override
	public UserHelper getUserHelper() {
		return userHelper;
	}

	@Override
	public FilmHelper getFilmHelper() {
		return filmHelper;
	}

	@Override
	public NavigationHelper getNavigationHelper() {
		return navHelper;
	}

	@Override
	public YandexHelper getYandexHelper() {
		return yandexHelper;
	}	
	
	protected WebDriver getWebDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	@Override
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}
}
