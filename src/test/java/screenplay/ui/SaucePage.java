package screenplay.ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SaucePage {

    public static final Target PRODUCTS_BTN = Target.the("add to cart buttons")
            .located(By.cssSelector(".pricebar button"));
}
