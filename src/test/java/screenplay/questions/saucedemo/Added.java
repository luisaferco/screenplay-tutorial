package screenplay.questions.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.TodoList;

import java.util.Collection;

@Subject("items added to todo list")
public class Added implements Question<Collection<String>> {


    @Override
    public Collection<String> answeredBy(Actor actor) {
        return Text.ofEach(TodoList.ITEMS).answeredBy(actor);
    }

    public static Added items() {
        return new Added();
    }
}
