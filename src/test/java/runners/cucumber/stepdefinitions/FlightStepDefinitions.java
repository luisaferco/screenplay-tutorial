package runners.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import org.hamcrest.Matchers;
import screenplay.questions.booking.DepartureFlight;
import screenplay.tasks.saucedemo.NavigateTo;
import screenplay.tasks.booking.SearchFlight;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FlightStepDefinitions {

    @Given("{actor} navigates to the Flights sections")
    public void navigatesToTheFlightsSections(Actor actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.booking"),
                NavigateTo.flights());


    }
    @When("he searches for flights from {string} to {string}")
    public void heSearchesForFlights(String departureCity, String arrivingCity) {
        theActorInTheSpotlight().attemptsTo(
                SearchFlight.leavingFrom(departureCity)
                        .to(arrivingCity)
        );
    }
    @Then("he should see the flight information")
    public void heShouldSeeInformationTrips() {
        theActorInTheSpotlight().should(
                seeThat(DepartureFlight.list(),  Matchers.hasItem("BOS"))
        );
    }

}
