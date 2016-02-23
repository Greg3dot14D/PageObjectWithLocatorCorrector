package ru.greg3d.factory.fielddecorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class LocatorCorrectorFieldDecorator extends DefaultFieldDecorator {
	public LocatorCorrectorFieldDecorator(final SearchContext searchContext,
			LocatorCorrector corrector) {
		super(new LocatorCorrectorDefaultElementLocatorFactory(searchContext, corrector));
	}
}
