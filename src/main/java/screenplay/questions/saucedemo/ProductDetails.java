package screenplay.questions.saucedemo;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.*;
import screenplay.user_interface.SaucePage;

import java.util.Collection;

public class ProductDetails {

    public static Question<Collection<String>> haveAButton(){
        return actor -> Text.ofEach(SaucePage.PRODUCTS_BTN).answeredBy(actor);
    }

    public static Question<Collection<String>> haveAnElement() {
        return actor ->
                Attribute.ofEach(SaucePage.PRODUCTS_BTN).named("data-test").answeredBy(actor);
    }
}
