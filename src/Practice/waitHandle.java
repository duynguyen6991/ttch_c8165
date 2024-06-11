package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class waitHandle {
    WebDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","D:\\IntelliJ\\selenium_java\\browserDriver\\edgedriver_win32\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void waitHandle() throws InterruptedException {
        WebElement confirmBoxBtn = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][normalize-space()='Click me!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmBoxBtn));
        confirmBoxBtn.click();

        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());

    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
