package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends Page {
    WebDriver driver;

    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver= driver;
    }
    @FindBy (xpath = "(//span[@class='dropdown-caret'])[2]")
    private WebElement dropDownList;

    @FindBy (xpath = "//strong[@class='css-truncate-target']")
    private WebElement accountName;

    public Dashboard clickDropDown() {
        dropDownList.click();
        return this;
    }

    public String getProfilaName() {
        return accountName.getText();
    }

}





