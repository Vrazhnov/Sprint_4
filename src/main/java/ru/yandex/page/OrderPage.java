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
    //поле "Станция метро", элемент "Лубянка" в списке
    private By metroStationLubyanka = By.xpath("//*[text()='Лубянка']");
    //поле "Станция метро", элемент "Сокольники" в списке
    private By metroStationValueSokolniki = By.xpath("//*[text()='Сокольники']");
    //поле "Телефон: на него звонит курьер"
    private By telephoneNumberField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[5]/input");
    //кнопка "Далее"
    private By nextButton = By.xpath("//*[@id=\'root\']/div/div[2]/div[3]/button");
    //поле "Когда привезти самокат"
    private By deliveryDateField = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //календарь в поле "Когда привезти самокат"
    private By calendarDateField = By.className("react-datepicker");
    //поле "Когда привезти самокат", значение календаря "01.04.2023"
    private By firstCalendarDate = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[6]");
    //поле "Когда привезти самокат", значение календаря "02.04.2023"
    private By secondCalendarDate = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[7]");
    //поле "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-control");
    //выпадающий список поля "Срок аренды"
    private By rentalPeriodList = By.className("Dropdown-option");
    //значение срока аренды "сутки"
    private By firstRentalPeriod = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    //значение срока аренды "трое суток"
    private By secondRentalPeriod = By.xpath("//*[@id=\'root\']/div/div[2]/div[2]/div[2]/div[2]/div[3]");
    //поле "Цвет самоката", чек-бокс "чёрный жемчуг"
    private By blackScooterColorCheckbox = By.id("black");
    //поле "Цвет самоката", чек-бокс "серая безысходность"
    private By greyScooterColorCheckbox = By.id("grey");
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
    //метод ввода значения в поле "Станция метро"
    public void setMetroStationField() {
        driver.findElement(metroStationField).click();
    }
    // ожидание открытия списка в поле "Станция метро"
    public void waitForLoadStationSokolniki() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(metroStationLubyanka));
    }
    //метод ввода значения в поле "Станция метро"
    public void setMetroStationSokolniki() {
        driver.findElement(metroStationLubyanka).click();
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
    //метод нажатия на значение календаря "01.04.2023"
    public void clickFirstCalendarDate() {
        driver.findElement(firstCalendarDate).click();
    }
    //метод нажатия на значение календаря "02.04.2023"
    public void clickSecondCalendarDate() {
        driver.findElement(secondCalendarDate).click();
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
    //метод нажатия на значение срока аренды "сутки"
    public void clickFirstRentalPeriod() {
        driver.findElement(firstRentalPeriod).click();
    }
    //метод нажатия на значение срока аренды "трое суток"
    public void clickSecondRentalPeriod() {
        driver.findElement(secondRentalPeriod).click();
    }
    //метод нажатия на чек-бокс "чёрный жемчуг"
    public void clickBlackScooterColorCheckbox() {
        driver.findElement(blackScooterColorCheckbox).click();
    }
    //метод нажатия на чек-бокс "серая безысходность"
    public void clickGreyScooterColorCheckbox() {
        driver.findElement(greyScooterColorCheckbox).click();
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
    public void customerInfo(String firstName, String secondName, String address, String telephoneNumber) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        setMetroStationField();
        waitForLoadStationSokolniki();
        setMetroStationSokolniki();
        setTelephoneNumber(telephoneNumber);
        clickNextButton();
    }

}
