package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OrderFormPage;
import pages.YandexSamokatPage;

public class OrderFormTest {

    private WebDriver driver;

    @ParameterizedTest
    @CsvSource({
            "Егор, Иванов, ул. Берегового 43, Черкизовская, +74943874378, 01.07.2025, 1",
            "Ольга, Петрова, ул. Шаляпина 67, Сокольники, +74932656453, 02.07.2025, 2"
            })
    public void createOrdersWithDifferentDataAreSuccess(String name, String surname, String address, String station, String phoneNumber, String date, int deadLine) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        YandexSamokatPage yandexSamokatPage = new YandexSamokatPage(driver);
        OrderFormPage orderFormPage = new OrderFormPage(driver);

        yandexSamokatPage.clickCookieButton();
        yandexSamokatPage.clickOrderButton();
        orderFormPage.setName(name);
        orderFormPage.setSurname(surname);
        orderFormPage.setAddress(address);
        orderFormPage.setStation(station);
        orderFormPage.setPhoneNumber(phoneNumber);
        orderFormPage.clickNextButton();
        orderFormPage.setDate(date);
        orderFormPage.setDeadline(deadLine);
        orderFormPage.setColor();
        orderFormPage.clickOrderButton();
        orderFormPage.clickAcceptButton();

        orderFormPage.orderSuccessModalWindowIsVisible();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
