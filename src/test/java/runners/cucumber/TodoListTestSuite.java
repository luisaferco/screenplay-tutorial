package runners.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty",  "html:target/cucumber-reports.html"},
        features = "src/test/resources/features/todomvc/add_new_items.feature",
        glue = "runners.cucumber.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
        ,tags = "@solo"
)
public class TodoListTestSuite {}
