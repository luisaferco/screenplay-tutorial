package runners.cucumber;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/travelocity/booking_flight.feature",
        glue = "runners.cucumber.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@ignore"
)
public class BookingTestSuite {
}
