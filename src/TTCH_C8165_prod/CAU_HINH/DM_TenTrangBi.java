package TTCH_C8165_prod.CAU_HINH;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DM_TenTrangBi {
    WebDriver driver;

    @BeforeTest
    public void Setup() throws InterruptedException {
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
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/form/div[1]/div/div/div[1]/div/div[1]/div/div[1]/div[5]/div[1]/div[1]/div[1]/div/button")).click();
        driver.manage().window().maximize();
    }
    @Test
    public void CreateLoaiTrangBi() throws InterruptedException {
        //truy cập form tạo loại phương tiện
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div.ant-layout.ant-layout-has-sider.css-1nfjog > aside > div.ant-layout-sider-children > div > ul > li:nth-child(10)")));
        driver.findElement(By.cssSelector("#root > div > div > div.ant-layout.ant-layout-has-sider.css-1nfjog > aside > div.ant-layout-sider-children > div > ul > li:nth-child(10)")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thiết lập danh mục')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Thiết lập danh mục')]")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Tên trang bị')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Tên trang bị')]")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Thêm mới')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Thêm mới')]")).click();
        //tạo loại phương tiện
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='equipmentTypeCode']")));
        driver.findElement(By.xpath("//input[@id='equipmentTypeCode']")).sendKeys("M1");
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"equipmentGroupName\"]")));
        driver.findElement(By.xpath("//*[@id=\"equipmentGroupName\"]")).sendKeys("Súng cầm tay");
        //handle combo box
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='equipmentGroupCode']")));
        driver.findElement(By.xpath("//input[@id='equipmentGroupCode']")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Xe ô tô')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Xe ô tô')]")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='equipmentTypeStatusCode']']")));
        driver.findElement(By.xpath("//input[@id='equipmentTypeStatusCode']")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Kích hoạt']//div[1]")));
        driver.findElement(By.xpath("//div[@title='Kích hoạt']//div[1]")).click();
        //submit
        driver.findElement(By.xpath("//button[contains(text(),'Tạo tên trang bị')]")).click();
        SoftAssert softAssert = new SoftAssert();
        WebElement notiSuccess = driver.findElement(By.xpath("//button[contains(text(),'Tạo loại trang bị')]"));
        boolean isDisplayed = notiSuccess.isDisplayed();
        softAssert.assertTrue(isDisplayed,"Pop up is showed");
    }

//    public void DeleteTrangbi() {
////        //td[.='s']
////        //*[@id="equipment-group"]/div/div[2]/table/tbody/tr[2]
////        #equipment-group > div > div.ant-table-body > table > tbody > tr:nth-child(2) > td.ant-table-cell.ant-table-cell-fix-right.ant-table-cell-fix-right-first > div > div:nth-child(1) > button
//    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
