package screenplay.tasks.booking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static screenplay.user_interface.booking.BookingPage.*;

public class SearchFlight implements Task {

    private String from;
    private String to;

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(LEAVING_FROM_BTN),
                Hit.the(Keys.BACK_SPACE).into(DEPARTURE_TXT),
                Enter.theValue(from).into(DEPARTURE_TXT).thenHit(Keys.ENTER),
                Click.on(OPT_DEPARTURE_CITY),
                Click.on(GOING_TO_BTN),
                Enter.theValue(to).into(ARRIVING_TXT).thenHit(Keys.ENTER),
                Click.on(OPT_ARRIVING_CITY),
                Click.on(SEARCH_BTN)
        );
    }

    public static SearchFlight leavingFrom(String from){
        return instrumented(SearchFlight .class, from);
    }
    public SearchFlight to(String to){
        this.to = to;
        return this;
    }

    public SearchFlight(String from) {this.from = from; }


}
