package screenplay.runners.cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.ConditionalPerformable;
import net.serenitybdd.screenplay.conditions.ConditionalPerformableOnQuestion;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import screenplay.questions.saucedemo.Added;
import screenplay.tasks.todolist.AddAnItem;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TodoStepDefinitions {

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
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.angular"),
                RememberThat.theValueOf("tarea").is("limpiar casa")

        );

    }

    @When("he adds {string} to his list")
    public void he_adds_to_his_list(String name) {
        String tarea = theActorInTheSpotlight().recall("tarea");
        theActorInTheSpotlight().attemptsTo(
             //   Check.whether(Text.of(By.tagName("h1")), Matchers.equalTo("todo"))
                CheckWhether(Added.items(),Matchers.hasItem("Buy some milk"))
                        .andIfSo(AddAnItem.called(tarea))
                        .otherwise(AddAnItem.called("agregar algo"))
                );
    }

    @Then("the todo list should contain the following items:")
    public void the_todo_list_should_contain(List<String> expectedItems) {
        theActorInTheSpotlight().should(
                seeThat(Added.items(), containsInAnyOrder(expectedItems.toArray()))
        );
    }

    /**
    * @author Luisa.
    *
    * <p>Custom Conditional para utilizar questions de cualquier tipo generico,
    * la limitante es que el parametro question de la clase Check.whether de la libreria
    * de screenplay no admite objetos de tipo genérico donde el argumento de tipo es un comodín
    * solo de tipo concreto.
    * Ejemplos de tipos paramterizados genericos donde el argumento de tipo es un comodin:
    * <pre>{@code
    *       Collection<?>
    *       List<? extiende Número>
    *       Comparador<? super String>
    *       }</pre>
    * El metodo se crea para aceptar questions con parametros de tipo generico y Matcher acepte esos
    * parametros de una instancia de tipo generico con cuaquier argumento
    * Un objecto List y todas sus variantes que requiere
    * argumentos de tipo
    *
    * </a>
    * @param question Question<? extends T>
    * @param matcher Matcher<T>
    *
    * */
    public static <T> ConditionalPerformable CheckWhether(Question<? extends T> question, Matcher<T> matcher) {
        Question<Boolean> condition = (actor) -> matcher.matches(question.answeredBy(actor));
        return new ConditionalPerformableOnQuestion(condition);
    }
}
