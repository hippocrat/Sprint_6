package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.YandexSamokatPage;

public class YandexSamokatTest {

    private WebDriver driver;

    @ParameterizedTest
    @CsvSource({
            "0, Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "1, 'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.'",
            "3, Только начиная с завтрашнего дня. Но скоро станем расторопнее."
    })
    public void checkTextsInAccordeonOfImportantQuestions(int itemNumber, String expectedResult) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        YandexSamokatPage yandexSamokatPage = new YandexSamokatPage(driver);

        yandexSamokatPage.scrollToAccordeonElements(itemNumber);
        yandexSamokatPage.openAccordionItem(itemNumber);
        String actualResult = yandexSamokatPage.getTextFromAccordeons(itemNumber);

        Assertions.assertEquals(expectedResult, actualResult, "Текст не совпадает с ожидаемым");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
