package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dashboard;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private Dashboard dashboardPage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/serj/IdeaProjects/QA_Lessons/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        dashboardPage = new Dashboard(driver);

    }

    @Test
            public void loginWithValidCreds() {
            mainPage.clickSingIn();
            loginPage.loginWithCreds("QAtestLessonOne","QAUkraine79");
            dashboardPage.clickDropDown();
            Assert.assertEquals(dashboardPage.getProfilaName(), "QAtestLessonOne");

    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
