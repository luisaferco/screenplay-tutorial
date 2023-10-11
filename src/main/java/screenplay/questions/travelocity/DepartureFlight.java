package screenplay.questions.travelocity;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.user_interface.booking.FlightResultsPage;

import java.time.Duration;
import java.util.Collection;

@Subject("departing flight options")
public class DepartureFlight implements Question<Collection<String>> {


    @Override
    public Collection<String> answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(FlightResultsPage.SELECT_SORT_BY, WebElementStateMatchers.isVisible())
                .forNoMoreThan(Duration.ofSeconds(20)));
        return Text.ofEach(FlightResultsPage.DEPARTURE_LIST).answeredBy(actor);
    }

    public static DepartureFlight list() {
        return new DepartureFlight();
    }
}
