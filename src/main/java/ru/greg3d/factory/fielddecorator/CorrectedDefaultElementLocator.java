package ru.greg3d.factory.fielddecorator;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;

public class CorrectedDefaultElementLocator implements ElementLocator {

	private final SearchContext searchContext;
	private final boolean shouldCache;
	private final By by;
	private WebElement cachedElement;
	private List<WebElement> cachedElementList;

	public CorrectedDefaultElementLocator(SearchContext searchContext, Field field,
			LocatorCorrector corrector) {
		this(searchContext, new CorrectedAnnotations(field, corrector));
	}

	public CorrectedDefaultElementLocator(SearchContext searchContext,
			CorrectedAbstractAnnotations annotations) {
		this.searchContext = searchContext;
		this.shouldCache = annotations.isLookupCached();
		this.by = annotations.buildBy();
	}

	/**
	 * Find the element.
	 */
	@Override
	public WebElement findElement() {
		if (cachedElement != null && shouldCache) {
			return cachedElement;
		}

		WebElement element = searchContext.findElement(by);
		if (shouldCache) {
			cachedElement = element;
		}

		return element;
	}

	/**
	 * Find the element list.
	 */
	@Override
	public List<WebElement> findElements() {
		if (cachedElementList != null && shouldCache) {
			return cachedElementList;
		}

		List<WebElement> elements = searchContext.findElements(by);
		if (shouldCache) {
			cachedElementList = elements;
		}

		return elements;
	}
}
