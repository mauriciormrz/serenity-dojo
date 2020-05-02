package searchtutorial.duckduckgo.pageobjects;



import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://duckduckgo.com")
public class DuckDuckGoSearchPage extends PageObject {

    // 1
    //@FindBy(id ="search_form_input_homepage")
    //WebElementFacade searchField;

    // 2
    //public static final By SEARCH_INPUT_FIELD = (By) By.id("search_form_input_homepage");

    // 3
    public static final String SEARCH_INPUT_FIELD =  "#search_form_input_homepage";

    @FindBy(id = "search_button_homepage")
    WebElementFacade searchButton;

    public void enterSearchTerms(String keyword) {

        // 1
        //searchField.type(keyword);

        // 2
        //find(SEARCH_INPUT_FIELD).type(keyword);

        //3
        $(SEARCH_INPUT_FIELD).type(keyword);
    }

    public void submitSearch() {

        searchButton.click();
    }
}
