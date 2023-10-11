package screenplay.user_interface.booking;

import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPage {

    public static final Target CLOSE_MODAL = Target.the("close modal button")
            .located(By.cssSelector("#b2indexPage div.b8ef7618ca.b2ed5869b1 > div > button > span > span > svg > path"));

    public static final SearchableTarget NAVIGATION_FORM = SearchableTarget.the("navigation component")
            .locatedBy("li[role='presentation'] a span");

    public static final Target LEAVING_FROM_BTN = Target.the("leaving from option")
            .located(By.cssSelector("button[data-stid='origin_select-menu-trigger']"));

    public static final Target GOING_TO_BTN = Target.the("going to option")
            .located(By.cssSelector("button[data-stid='destination_select-menu-trigger']"));

    public static final Target OPT_CITY = Target.the("first departure city option")
            .located(By.cssSelector("li:nth-child(1) > div > button"));

    public static final Target DEPARTURE_TXT = Target.the("leaving from")
            .located(By.cssSelector("#origin_select"));


    public static final Target ARRIVING_TXT = Target.the("going to")
            .located(By.cssSelector("#destination_select"));

    public static final Target SEARCH_BTN = Target.the("Search button")
            .located(By.id("search_button"));

}
