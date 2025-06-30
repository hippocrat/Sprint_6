package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexSamokatPage {

    private WebDriver driver;

    // Кнопка принятия куки
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    // Кнопка Заказать
    private By orderButton = By.className("Button_Button__ra12g");
    // Выпадающий список в разделе «Вопросы о важном»
    private By accordionItem = By.className("accordion__item");
    // Тексты в выпадающем списке в разделе «Вопросы о важном»
    private By textsInAccordeons = By.tagName("p");

    public YandexSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
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
