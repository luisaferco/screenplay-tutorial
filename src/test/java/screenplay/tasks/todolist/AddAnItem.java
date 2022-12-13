package screenplay.tasks.todolist;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import screenplay.ui.TodoList;

import java.util.Arrays;

public class AddAnItem {


        public static Performable called(String name){
                return Task.where("{0} add un item called " +name,
                        Enter.theValue(name).into(TodoList.TODO_ITEM_TXT).thenHit(Keys.ENTER)
                );
        }

        public static Performable withAListContainingItems(String... items){
                return Task.where("{0} add multiple items " + Arrays.asList(items),
                        actor -> {
                                for(String item: items){
                                        actor.attemptsTo(AddAnItem.called(item));
                                }
                        }
                );
        }
}
