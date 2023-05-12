package screenplay.questions.todolist;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.user_interface.TodoList;

import java.util.Collection;

public class Items implements Question<Collection<String>> {
    @Override
    public Collection<String> answeredBy(Actor actor) {
        return Text.ofEach(TodoList.ITEMS).answeredBy(actor);
    }

    public static Items toDo(){
        return new Items();
    }

}
