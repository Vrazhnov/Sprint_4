import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.page.MainPageScooter;
import ru.yandex.page.OrderPage;
import static org.junit.Assert.assertTrue;

// аннотация для запуска с параметризацией
@RunWith(Parameterized.class)
//класс с автотестом оформления заказа
public class OrderCreationTests {

    private WebDriver driver;
    // переменная с именем
    String firstName;
    // переменная с фамилией
    String secondName;
    // переменная с адресом
    String address;
    // переменная с названием станции метро
    String metroStation;
    // переменная с номером телефона
    String telephoneNumber;
    // переменная с датой, которую нужно ввести в поле
    String calendarDate;
    // переменная со значением срока аренды
    String rentalPeriod;
    // переменная со значением цвета
    String color;
    // переменная со значением комментария
    String comment;

    // конструктор с параметрами
    public OrderCreationTests(String firstName, String secondName, String address, String metroStation, String telephoneNumber, String calendarDate, String rentalPeriod, String color, String comment) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephoneNumber = telephoneNumber;
        this.calendarDate = calendarDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] geOrderData() {
        return new Object[][] {
                {"Филипп", "Киркоров", "Улица Пушкина, Дом Колотушкина", "Сокольники", "88005553535", "Choose суббота, 1-е апреля 2023 г.", "сутки", "чёрный жемчуг", "это задание заставило меня страдать :'-( "},
                {"Николай", "Басков", "ул. Баскова, д.Баскова", "Лубянка", "88007777777", "Choose среда, 29-е марта 2023 г.", "трое суток", "серая безысходность", ""},
        };
    }

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
        objOrderPage.fillCustomerInfo(firstName, secondName, address, metroStation, telephoneNumber);
        objOrderPage.clickNextButton();
        objOrderPage.fillRentDetail(calendarDate, rentalPeriod, color, comment);
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