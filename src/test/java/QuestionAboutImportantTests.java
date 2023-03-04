import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.page.MainPageScooter;

//класс с автотестом раздела «Вопросы о важном»
public class QuestionAboutImportantTests {

    private WebDriver driver;
    // переменная с текстом ответа на вопрос «Сколько это стоит? И как оплатить?»
    String howToPayAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    // переменная с текстом ответа на вопрос «Как рассчитывается время аренды?»
    String howToCalculateTimeAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    @Before
    public void initialize() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // находим элемент с вопросом «Сколько это стоит? И как оплатить?»
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        // делаем скролл до найденного элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // проверка вопроса «Сколько это стоит? И как оплатить?»
    @Test
    public void checkAnswerHowToPay() {
        // создание объекта класса галвной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // нажимаем на вопрос как платить
        objMainPage.clickHowToPayQuestion();
        // дожидаемся загрузки данных на главной странице
        objMainPage.waitForLoadHowToPayAnswer();
        // получаем текст открывшегося ответа
        String factTextHowToPayAnswer = objMainPage.answerTextHowToPay();
        // делаем проверку, что полученное значение совпадает с правильным текстом ответа
        MatcherAssert.assertThat(factTextHowToPayAnswer, is(howToPayAnswer));
    }
    // проверка вопроса «Как рассчитывается время аренды?»
    @Test
    public void checkAnswerHowToCalculateTime() {
        // создание объекта класса галвной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // нажимаем на вопрос как платить
        objMainPage.clickHowToCalculateTimeQuestion();
        // дожидаемся загрузки данных на главной странице
        objMainPage.waitForLoadHowToCalculateTimeAnswer();
        // получаем текст открывшегося ответа
        String factTextHowToCalculateTimeAnswer = objMainPage.answerTextHowToCalculateTime();
        // делаем проверку, что полученное значение совпадает с правильным текстом ответа
        MatcherAssert.assertThat(factTextHowToCalculateTimeAnswer, is(howToCalculateTimeAnswer));
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}