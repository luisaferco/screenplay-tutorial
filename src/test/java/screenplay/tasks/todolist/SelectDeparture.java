package screenplay.tasks.todolist;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SelectDeparture implements Task {

    private String startDate;
    private String endDate;

    private SelectDeparture(String startDate){
        this.startDate = startDate;
    }

    @Override
    public <T extends Actor> void performAs(T t) {

    }

    public static SelectDeparture from(String startDate){
        return Instrumented.instanceOf(SelectDeparture.class)
                .withProperties(startDate);
    }

    public SelectDeparture to(String endDate){
        this.endDate = endDate;
        return this;
    }
}
