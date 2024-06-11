package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;

public class Alert_Handle {
    WebDriver driver;
    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","D:\\IntelliJ\\selenium_java\\browserDriver\\edgedriver_win32\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        driver.manage().window().maximize();
    }
    @Test
    public void Handle_Alert() throws InterruptedException {
//        WebElement alertBox = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
//        alertBox.click();
//        System.out.printf(driver.switchTo().alert().getText());

        //Get the changes
        //Ở đây Javascript alert box này có 3 thẻ p, khi nhập tên xong thì gene ra thêm 1 thẻ p, các thẻ này đều theo câấu trúc
        // *[@id="easycont"]/div/div[2]/div[3]/div[2]/p[2] khác nhau thẻ p[] cuối nên ta lấy ra bằng xpath p[4]


        //lấy ra all thẻ con của thẻ div lúc chưa click
        WebElement theDiv = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]"));
        List<WebElement> childsOfTheDiv = theDiv.findElements(By.xpath(".//*"));

        StringBuilder htmlCodeBuilder1 = new StringBuilder();
        StringBuilder htmlCodeBuilder2 = new StringBuilder();

        for (WebElement element : childsOfTheDiv) {
            String htmlCode = element.getAttribute("outerHTML");
            htmlCodeBuilder1.append(htmlCode).append("\n"); // Append HTML code followed by newline character
        }
        // Get the final concatenated HTML code as a String
        String allHtmlCode1 = htmlCodeBuilder1.toString();
        //click button

        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        //chuyê đến alert và nhập tên
        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Truong Duy");
        alert1.accept();
        Thread.sleep(3000);

        //Dùng javascriptexecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //lấy ra new p element (p thứ 4)
//        WebElement newP = driver.findElement(By.xpath("//*[@id=\"prompt-demo\"]"));
//        System.out.println(newP.getText());

        //lấy ra all thẻ con của thẻ div đ click
        WebElement theDiv2 = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]"));
        List<WebElement> childsOfTheDiv2 = theDiv2.findElements(By.xpath(".//*"));
        for (WebElement element : childsOfTheDiv2) {
            String htmlCode2 = element.getAttribute("outerHTML");
            htmlCodeBuilder2.append(htmlCode2).append("\n"); // Append HTML code followed by newline character
        }
        // Get the final concatenated HTML code as a String
        String allHtmlCode2 = htmlCodeBuilder2.toString();
        String allHtmlCode3 = allHtmlCode2.replaceAll(allHtmlCode1,"");
        System.out.println(allHtmlCode1);
        System.out.println(allHtmlCode2);
        System.out.println(allHtmlCode3);

    }
}
