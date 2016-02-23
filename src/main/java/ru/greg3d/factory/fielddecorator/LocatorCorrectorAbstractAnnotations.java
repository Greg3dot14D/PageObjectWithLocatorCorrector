package ru.greg3d.factory.fielddecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

/**
 * Abstract class to work with fields in Page Objects. Provides methods to
 * process {@link org.openqa.selenium.support.FindBy},
 * {@link org.openqa.selenium.support.FindBys} and
 * {@link org.openqa.selenium.support.FindAll} annotations.
 */
public abstract class LocatorCorrectorAbstractAnnotations extends AbstractAnnotations {
	protected LocatorCorrector corrector;

	@Override
	protected By buildByFromShortFindBy(FindBy findBy) {
		if (!"".equals(findBy.className()))
			return By.className(corrector.getCorrectedValue(findBy.className()));

		if (!"".equals(findBy.css()))
			return By.cssSelector(corrector.getCorrectedValue(findBy.css()));

		if (!"".equals(findBy.id()))
			return By.id(corrector.getCorrectedValue(findBy.id()));

		if (!"".equals(findBy.linkText()))
			return By.linkText(corrector.getCorrectedValue(findBy.linkText()));

		if (!"".equals(findBy.name()))
			return By.name(corrector.getCorrectedValue(findBy.name()));

		if (!"".equals(findBy.partialLinkText()))
			return By.partialLinkText(corrector.getCorrectedValue(findBy.partialLinkText()));

		if (!"".equals(findBy.tagName()))
			return By.tagName(corrector.getCorrectedValue(findBy.tagName()));

		if (!"".equals(findBy.xpath()))
			return By.xpath(corrector.getCorrectedValue(findBy.xpath()));

		// Fall through
		return null;
	}
}
