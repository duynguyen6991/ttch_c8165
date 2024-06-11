//// Generated by Selenium IDE
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import static org.junit.Assert.*;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsNot.not;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.Keys;
//import java.util.*;
//import java.net.MalformedURLException;
//import java.net.URL;
//public class TaoLoaiTrangBiTest {
//  private WebDriver driver;
//  private Map<String, Object> vars;
//  JavascriptExecutor js;
//  @Before
//  public void setUp() {
//    driver = new ChromeDriver();
//    js = (JavascriptExecutor) driver;
//    vars = new HashMap<String, Object>();
//  }
//  @After
//  public void tearDown() {
//    driver.quit();
//  }
//  @Test
//  public void taoLoaiTrangBi() {
//    driver.get("http://10.79.21.25/?redirect_to=https://ttch165-portal.gtelots.dev/auth/oauth");
//    driver.manage().window().setSize(new Dimension(1936, 1066));
//    driver.findElement(By.id("ext-element-5")).click();
//    driver.findElement(By.id("ext-element-5")).sendKeys("222222");
//    driver.findElement(By.id("ext-element-21")).click();
//    driver.findElement(By.id("ext-element-21")).sendKeys("Gtel!@#123");
//    driver.findElement(By.id("ext-element-95")).click();
//    {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();
//    }
//    driver.findElement(By.cssSelector(".ant-menu-submenu-active .ant-menu-title-content > .ant-typography")).click();
//    driver.findElement(By.cssSelector(".ant-menu-submenu-title > .ant-menu-title-content:nth-child(1) > .ant-typography > .ant-typography")).click();
//    driver.findElement(By.cssSelector(".ant-menu-item-active .ant-typography > .ant-typography")).click();
//    driver.findElement(By.cssSelector(".css-58yass")).click();
//    driver.findElement(By.id("equipmentGroupCode")).click();
//    driver.findElement(By.id("equipmentGroupCode")).sendKeys("TA11");
//    driver.findElement(By.id("equipmentGroupName")).click();
//    driver.findElement(By.id("equipmentGroupName")).click();
//    driver.findElement(By.id("equipmentGroupName")).sendKeys("Xe thiết giáp");
//    driver.findElement(By.id("equipmentGroupStatusCode")).click();
//    driver.findElement(By.cssSelector(".ant-select-item-option-active > .ant-select-item-option-content")).click();
//    driver.findElement(By.cssSelector(".ant-btn-primary:nth-child(2)")).click();
//    driver.close();
//  }
//}
