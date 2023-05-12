package runners.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import org.hamcrest.Matchers;
import screenplay.questions.travelocity.DepartingFlight;
import screenplay.questions.travelocity.DepartureFlight;
import screenplay.tasks.saucedemo.NavigateTo;
import screenplay.tasks.travelocity.SearchFlight;

import java.util.Collections;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;

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
    @Then("he should see information trips")
    public void heShouldSeeInformationTrips() {
        theActorInTheSpotlight().should(
                seeThat(DepartureFlight.list(),  Matchers.hasItem("BOS"))
        );
    }

    @Then("he should see the selected departure flight")
    public void heShouldSeeTheSelectedDepartureFlight() {
        theActorInTheSpotlight().should(
                seeThat(DepartingFlight.selected(),Matchers.is(("Boston (BOS)")))
        );

    }
}
