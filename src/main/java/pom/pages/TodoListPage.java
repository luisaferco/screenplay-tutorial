package pom.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoListPage extends PageObject {

    @FindBy(className = "new-todo")
    private WebElement addItem;

    public void addTask(String item) {
        addItem.sendKeys(item);
    }
}
