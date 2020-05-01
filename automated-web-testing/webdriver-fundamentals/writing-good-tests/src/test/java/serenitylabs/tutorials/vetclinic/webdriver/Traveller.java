package serenitylabs.tutorials.vetclinic.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;



public class Traveller {

    private WebDriver driver;

    private static final DecimalFormat TIME_UNIT_FORMAT = new DecimalFormat("##");


    public Traveller(WebDriver driver){

        this.driver = driver;
    }

    public TripPreferences displayedTripPreferences(){

        String arrivePlan = driver.findElement(By.cssSelector("#time-tab span.tab-title")).getText();
        arrivePlan =arrivePlan.replace(":", " ").replace(",","");

        String [] vect = arrivePlan.split(" ");
        String arriveOrDepart = vect[0];
        String arrivalHour = vect[1];
        String arrivalMinute = vect[2];
        String arrivalDay = vect[3];

        return TripPreferences.arrivingOrDeparting(arriveOrDepart)
                .arrivingOn(arrivalDay)
                .at(arrivalHour, arrivalMinute);
    }

    public void theTrainShould(DeparturePreference departurePreference,
                                int hour,
                                int minute,
                                TravelDay travelDay) {

        driver.findElement(By.cssSelector(".btn.btn-primary.go-btn")).click();
        driver.findElement(By.cssSelector("#time-tab tni-icon.tab-arrow")).click();

        driver.findElement(TripPlannerForm.departureButtonFor(departurePreference)).click(); //driver.findElement(By.cssSelector(".btn-default.arriving")).click();

        //new Select(driver.findElement(By.cssSelector("#search-select-date")))
        //        .selectByIndex(travelDay.getDaysInFuture()); //driver.findElement(By.cssSelector("#search-select-date option:nth-child(2)")).click();

        new Select(driver.findElement(TripPlannerForm.TRAVEL_DAY))
                .selectByIndex(travelDay.getDaysInFuture()); //driver.findElement(By.cssSelector("#search-select-date option:nth-child(2)")).click();

        Select hourList = new Select(driver.findElement(TripPlannerForm.TIME_HOUR));
        hourList.selectByVisibleText(TIME_UNIT_FORMAT.format(hour));

        Select minuteList = new Select(driver.findElement(TripPlannerForm.TIME_MINUTE));
        minuteList.selectByVisibleText(TIME_UNIT_FORMAT.format(minute));
    }

    public void destinationStationIs(String station) {
        WebElement destination = driver.findElement(By.id("tniToTripLocation"));
        destination.sendKeys(station);
        destination.sendKeys(Keys.TAB);
    }

    public void departureStationIs(String station) {
        driver.findElement(By.id("tniFromTripLocation")).sendKeys(station);
    }
}
