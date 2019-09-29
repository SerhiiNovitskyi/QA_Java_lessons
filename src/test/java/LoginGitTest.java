import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginGitTest {
    @Test
    public void main() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/Users/serj/IdeaProjects/QA_lessons/lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.github.com/"); // open page
        Thread.sleep(5000);  // wait
        driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).click();
        driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("QAtestLessonOne");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("QAUkraine79");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        Thread.sleep(5000);  // wait
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='Header-item position-relative mr-0 d-none d-lg-flex']")).isDisplayed());
        Thread.sleep(5000);  // wait
        driver.close();
    }
}