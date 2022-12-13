package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TodoList {

    public static final Target TODO_ITEM_TXT = Target.the("add item field").located(By.className("new-todo"));

    public static final Target ITEMS = Target.the("items added")
            .locatedBy(".todo-list li");
}
