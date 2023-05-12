package runners.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import screenplay.questions.saucedemo.ProductDetails;
import screenplay.tasks.saucedemo.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
class ViewProductCatalog {

    @CastMember(name = "Toby")
    Actor toby;

    @Test
    @DisplayName("View the product catalog")
    void viewProductCatalog() {

    }

    @Test
    @DisplayName("View the product catalog using a Task")
    void viewProductCatalogUsingATask() {
        toby.attemptsTo(Open.url("https://www.saucedemo.com/"),
                Login.as("standard_user","secret_sauce")
        );

        toby.should(seeThat("all products have a purchase button",
                        ProductDetails.haveAButton(), everyItem(equalToIgnoringCase("Add to Cart"))),
                    seeThat("verify data-test attribute",
                            ProductDetails.haveAnElement(), everyItem(containsString("add-to-cart")))
        );

    }



}
