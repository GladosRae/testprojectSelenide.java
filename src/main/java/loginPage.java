import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class loginPage {

    private By loginField = By.cssSelector("input#txtLogin");
    private By passwordField = By.cssSelector("input#txtPassword");
    private By loginButton = By.xpath("//div[@id='btnLoginStandard']");
    private String errorText = "//div[@id=\"errMessage\" and contains(text(), \"Ошибка аутентификации.\")]";

    public loginPage open() {
        Selenide.open("https://online.mkb.ru/");
        return this;
    }

    public loginPage typeLogIn(String login) {
        $(loginField).setValue(login);
        return this;
    }
    public loginPage typePassword(String password) {
        $(passwordField).setValue(password);
        return this;
    }
    public loginPage clickLogIn() {
        $(loginButton).click();
        return this;
    }
    public loginPage unableToLogin(String login, String password) {
        this.typeLogIn(login);
        this.typePassword(password);
        return new loginPage();
    }

    public SelenideElement getErrorText() {
        return $(xpath(errorText));
    }

}
