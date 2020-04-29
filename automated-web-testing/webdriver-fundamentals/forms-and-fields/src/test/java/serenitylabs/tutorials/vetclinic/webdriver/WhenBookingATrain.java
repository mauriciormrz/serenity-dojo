package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

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

        driver.findElement(By.id("tniFromTripLocation")).sendKeys("Town Hall");

        WebElement destination = driver.findElement(By.id("tniToTripLocation"));
        destination.sendKeys("Parramatta");
        destination.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector(".btn.btn-primary.go-btn")).click();
        driver.findElement(By.cssSelector("#time-tab span.tab-title")).click();

        driver.findElement(By.cssSelector(".arriving")).click();
        driver.findElement(By.id("search-select-date")).click();
        driver.findElement(By.cssSelector("#search-select-date option:nth-child(2)")).click();

        Select hour = new Select(driver.findElement(By.cssSelector("#search-select-date")));
        //hour.selectByVisibleText("09");

        List<WebElement> tripOptions = driver.findElements(By.cssSelector(".summary-header"));
        assertThat(tripOptions.size(), is(greaterThan(0)));

        //Select arriveOrDepart = new Select(driver.findElement(By.cssSelector("#SelectArriveDepart")));
        //assertThat(arriveOrDepart.getFirstSelectedOption().getText()
        //equalTo("arrive before"));

    }


    @After
    public void shutdown() {

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
