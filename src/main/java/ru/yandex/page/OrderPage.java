package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс с элементами страницы заказа
public class OrderPage {

    private WebDriver driver;
    //поле "Имя"
    private By firstNameField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[1]/input");
    //поле "Фамилия"
    private By secondNameField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[2]/input");
    //поле "Адрес: куда привезти заказ"
    private By addressField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[3]/input");
    //поле "Станция метро"
    private By metroStationField = By.className("select-search__input");
    //поле "Телефон: на него звонит курьер"
    private By telephoneNumberField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[5]/input");
    //кнопка "Далее"
    private By nextButton = By.xpath("//*[@id=\'root\']/div/div[2]/div[3]/button");
    //поле "Когда привезти самокат"
    private By deliveryDateField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //календарь в поле "Когда привезти самокат"
    private By calendarDateField = By.className("react-datepicker");
    //поле "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-control");
    //выпадающий список поля "Срок аренды"
    private By rentalPeriodList = By.className("Dropdown-option");
    //поле "Комментарий для курьера"
    private By commentField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[4]/input");
    //кнопка "Заказать"
    private By orderButton = By.xpath("//*[@id=\'root\']/div/div[2]/div[3]/button[2]");
    //кнопка "Да" в диалоге "Хотите оформить заказ?"
    private By yesButton = By.xpath("//*[text()='Да']");
    //заголовок  диалога "Заказ оформлен"
    private By orderIsProcessed = By.xpath("//*[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    // ожидание появления поля "Имя"
    public void waitForLoadFirstNameField() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }
    //метод ввода значения в поле "Имя"
    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //метод ввода значения в поле "Фамилия"
    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //метод ввода значения в поле "Адрес: куда привезти заказ"
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
    //метод нажатия в поле "Станция метро" для получения списка
    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }
    // ожидание открытия списка в поле "Станция метро"
    public void waitForLoadStation(String metroStation) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", metroStation))));
    }
    //метод выбора значения из списка в поле "Станция метро"
    public void setMetroStation(String metroStation) {
        driver.findElement(By.xpath(String.format("//*[text()='%s']", metroStation))).click();
    }
    //метод ввода значения в поле "Телефон: на него звонит курьер"
    public void setTelephoneNumber(String telephoneNumber) {
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }
    //метод нажатия на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    // ожидание появления поля "Когда привезти самокат"
    public void waitForLoadDeliveryDateField() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDateField));
    }
    //метод нажатия в поле "Когда привезти самокат"
    public void clickDeliveryDateField() {
        driver.findElement(deliveryDateField).click();
    }
    // ожидание появления календаря в поле "Когда привезти самокат"
    public void waitForLoadCalendarDateField() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(calendarDateField));
    }
    //метод нажатия на значение календаря
    public void clickCalendarDate(String calendarDate) {
        driver.findElement(By.xpath(String.format("//*[@aria-label='%s']", calendarDate))).click();
    }
    //метод нажатия в поле "Срок аренды"
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }
    // ожидание появления списка в поле "Срок аренды"
    public void waitForLoadRentalPeriodList() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(rentalPeriodList));
    }
    //метод нажатия на значение срока аренды
    public void selectRentalPeriod(String rentalPeriod) {
        driver.findElement(By.xpath(String.format("//*[text()='%s']", rentalPeriod))).click();
    }
    //метод нажатия на чек-бокс со значением цвета
    public void selectColorCheckbox(String color) {
        driver.findElement(By.xpath(String.format("//*[text()='%s']", color))).click();
    }
    //метод ввода значения в поле "Комментарий для курьера"
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //метод нажатия на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }
    // ожидание появления кнопки "Да" в диалоге "Хотите оформить заказ?"
    public void waitForLoadYesButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
    }
    //метод нажатия на кнопку "Да" в диалоге "Хотите оформить заказ?"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    // ожидание появления диалога с заголовком "Заказ оформлен"
    public void waitForLoadOrderIsProcessed() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(orderIsProcessed));
    }
    //метод для проверки "Для кого самокат"
    public boolean isMessageOrderIsProcessedVisible() {
        return driver.findElement(orderIsProcessed).isDisplayed();
    }
    //метод заполнения формы "Для кого самокат" (чтобы немного сократить код в самом тесте)
    public void fillCustomerInfo(String firstName, String secondName, String address, String metroStation, String telephoneNumber) {
        waitForLoadFirstNameField();
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        clickMetroStationField();
        waitForLoadStation(metroStation);
        setMetroStation(metroStation);
        setTelephoneNumber(telephoneNumber);

    }
    //метод заполнения формы "Про аренду" (чтобы немного сократить код в самом тесте)
    public void fillRentDetail(String calendarDate, String rentalPeriod, String color, String comment) {
        waitForLoadDeliveryDateField();
        clickDeliveryDateField();
        waitForLoadCalendarDateField();
        clickCalendarDate(calendarDate);
        clickRentalPeriodField();
        waitForLoadRentalPeriodList();
        selectRentalPeriod(rentalPeriod);
        selectColorCheckbox(color);
        setCommentField(comment);
    }
}
