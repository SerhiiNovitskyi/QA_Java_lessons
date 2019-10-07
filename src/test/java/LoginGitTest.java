import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


public class LoginGitTest {
    @Test
    public void main() {
        WebDriver driver;
        File chromeDriver = new File("/Users/serj/IdeaProjects/QA_lessons/lib/chromedriver");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeService, chromeOptions);


        driver.get("http://www.github.com/"); // open page
        driver.findElement(By.xpath("//a[contains(@class, 'HeaderMenu-link') and contains(text(),'Sign')]")).click();
        driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("QAtestLessonOne");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("QAUkraine79");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        driver.findElement(By.xpath("(//span[@class='dropdown-caret'])[2]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//strong[@class='css-truncate-target']")).getText(),"QAtestLessonOne");
        driver.close();
    }
}