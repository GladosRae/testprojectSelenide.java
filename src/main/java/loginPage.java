import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.cssSelector("input#txtLogin");
    private By passwordField = By.cssSelector("input#txtPassword");
    private By loginButton = By.xpath("//div[@id='btnLoginStandard']");
    private By errorText = By.xpath("//div[@id='errMessage']");

    public loginPage typeLogIn(String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }
    public loginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public loginPage clickLogIn() {
        driver.findElement(loginButton).click();
        return this;
    }
    public loginPage unableToLogin(String login, String password) {
        this.typeLogIn(login);
        this.typePassword(password);
        return new loginPage(driver);
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();
    }

}
