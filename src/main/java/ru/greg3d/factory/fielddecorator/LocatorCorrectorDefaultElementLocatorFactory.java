package ru.greg3d.factory.fielddecorator;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class LocatorCorrectorDefaultElementLocatorFactory implements ElementLocatorFactory {
	  private final SearchContext searchContext;
	  private final LocatorCorrector corrector;
	  
	  public LocatorCorrectorDefaultElementLocatorFactory(SearchContext searchContext, LocatorCorrector corrector) {
	    this.searchContext = searchContext;
	    this.corrector = corrector;
	  }

	  public ElementLocator createLocator(Field field) {
		  return new LocatorCorrectorDefaultElementLocator(searchContext, field, corrector);
	  }
	}
