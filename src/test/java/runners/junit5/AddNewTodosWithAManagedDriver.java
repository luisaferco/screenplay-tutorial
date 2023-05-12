package runners.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import screenplay.questions.travelocity.DepartureFlight;
import screenplay.tasks.todolist.SearchAFlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

@ExtendWith(SerenityJUnit5Extension.class)
class AddNewTodosWithAManagedDriver {

    @Managed
    WebDriver driver;

    @Test
    @DisplayName("Add a departure date")
    void addADepartureDate() {
        Actor toby = Actor.named("Toby").whoCan(BrowseTheWeb.with(driver));
            toby.attemptsTo(
                    Open.browserOn().thePageNamed("pages.angular"),
                    SearchAFlight
                        .from("2022/12/10")
                        .to("2022/12/15"));

            toby.should(seeThat(DepartureFlight.list(), Matchers.hasSize(10)));
    }



}
