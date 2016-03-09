package ru.greg3d;

import org.testng.annotations.Test;

import ru.greg3d.asserts.Assert;

public class testYandexSearch extends TestBase{

	@Test
	public void testSearchQWERTY(){
		app.getNavigationHelper().openUrl("http://ya.ru");
		Assert.assertEquals(app.getYandexHelper().searchFirstValue("QWERTY"), "«Qwerty» — интернет-провайдер", "results not equals");
	}
	
}
