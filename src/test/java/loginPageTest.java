import io.netty.channel.ChannelPipeline;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.JVM) // данная аннотация позволяет запускать набор тестов строго по порядку
public class loginPageTest {
    WebDriver driver;
    loginPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://online.mkb.ru/");
    }

    @Test
    public void logIn() { // тестовый метод, отвечающий за вход пользователя на сайт
        page = new loginPage(driver);
        page.unableToLogin("Avtotest", "123456");
        page.clickLogIn();
        String error = page.getErrorText();
        // сравнение ожидаемого текста ошибки с фактическим
        Assert.assertEquals("Ошибка аутентификации.\n" + "Проверьте правильность указания логина и пароля.", error);
    }
    @Test
    public void logIn1() { // тестовый метод для введения пароля и клика на кнопку "Войти"
        page = new loginPage(driver);
        page.typePassword("123456");
        page.clickLogIn();
    }
    @Test
    public void logIn2() { // // тестовый метод для введения пароля и клика на кнопку "Войти"
        page = new loginPage(driver);
        page.typePassword("123456");
        page.clickLogIn();
    }
    @Test
    public void logIn3() { //// тестовый метод для введения пароля и клика на кнопку "Войти"
        page = new loginPage(driver);
        page.typePassword("123456");
        page.clickLogIn();
    }

    @After
    public void shoutDown() {
        driver.quit();
    }
    /*В итоге: все тесты проходят успешно. Есть определённые требования, которые были выполнены, а что при этом
    происходит на странице - не важно (в том плане, что в личный кабинет мы в любом случае не зайдём*/

    /*Другой момент: так как тесты запускаются в случайном порядке, то какой-либо тест может провалиться из-за
    * автоматизированного управления, т.е. робота, и как следствие возникнет капча, которую трудно предугадать
    * Вариантов несколько: либо запускать их по-отдельности в ручную (что муторно и времязатратно), либо
    * поставить порядок выполнения (я выбрала @FixMethodOrder, он независим от названий тест-классов)*/

}

