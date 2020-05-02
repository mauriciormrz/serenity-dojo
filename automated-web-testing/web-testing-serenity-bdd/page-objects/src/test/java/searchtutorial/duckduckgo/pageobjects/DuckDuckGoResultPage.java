package searchtutorial.duckduckgo.pageobjects;

import net.serenitybdd.core.pages.PageObject;


import java.util.List;
import java.util.stream.Collectors;

public class DuckDuckGoResultPage extends PageObject {

    public static final String RESULT_TITLE = ".result__title";
    public static final String SEARCH_RESULT_ENTRY = "//div[contains(@class,'result__body') and contains(.,'{0}')]";

    public List<String> getDisplayedResults() {

        return findAll(RESULT_TITLE)
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getSnippetForResultFrom(String keyword) {

        return findBy(SEARCH_RESULT_ENTRY, keyword)
                .then().findBy(".result__snippet")
                .then().getText();
    }
}

