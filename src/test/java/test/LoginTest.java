package test;

//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Dashboard;
import pages.LoginPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private static WebDriver driver;
    private static MainPage mainPage;
    private static LoginPage loginPage;
    private static Dashboard dashboardPage;


    @BeforeAll
    public static void setUp(){
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
            assertEquals(dashboardPage.getProfilaName(), "QAtestLessonOne");

    }



    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
