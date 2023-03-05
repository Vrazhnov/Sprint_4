import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.page.MainPageScooter;

// аннотация для запуска с параметризацией
@RunWith(Parameterized.class)
//класс с автотестом раздела «Вопросы о важном»
public class QuestionAboutImportantTests {

    private WebDriver driver;
    // переменная с текстом вопроса
    String question;
    // переменная с текстом ответа
    String answer;

    // конструктор с параметрами
    public QuestionAboutImportantTests(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // метод для получения данных
    @Parameterized.Parameters
    public static Object[][] getQuestionAndAnswer() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

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

    @Test
    public void checkAnswerHowToPay() {
        // создание объекта класса галвной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);
        // нажимаем на элементс текстом вопроса
        objMainPage.clickQuestion(question);
        /* дожидаемся загрузки элемента с текстом ответа на главной странице
           по сути проверка происходит уже на данном шаге.*/
        objMainPage.waitForLoadAnswer(answer);
        // получаем текст открывшегося ответа
        String factTextHowToPayAnswer = objMainPage.getAnswerText(answer);
        // делаем проверку, что полученное значение совпадает с правильным текстом ответа
        MatcherAssert.assertThat(factTextHowToPayAnswer, is(answer));
    }

    @After
    public void tearDown() {
        // Закрываем браузер
        driver.quit();
    }
}