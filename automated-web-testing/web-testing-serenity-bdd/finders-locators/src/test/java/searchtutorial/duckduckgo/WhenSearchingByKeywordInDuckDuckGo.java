package searchtutorial.duckduckgo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import searchtutorial.duckduckgo.steps.DuckDuckGoSearcher;

@RunWith(SerenityRunner.class)
public class WhenSearchingByKeywordInDuckDuckGo {

    @Steps
    DuckDuckGoSearcher mauricio;

    @Managed
    WebDriver driver;

    @Test
    public void should_see_relevant_search_results() {

        mauricio.is_on_the_duckduckgo_homepage();
        mauricio.searches_by_keyword_for("Cucumber");
        mauricio.should_see_only_results_containing("Cucumber");

    }

    @Test
    public void wikipedia_entry_should_show_snippet() {

        mauricio.is_on_the_duckduckgo_homepage();
        mauricio.searches_by_keyword_for("Cucumber");
        mauricio.should_see_entry_snippet_with_contents("Cucumber - Wikipedia",
                "Cucumber (Cucumis sativus) is a widely cultivated plant in the gourd family");

    }
}
