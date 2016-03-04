package ru.greg3d.applogic.interfaces;

import org.openqa.selenium.WebDriver;

public interface ApplicationManager {

	UserHelper getUserHelper();

	FilmHelper getFilmHelper();

	NavigationHelper getNavigationHelper();

	void stop();

	YandexHelper getYandexHelper();
}
