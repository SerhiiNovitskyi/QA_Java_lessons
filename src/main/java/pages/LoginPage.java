package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {
    WebDriver driver;

    private WebDriverWait
            wait;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver, 5);
        this.driver= driver;
    }
    @FindBy (id="login_field")
    private WebElement loginfield;

    @FindBy (id="password")
    private WebElement passwordField;

    @FindBy (xpath = "//input[@type='submit']")
    private WebElement signInButton;

    private By loginFieldLocator = By.xpath("//*[@id='login_field']");

    public LoginPage typeUsername(String username) {
    wait.until(ExpectedConditions.presenceOfElementLocated(loginFieldLocator));
        loginfield.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage loginWithCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        signInButton.click();
        return new LoginPage(driver);
    }


}
