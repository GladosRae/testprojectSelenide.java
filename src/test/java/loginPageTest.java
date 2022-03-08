import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class loginPageTest {
    loginPage page;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        open("https://online.mkb.ru/");
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void failedAuthorization() { // тестовый метод, отвечающий за вход пользователя на сайт
        page = new loginPage();
        page.unableToLogin("Avtotest", "123456");
        page.clickLogIn();
        page.getErrorText().shouldBe(Condition.visible);
        //String error = page.getErrorText();
        //сравнение ожидаемого текста ошибки с фактическим
        //Assert.assertEquals("Ошибка аутентификации.\n" + "Проверьте правильность указания логина и пароля.", error);
    }
}

