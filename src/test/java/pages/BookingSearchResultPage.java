package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BookingSearchResultPage extends BasePage {
    private final static By SEARCH_RESULTS_LOCATOR = By.cssSelector("[data-testid='title']");
    private final static By RATING_RESULTS_LOCATOR = By.cssSelector("[data-testid='review-score-link']");

    public BookingSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultTitleByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS_LOCATOR).get(index - 1).getText();
    }

    public List<String> getRating() {
        List<String> ratings = new ArrayList<>();
        List<WebElement> elements = driver.findElements(RATING_RESULTS_LOCATOR);
        for (WebElement element : elements) ratings.add(element.getText());
        return ratings;
    }
}
