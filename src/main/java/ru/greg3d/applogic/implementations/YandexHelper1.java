package ru.greg3d.applogic.implementations;

import ru.greg3d.applogic.interfaces.YandexHelper;

public class YandexHelper1 extends DriverBasedHelper implements YandexHelper{

	public YandexHelper1(ApplicationManager1 manager) {
		super(manager.getWebDriver());
	}
	
	public String searchFirstValue(String text){
		return pages.yandexPage.serchText(text).getValueByIndex(0);
	}
}
