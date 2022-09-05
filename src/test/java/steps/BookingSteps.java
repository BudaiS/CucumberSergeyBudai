package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.BookingSearchPage;
import pages.BookingSearchResultPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingSteps {
    private WebDriver driver;
    private BookingSearchPage bookingSearchPage;
    private BookingSearchResultPage bookingSearchResultPage;
    private String searchWord;

    @Before
    public void initialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchResultPage = new BookingSearchResultPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Word for search is {string}")
    public void wordForSearchIs(String arg0) {
        this.searchWord = arg0;
    }

    @And("I enters search word")
    public void iEntersSearchWord() {
        bookingSearchPage.setSearchInputValue(searchWord);
    }

    @And("I press search button")
    public void iPressSearchButton() {
        bookingSearchPage.clickSearchButton();
    }

    @When("I navigate to booking.com")
    public void iNavigateToBookingCom() {
        bookingSearchPage.open();
    }

    @Then("There is a hotel with this name")
    public void thereIsAHotelWithThisName() {
        String firstResultText = bookingSearchResultPage.getSearchResultTitleByIndex(1);
        boolean doesContains = firstResultText.toLowerCase().trim().contains(searchWord.toLowerCase().trim());
        Assert.assertTrue(doesContains);
    }


    @And("Hotel rating {string}")
    public void hotelRating(String rating) {
        List<String> ratings = bookingSearchResultPage.getRating();
        Assert.assertEquals(ratings.get(0), rating);
    }
}
