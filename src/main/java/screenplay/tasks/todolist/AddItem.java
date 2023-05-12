package screenplay.tasks.todolist;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import screenplay.user_interface.TodoList;

public class AddItem implements Task {

    private String name;

    private AddItem(String name) {
        this.name = name;
    }

    @Override
    @Step("{0} adds an item to the list")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(name)
                        .into(TodoList.TODO_ITEM_TXT)
                        .thenHit(Keys.RETURN)
        );
    }

    public static AddItem called(String name) {
        return Instrumented
                .instanceOf(AddItem.class)
                .withProperties(name);
    }
}
