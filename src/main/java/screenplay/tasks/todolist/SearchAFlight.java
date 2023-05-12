package screenplay.tasks.todolist;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SearchAFlight implements Task {

    private String startDate;
    private String endDate;

    private SearchAFlight(String startDate){
        this.startDate = startDate;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }

    public static SearchAFlight from(String startDate){
        return Instrumented.instanceOf(SearchAFlight.class)
                .withProperties(startDate);
    }

    public SearchAFlight to(String endDate){
        this.endDate = endDate;
        return this;
    }
}
