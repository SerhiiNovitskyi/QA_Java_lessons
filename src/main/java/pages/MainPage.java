package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver= driver;
    }

    @FindBy (xpath ="//a[contains(@class, 'HeaderMenu-link') and contains(text(),'in')]" )
    private WebElement signInButton;


    public void clickSingIn() {
        signInButton.click();
    }

}
