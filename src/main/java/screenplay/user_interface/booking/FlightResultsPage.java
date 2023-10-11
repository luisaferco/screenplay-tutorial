package screenplay.user_interface.booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightResultsPage {

    public static final Target DEPARTURE_LIST = Target.the("Departure list")
            .located(By.cssSelector("li[data-test-id='offer-listing'] button"));

    public static final Target FLIGHT_OPT = Target.the("departing flight selected text")
            .locatedBy(".departing-flight-trip");

    public static final Target SELECT_SORT_BY = Target.the("Select option sort by filter ")
            .located(By.cssSelector("#sort-filter-dropdown-SORT"));
}
