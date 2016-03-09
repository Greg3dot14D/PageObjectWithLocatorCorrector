package ru.greg3d.factory.elements;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
    <E extends TypifiedElement> E create(Class<E> elementClass, WebElement wrappedElement);
}
