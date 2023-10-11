package runners.pom;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pom.pages.TodoListPage;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodosJunit {

    @Managed
    private WebDriver driver;

    @Steps
    private TodoListPage todoListPage;

    @Test
    public void AddNewItem() {


    }
}
