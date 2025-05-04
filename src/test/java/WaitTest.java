import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {
    WebDriver driver;

    @BeforeMethod
    public void WaitCExa(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void waitTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds for visibility
        By buttonLocator = By.id("j_idt87:j_idt89"); // Replace By locator with your actual element
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        element.click();

        // Wait for Clickability

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By buttonLocator2 = By.id("j_idt87:j_idt95");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator2));
        button.click();
        Thread.sleep(2000);

      // Wait for Text Change (1 - 10 Sec)
        // Locator for the element whose text will change
      //  By statusLocator = By.id("j_idt87:j_idt98");

        // Wait up to 10 seconds for the text to be "Success"
       // WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
     //   wait.until(ExpectedConditions.textToBePresentInElementLocated(statusLocator, "Success"));

       // System.out.println("Text changed to 'Success'");

    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000); // 🕒 Waits for 3 seconds before closing the browser
            driver.quit();      // ✅ Closes all browser windows and ends the session
        }
    }
}
