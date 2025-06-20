package runners.cucumber.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.openqa.selenium.WebElement;
import pom.pages.TodoListPage;
import screenplay.model.Label;
import screenplay.questions.todolist.Items;
import screenplay.tasks.todolist.AddAnItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TodoStepDefinitions {

    TodoListPage todoListPage;

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

    @When("he adds {} to his list")
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

    @Given("parameters are collected as map")
    public void parametersAreCollectedAsMap(List<Map<String, String>> data) {
     System.out.println("data processed is " + data);
    }

    @DataTableType()
    public Map<String, String> convert(Map<String, String> parametersMap){
        return parametersMap.entrySet()
                .stream()
                .map(TodoStepDefinitions::removeQuotesFromEntryValue)
                .collect(HashMap::new,
                        (newMap, originalMap) -> newMap.put(originalMap.getKey(), nullIfEmpty(originalMap.getValue())),
                        HashMap::putAll
                );
    }

    public static Map.Entry<String, String> removeQuotesFromEntryValue(Map.Entry<String, String> entry) {
        return Map.entry(entry.getKey(), entry.getValue().replaceAll("\"", ""));
    }

    public static Map.Entry<String, String> replaceNullIfEmpty(Map.Entry<String, String> entry) {
        return Map.entry(entry.getKey(), entry.getValue().replaceAll("", null));
    }

    /**
     * Returns null if the input is empty.
     *
     * @param param The input string.
     * @return The param or null if the input is empty.
     */
    public static String nullIfEmpty(String param){
        return !param.isEmpty() ? param : null;
    }

    @Given("parameters are collected as list")
    public void parametersAreCollectedAsList(List<String> data) {
        System.out.println(data);
    }

    @When("parameters are transposed in a list")
    public void parametersAreTransposedAsList(@Transpose List<String> entry) {
        System.out.println(entry);
    }

    @Then("the setting is available")
    public void stepThree(DataTable settingsTable){
            List<String> options = settingsTable.asList(String.class);
            List<String> matchingOptions = settingsTable.asList(String.class);
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(matchingOptions)
                .as("All options are available")
                .containsExactlyInAnyOrderElementsOf(options);
            sa.assertAll();
        }



}
