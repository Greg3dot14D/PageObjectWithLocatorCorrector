package ru.greg3d.factory.elements;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Optional;

/**
 * Represents text input control (such as &lt;input type="text"/&gt; or &lt;textarea/&gt;).
 *
 * @author Alexander Tolmachev starlight@yandex-team.ru
 *         Date: 13.08.12
 */
public class TextInput extends TypifiedElement {
    /**
     * Specifies wrapped {@link WebElement}.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public TextInput(WebElement wrappedElement) {
        super(wrappedElement);
    }

    /* (non-Javadoc)
	 * @see ru.greg3d.factory.elements.implementations.TextInputI#clear()
	 */
    //@Override
	public void clear() {
        getWrappedElement().clear();
    }

    /* (non-Javadoc)
	 * @see ru.greg3d.factory.elements.implementations.TextInputI#sendKeys(java.lang.CharSequence)
	 */
   // @Override
	public void sendKeys(CharSequence... keys) {
        getWrappedElement().sendKeys(keys);
    }

    /* (non-Javadoc)
	 * @see ru.greg3d.factory.elements.implementations.TextInputI#getEnteredText()
	 */
    //@Override
	@Deprecated
    public String getEnteredText() {
        return getText();
    }

    /* (non-Javadoc)
	 * @see ru.greg3d.factory.elements.implementations.TextInputI#getText()
	 */
    //@Override
	public String getText() {
        if ("textarea".equals(getWrappedElement().getTagName())) {
            return getWrappedElement().getText();
        }

        return Optional.of(getWrappedElement().getAttribute("value")).orElse("");
    }

    /* (non-Javadoc)
	 * @see ru.greg3d.factory.elements.implementations.TextInputI#getClearCharSequence()
	 */
    //@Override
	public String getClearCharSequence() {
        return StringUtils.repeat(Keys.DELETE.toString() + Keys.BACK_SPACE, getText().length());
    }
}
