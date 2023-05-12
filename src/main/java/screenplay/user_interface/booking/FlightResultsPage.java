package screenplay.user_interface.booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FlightResultsPage {

    public static final Target DEPARTURE_LIST = Target.the("Departure list")
            .located(By.cssSelector("div[data-testid='flight_card_segment_departure_airport_0']"));

    public static final Target FLIGHT_OPT = Target.the("departing flight selected text")
            .locatedBy(".departing-flight-trip");

    public static final Target SEARCH_TAB_BEST = Target.the("Bests options tab")
            .located(By.cssSelector("button[data-testid='search_tabs_BEST']"));
}
