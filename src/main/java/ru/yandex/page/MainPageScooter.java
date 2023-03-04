package ru.yandex.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Класс с элементами главной страницы
public class MainPageScooter {

    private WebDriver driver;
    //Раздел «Вопросы о важном», элемент с вопросом «Сколько это стоит? И как оплатить?»
    private By howToPayQuestion = By.id("accordion__heading-0");
    //Раздел «Вопросы о важном», элемент с вопросом «Как рассчитывается время аренды?»
    private By howToCalculateTimeQuestion = By.id("accordion__heading-2");
    //Раздел «Вопросы о важном», элемент с ответом на вопрос «Сколько это стоит? И как оплатить?»
    private By answerHowToPay = By.id("accordion__panel-0");
    //Раздел «Вопросы о важном», элемент с ответом на вопрос «Как рассчитывается время аренды?»
    private By answerHowToCalculateTime = By.id("accordion__panel-2");
    //Верхняя кнопка "Заказать"
    private By orderTopButton = By.className("Button_Button__ra12g");
    //Нижняя кнопка "Заказать"
    private By orderBottomButton = By.className("Home_FinishButton__1_cWm");
    //кнопка закрытия сообщения о куки "да все привыкли"
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    public MainPageScooter(WebDriver driver){
        this.driver = driver;
    }
    //метод нажатия на элемент с вопросом «Сколько это стоит? И как оплатить?»
    public void clickHowToPayQuestion() {
        driver.findElement(howToPayQuestion).click();
    }
    //метод нажатия на элемент с вопросом «Как рассчитывается время аренды?»
    public void clickHowToCalculateTimeQuestion() {
        driver.findElement(howToCalculateTimeQuestion).click();
    }
    //метод нажатия на верхнюю кнопку "Заказать"
    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }
    //метод нажатия на нижнюю кнопку "Заказать"
    public void clickOrderBottomButton() {
        // находим нижнюю кнопку "Заказать"
        WebElement element = driver.findElement(orderBottomButton);
        // делаем скролл до найденного элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderBottomButton).click();
    }
    //метод нажатия на кнопку "да все привыкли"
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    // ожидание появления кнопки  "да все привыкли"
    public void waitForLoadCookieButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
    }
    // ожидание загрузки текста ответа
    public void waitForLoadHowToPayAnswer() {
        new WebDriverWait(driver, 5)
               .until(ExpectedConditions.visibilityOfElementLocated(answerHowToPay));
   }
    // ожидание загрузки текста ответа
    public void waitForLoadHowToCalculateTimeAnswer() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(answerHowToCalculateTime));
    }

    // метод для получения раскрывшегося текста с ответом на вопрос «Как рассчитывается время аренды?»
    public String answerTextHowToPay() {
        return driver.findElement(answerHowToPay).getText();
    }
    // метод для получения раскрывшегося текста с ответом на вопрос «Сколько это стоит? И как оплатить?»
    public String answerTextHowToCalculateTime() {
        return driver.findElement(answerHowToCalculateTime).getText();
    }


}
