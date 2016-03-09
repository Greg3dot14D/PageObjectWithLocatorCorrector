package ru.greg3d.factory.fielddecorator.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import ru.greg3d.factory.container.AbstractContainer;

/**
 * Annotation that is used to set a corrector for a block of elements or for an element in a block
 * or for a page object element.
 * <p/>
 * For example:
 * <p/>
 * <pre class="code">
 * @Corrector(what="_WHAT_TEXT")
 * public class MyButtons extends AbstractContainer {
 * ...
 * @FindBy(css = "button_WHAT_TEXT_css")
 * public Button myButton;
 * ..
 * }
 * 
 * class SomePage{
 * 
 * @Corrector(than="_THAN_TEXT")
 * @FindBy(css = "someButton_THAN_TEXT_css")
 * public MyButtons buttons;
 * <p/>
 * // Other elements and methods here
 * }
 * </pre>
 *
 * @author Greg3D
 *         Date: 09.03.16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Corrector {
    String what() default "";
    String than() default "";
}
