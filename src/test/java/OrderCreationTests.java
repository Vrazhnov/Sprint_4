import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.page.MainPageScooter;
import ru.yandex.page.OrderPage;
import static org.junit.Assert.assertTrue;

//класс с автотестом оформления заказа
public class OrderCreationTests {

    private WebDriver driver;

    @Before
    public void setup() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        objMainPage.waitForLoadCookieButton();
        // нажимаем на кнопку "да все привыкли"
        objMainPage.clickCookieButton();
    }

    // тест создания заказа через верхнюю кнопку "Закзать"
    @Test
    public void checkOrderCreationWithTopButton() {
        // создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // нажимаем на верхнюю кнопку "Заказать"
        objMainPage.clickOrderTopButton();
        // создание объекта класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);
        // выполняем сценарий
        objOrderPage.waitForLoadFirstNameField();
        objOrderPage.customerInfo("Филипп", "Киркоров", "Улица Пушкина, Дом Колотушкина", "88005553535" );
        objOrderPage.waitForLoadDeliveryDateField();
        objOrderPage.clickDeliveryDateField();
        objOrderPage.waitForLoadCalendarDateField();
        objOrderPage.clickFirstCalendarDate();
        objOrderPage.clickRentalPeriodField();
        objOrderPage.waitForLoadRentalPeriodList();
        objOrderPage.clickFirstRentalPeriod();
        objOrderPage.clickBlackScooterColorCheckbox();
        objOrderPage.setCommentField("это задание заставило меня страдать :'-( ");
        objOrderPage.clickOrderButton();
        objOrderPage.waitForLoadYesButton();
        objOrderPage.clickYesButton();
        /* делаем проверку, что заголовок диалога "Заказ оформлен" виден
        P.S. тест упадет, т.к. в Chrome, по нажатию на Да, не уходит запрос, поэтому элемент "Заказ оформлен" не будет найден*/
        assertTrue(objOrderPage.isMessageOrderIsProcessedVisible());
    }

    // тест создания заказа через нижнюю кнопку "Закзать"
    @Test
    public void checkOrderCreationWithBottomButton() {
        // создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // нажимаем на верхнюю кнопку "Заказать"
        objMainPage.clickOrderTopButton();
        // создание объекта класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);
        // выполняем сценарий
        objOrderPage.waitForLoadFirstNameField();
        objOrderPage.customerInfo("Николай", "Басков", "ул. Баскова, д.Баскова", "88007777777" );
        objOrderPage.waitForLoadDeliveryDateField();
        objOrderPage.clickDeliveryDateField();
        objOrderPage.waitForLoadCalendarDateField();
        objOrderPage.clickSecondCalendarDate();
        objOrderPage.clickRentalPeriodField();
        objOrderPage.waitForLoadRentalPeriodList();
        objOrderPage.clickFirstRentalPeriod();
        objOrderPage.clickBlackScooterColorCheckbox();
        objOrderPage.setCommentField("");
        objOrderPage.clickOrderButton();
        objOrderPage.waitForLoadYesButton();
        objOrderPage.clickYesButton();
        /* делаем проверку, что заголовок диалога "Заказ оформлен" виден
        P.S. тест упадет, т.к. в Chrome, по нажатию на Да, не уходит запрос, поэтому элемент "Заказ оформлен" не будет найден*/
        assertTrue(objOrderPage.isMessageOrderIsProcessedVisible());
    }
    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}