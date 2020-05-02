package searchtutorial.duckduckgo.steps;

import net.thucydides.core.annotations.Step;
import searchtutorial.duckduckgo.pageobjects.DuckDuckGoResultPage;
import searchtutorial.duckduckgo.pageobjects.DuckDuckGoSearchPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class DuckDuckGoSearcher {

    private String actor;

    DuckDuckGoSearchPage searchPage;
    DuckDuckGoResultPage resultPage;


    @Step("#actor searches for things relate to {0}")
    public void searches_by_keyword_for(String keyword) {

        searchPage.enterSearchTerms(keyword);
        searchPage.submitSearch();
    }

    @Step("#actos should see only results containing the words {0}")
    public void should_see_only_results_containing(String expectedTerms) {

        List<String> results = resultPage.getDisplayedResults();

        assertThat(results, everyItem(containsString(expectedTerms)));
    }

    @Step("#actor starts on the DuckDuckGo home page")
    public void is_on_the_duckduckgo_homepage() {

        searchPage.open();
    }

    @Step("#actor should see the snippet {1} in the search result entry from '{0}'")
    public void should_see_entry_snippet_with_contents(String keyword, String expectedSnipped) {

        String snippet = resultPage.getSnippetForResultFrom(keyword);
        assertThat(snippet, containsString(expectedSnipped));
    }
}
