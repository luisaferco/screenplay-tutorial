package screenplay.user_interface.booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPage {

    public static final Target CLOSE_MODAL = Target.the("close modal button")
            .located(By.cssSelector("#b2indexPage div.b8ef7618ca.b2ed5869b1 > div > button > span > span > svg > path"));

    public static final Target NAVIGATION_FORM = Target.the("navigation component {0}")
            .locatedBy("//a[@aria-controls='{0}']");

    public static final Target LEAVING_FROM_BTN = Target.the("leaving from option")
            .located(By.cssSelector("button[data-ui-name='input_location_from_segment_0']"));

    public static final Target GOING_TO_BTN = Target.the("going to option")
            .located(By.cssSelector("button[data-ui-name='input_location_to_segment_0']"));

    public static final Target OPT_DEPARTURE_CITY = Target.the("first departure city option")
            .located(By.cssSelector("#__bui-10  li:nth-child(1)"));

    public static final Target DEPARTURE_TXT = Target.the("leaving from")
            .located(By.cssSelector("#__bui-10 input"));

    public static final Target OPT_ARRIVING_CITY = Target.the("first departure city option")
            .located(By.cssSelector("#__bui-12  li:nth-child(1)"));

    public static final Target ARRIVING_TXT = Target.the("leaving from")
            .located(By.cssSelector("#__bui-12  input"));

    public static final Target SEARCH_BTN = Target.the("Search button")
            .located(By.cssSelector("button[data-ui-name='button_search_submit']"));

}
