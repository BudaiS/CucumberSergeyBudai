package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchResultPage extends BasePage {
    private final static By SEARCH_RESULTS_LOCATOR = By.xpath("//li[contains(@class, 'serp-item') and not(contains(@style, 'display: none'))]");

    public YandexSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultsCount() {
        return driver.findElements(SEARCH_RESULTS_LOCATOR).size();
    }

    public String getSearchResultTitleByIndex(int index) {
        return driver.findElements(SEARCH_RESULTS_LOCATOR).get(index - 1).getText();
    }

}
