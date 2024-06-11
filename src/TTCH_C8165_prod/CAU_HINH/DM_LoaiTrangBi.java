package TTCH_C8165_prod.CAU_HINH;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DM_LoaiTrangBi extends setUp {

    @Test

    public void CreateLoaiTrangBi() throws InterruptedException {
        //truy cập form tạo loại phương tiện
        Thread.sleep(1000);
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > div > div.ant-layout.ant-layout-has-sider.css-1nfjog > aside > div.ant-layout-sider-children > div > ul > li:nth-child(10)")));
        driver.findElement(By.cssSelector("#root > div > div > div.ant-layout.ant-layout-has-sider.css-1nfjog > aside > div.ant-layout-sider-children > div > ul > li:nth-child(10)")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thiết lập danh mục')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Thiết lập danh mục')]")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Loại trang bị')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Loại trang bị')]")).click();
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/div/div[1]/div/div[2]/div[1]/button")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/main/div/div/div/div/div/div[1]/div/div[2]/div[1]/button")).click();
        //tạo loại phương tiện
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"equipmentGroupCode\"]")));
        driver.findElement(By.xpath("//*[@id=\"equipmentGroupCode\"]")).sendKeys("M1");
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"equipmentGroupName\"]")));
        driver.findElement(By.xpath("//*[@id=\"equipmentGroupName\"]")).sendKeys("Súng cầm tay");
        //handle combo box
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='equipmentGroupStatusCode']")));
//        WebElement comboBox =
        driver.findElement(By.xpath("//input[@id='equipmentGroupStatusCode']")).click();
//        Select select = new Select(comboBox);
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Kích hoạt']//div[1]")));
        driver.findElement(By.xpath("//div[@title='Kích hoạt']//div[1]")).click();
//        select.selectByVisibleText("Kích hoạt");
        //submit
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/button[2]")).click();
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
