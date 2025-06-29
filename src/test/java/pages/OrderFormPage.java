package pages;

import org.openqa.selenium.*;

public class OrderFormPage {

    private WebDriver driver;

    // Поле ввода имени
    private By nameInput = By.cssSelector("input[placeholder='* Имя']");
    // Поле ввода фамилии
    private By surnameInput = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле ввода адреса
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле ввода станции метро
    private By stationInput = By.className("select-search__input");
    // Поле ввода номера телефона
    private By phoneNumberInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    //
    private By nextButton = By.className("Button_Middle__1CSJM");
    //
    private By dateInput = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    //
    private By deadlineDropdown = By.className("Dropdown-root");
    //
    private By daysDropdown = By.className("Dropdown-option");
    //
    private By color = By.cssSelector("label[for='black']");
    //
    private By orderButton = By.xpath("(//button[contains(text(),'Заказать')])[2]");
    //
    private By acceptButton = By.xpath("(//button[contains(text(),'Да')])");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void setStation(String station) {
        driver.findElement(stationInput).click();
        driver.findElement(By.xpath("//div[contains(text(),'"+ station + "')]")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        WebElement element = driver.findElements(nextButton).get(0);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(nextButton).click();
    }

    public void setDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);
    }

    public void setDeadline(int daysNumber) {
        driver.findElement(deadlineDropdown).click();
        driver.findElements(daysDropdown).get(daysNumber).click();
    }

    public void setColor() {
        driver.findElement(color).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickAcceptButton() {
        driver.findElement(acceptButton).click();
    }

}
