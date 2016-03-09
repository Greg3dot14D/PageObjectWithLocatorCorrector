package ru.greg3d.factory.container;

import org.openqa.selenium.WebElement;
import ru.greg3d.factory.elements.TypifiedElement;;

public interface Container{
    void init(WebElement wrappedElement);
}
