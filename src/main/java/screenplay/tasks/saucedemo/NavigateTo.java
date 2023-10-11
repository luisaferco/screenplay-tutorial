package screenplay.tasks.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.matchers.statematchers.IsCurrentlyVisibleMatcher;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
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
                Check.whether(Visibility.of(BookingPage.CLOSE_MODAL).answeredBy(theActor))
                                .andIfSo(Click.on(BookingPage.CLOSE_MODAL)),
                Click.on(BookingPage.NAVIGATION_FORM.containingText(option))
        );
    }
    public static NavigateTo flights(){
        return Tasks.instrumented(NavigateTo.class, NavigationComponent.FLIGHTS.getOption());
    }
}
