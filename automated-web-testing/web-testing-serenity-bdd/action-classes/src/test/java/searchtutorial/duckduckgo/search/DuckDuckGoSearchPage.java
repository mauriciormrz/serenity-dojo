package searchtutorial.duckduckgo.search;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://duckduckgo.com")
public class DuckDuckGoSearchPage extends PageObject {

    static final String SEARCH_INPUT_FIELD = "#search_form_input_homepage";
    static final String SEARCH_BUTTON = "#search_button_homepage";

}
