package ru.greg3d.applogic.interfaces;

public interface NavigationHelper {

	void openMainPage();

	void openRelativeUrl(String url);

	void openUrl(String url);

	void gotoUserProfilePage();

	void gotoUserManagementPage();

	void gotoHome();

	void gotoAddNewFilmPage();
}
