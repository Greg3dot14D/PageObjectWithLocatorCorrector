package ru.greg3d.factory.fielddecorator;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import ru.greg3d.factory.elements.DefaultElementFactory;
import ru.greg3d.factory.elements.ElementFactory;
import ru.greg3d.factory.elements.TypifiedElement;
import ru.greg3d.factory.fielddecorator.model.LocatorCorrector;
import ru.greg3d.factory.container.*;

public class CorrectedFieldDecorator extends DefaultFieldDecorator {

	// public CorrectedFieldDecorator(final SearchContext searchContext) {
	// super(new CorrectedDefaultElementLocatorFactory(searchContext, new
	// LocatorCorrector()));
	// }

	public CorrectedFieldDecorator(final SearchContext searchContext, LocatorCorrector corrector) {
		super(new CorrectedDefaultElementLocatorFactory(searchContext, corrector));
	}

	private ElementFactory elementFactory = new DefaultElementFactory();

	@Override
	public Object decorate(final ClassLoader loader, final Field field) {
		if (Container.class.isAssignableFrom(field.getType())) {
			return decorateContainer(loader, field);
		}

		if (TypifiedElement.class.isAssignableFrom(field.getType())) {
			return decorateElement(loader, field);
		}
		return super.decorate(loader, field);
	}

	private Object decorateElement(final ClassLoader loader, final Field field) {
		final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
		return elementFactory.create((Class<? extends TypifiedElement>) field.getType(), wrappedElement);
	}

	private ElementLocator createLocator(final Field field) {
		System.out.println("createLocator field :" + field.toString());
		return factory.createLocator(field);
	}

	private ContainerFactory containerFactory = new DefaultContainerFactory();

	private Object decorateContainer(final ClassLoader loader, final Field field) {
		System.out.println("decorate container :" + field.toString());
		final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
		final Container container = containerFactory.create((Class<? extends Container>) field.getType(),
				wrappedElement);
		final LocatorCorrector corrector = new LocatorCorrector().setWhat(field.getType()).setThan(field);

		PageFactory.initElements(new CorrectedFieldDecorator(wrappedElement, corrector), container);
		return container;
	}
}
