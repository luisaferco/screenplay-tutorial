package screenplay.tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.model.NavigationComponent;
import screenplay.user_interface.booking.BookingPage;

import java.time.Duration;

public class NavigateTo implements Task {

    private final String option;

    public NavigateTo(String option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                WaitUntil.the(BookingPage.CLOSE_MODAL, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(Duration.ofSeconds(5)),
                Click.on(BookingPage.CLOSE_MODAL),
                Click.on(BookingPage.NAVIGATION_FORM.of(option))
        );
    }
    public static NavigateTo flights(){
        return Tasks.instrumented(NavigateTo.class, NavigationComponent.FLIGHTS.getOption());
    }
}
