package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.LeaveAfter;

public class TripPlannerForm {


    public static final By TRAVEL_DAY = By.cssSelector("#search-select-date");
    public static final By TIME_HOUR = By.cssSelector("#search-select-hour");
    public static final By TIME_MINUTE = By.cssSelector("#search-select-minute");

    static final Map<DeparturePreference, By> DEPARTURE_BUTTONS = new HashMap<>();

    static {
        DEPARTURE_BUTTONS.put(ArriveBefore, By.cssSelector(".btn-default.arriving"));
        DEPARTURE_BUTTONS.put(LeaveAfter, By.cssSelector(".btn-default.leaving"));
    }

    public static By departureButtonFor(DeparturePreference departurePreference) {
        return DEPARTURE_BUTTONS.get(departurePreference);
    }
}
