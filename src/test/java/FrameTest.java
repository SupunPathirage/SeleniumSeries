import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.List;

public class FrameTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://leafground.com/frame.xhtml");

        // 1. Switch to the iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

        // 2. Click the button inside the iframe
        WebElement clickMeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
        clickMeButton.click();
        System.out.println("Clicked the button inside iframe.");

        // 3. Handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("Alert accepted.");

        // 4. Switch back to main content (if you need to interact outside the iframe again)
        driver.switchTo().defaultContent();

        driver.quit();

    }


}
