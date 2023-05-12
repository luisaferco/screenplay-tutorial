package runners.cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import screenplay.questions.todolist.Items;
import screenplay.tasks.todolist.AddAnItem;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TodoListStepDefinitions {

    @Before
    public void setStage () {
        OnStage.setTheStage(new OnlineCast());
    }

    @ParameterType(".*")
    public Actor actor(String name){
        return OnStage.theActorCalled(name);
    }

    @Given("{actor} starts with an empty list")
    public void stats_with_an_empty_list(Actor actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.angular")
        );
    }

    @When("he adds {string} to his list")
    public void he_adds_to_his_list(String toDo) {
        theActorInTheSpotlight().attemptsTo(
                AddAnItem.called(toDo));
    }

    @Then("the todo list should contain the following items:")
    public void the_todo_list_should_contain(List<String> expectedItems) {
        theActorInTheSpotlight().should(
                seeThat(Items.toDo(), containsInAnyOrder(expectedItems.toArray()))
        );
    }

}
