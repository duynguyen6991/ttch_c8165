import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Create instance of ChromeOptions Class
        EdgeOptions handlingSSL = new EdgeOptions();
        //Using the accept insecure cert method with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);
        System.setProperty("webdriver.chrome.driver","D:\\IntelliJ\\selenium_java\\browserDriver\\edgedriver_win32\\msedgedriver.exe" );
        WebDriver driver = new EdgeDriver(handlingSSL);
        driver.get("https://sb-straffic.gtelots.dev/auth/login");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-form_userName")).sendKeys("123-123");
        String[] passList = {" 21123", "12312", "Abc@123456"};
        for (int i = 0; i < passList.length; i++) {
            driver.findElement(By.id("login-form_password")).clear();
            driver.findElement(By.id("login-form_password")).sendKeys(passList[i]);
            driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > div > div > div > div > button")).click();
            try {
                // Print the text of the notification element
                System.out.println("Pass " + i + " response: " + driver.findElement(By.className("ant-form-item-explain-error")).getText());
            } catch (Exception e) {
                // Handle if the notification element is not found or text retrieval fails
                System.out.println("Unable to retrieve notification message for pass " + i);
            }
        }

        driver.quit();
    }
}