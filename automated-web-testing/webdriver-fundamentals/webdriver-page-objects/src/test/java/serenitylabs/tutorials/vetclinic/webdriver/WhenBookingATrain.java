package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static serenitylabs.tutorials.vetclinic.webdriver.DeparturePreference.ArriveBefore;


public class WhenBookingATrain {

    WebDriver driver;

    @Before
    public void setup() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.sydneytrains.info/");
    }

    @Test
    public void should_be_able_to_plan_a_trip() {

        Traveller traveller = new Traveller(driver);
        traveller.departureStationIs("Town Hall");
        traveller.destinationStationIs("Parramata");
        traveller.theTrainShould(ArriveBefore, 10, 15, TravelDay.Tomorrow);

        TripPreferences displayedTripPreferences = traveller.displayedTripPreferences();
        List<WebElement> tripOptions = driver.findElements(By.cssSelector(".summary-header"));

        TripPreferences expectedTripPreferences =
                TripPreferences.arrivingOrDeparting("Arr")
                .arrivingOn("Tomorrow")
                .at("10", "15");

        assertThat(tripOptions.size(), is(greaterThan(0)));

        assertThat(displayedTripPreferences, equalTo(expectedTripPreferences));

    }



    @After
    public void shutdown() {

        driver.quit();
    }
}