package TTCH_C8165_prod.CAU_HINH;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class setUp {
    WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException
    {
        System.setProperty("webdriver.edge.driver","D:\\IntelliJ\\selenium_java\\browserDriver\\edgedriver_win32\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://ttch165-portal.gtelots.dev/");
        //Login
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-element-4")));
        driver.findElement(By.id("ext-element-5")).sendKeys("222222");
        driver.findElement(By.id("ext-element-21")).sendKeys("Gtel!@#123");
        driver.findElement(By.id("ext-element-39")).click();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }
}
