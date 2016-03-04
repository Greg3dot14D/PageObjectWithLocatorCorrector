package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.NavigationHelper;

public class NavigationHelper1 extends DriverBasedHelper implements NavigationHelper {

	private String baseUrl;

	public NavigationHelper1(ApplicationManager1 manager) {
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}

	@Override
	public void openMainPage() {
		driver.get(baseUrl);
	}

	
	@Override
	public void openUrl(String url){
		driver.get(url);
	}
	
	@Override
	public void openRelativeUrl(String url) {
		driver.get(baseUrl + url);
	}

	@Override
	public void gotoUserProfilePage() {
		// driver.findElement(By.cssSelector("nav a[href $= '?go=profile']"))
		// .click();
		openRelativeUrl("?go=profile");
	}

	@Override
	public void gotoUserManagementPage() {
		// driver.findElement(By.cssSelector("nav a[href $= '?go=users']"))
		// .click();
		openRelativeUrl("?go=users");
	}

	@Override
	public void gotoHome() {
		if (!pages.homePage.pageIsOpen())
			pages.defaultPage.clickHomeHref();
	}

	@Override
	public void gotoAddNewFilmPage() {
		if (!pages.addFilmPage.pageIsOpen())
			//pages.homePage.imgAddMovieClick();
			pages.homePage.buttons.imgAddMovie().click();
	}
}
