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
   //Верхняя кнопка "Заказать"
    private By orderTopButton = By.className("Button_Button__ra12g");
    //Нижняя кнопка "Заказать"
    private By orderBottomButton = By.className("Home_FinishButton__1_cWm");
    //кнопка закрытия сообщения о куки "да все привыкли"
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    public MainPageScooter(WebDriver driver){
        this.driver = driver;
    }
    //метод нажатия на элемент с вопросом
    public void clickQuestion(String question) {
        driver.findElement(By.xpath(String.format("//*[text()='%s']", question))).click();
    }
    // ожидание загрузки текста ответа
    public void waitForLoadAnswer(String answer) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text()='%s']", answer))));
    }
    // метод для получения раскрывшегося текста с ответом
    public String getAnswerText(String answer) {
        return driver.findElement(By.xpath(String.format("//*[text()='%s']", answer))).getText();
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

}
