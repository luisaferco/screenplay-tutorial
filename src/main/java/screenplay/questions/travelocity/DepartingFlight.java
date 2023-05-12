package screenplay.questions.travelocity;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static screenplay.user_interface.booking.FlightResultsPage.FLIGHT_OPT;

public class DepartingFlight implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(FLIGHT_OPT).answeredBy(actor);
    }

    public static DepartingFlight selected() {
        return new DepartingFlight();
    }
}

