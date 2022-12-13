package screenplay.tasks.saucedemo;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;

public class Login {

    public static Performable as(String username, String password){
        return Task.where("{0} login as " + username,
                Enter.theValue(username).into("#user-name"),
                Enter.theValue(password).into(By.id("password")),
                Click.on("#login-button").afterWaitingUntilEnabled()
                );
    }
}
