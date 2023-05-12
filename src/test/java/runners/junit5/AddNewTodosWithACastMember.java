package runners.junit5;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import screenplay.tasks.todolist.AddAnItem;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodosWithACastMember {

    @CastMember(name="the coordinator")
    Actor toby;

    @Test
    @DisplayName("Add a todo item to an empty list")
    void addToEmptyList() {
            toby.attemptsTo(Open.browserOn().thePageNamed("pages.angular"),
                    AddAnItem.withAListContainingItems("task 1", "task 2", "task 3"));

    }


}
