package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YandexSamokatPage {

    private WebDriver driver;

    private By accordionItem = By.className("accordion__item");
    private By textsInAccordeons = By.tagName("p");

    public YandexSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToAccordeonElements(int itemNumber) {
        WebElement element = driver.findElements(accordionItem).get(itemNumber);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void openAccordionItem(int itemNumber) {
        driver.findElements(accordionItem).get(itemNumber).click();
    }

    public String getTextFromAccordeons(int itemNumber) {
        return driver.findElements(textsInAccordeons).get(itemNumber).getText();
    }
}
