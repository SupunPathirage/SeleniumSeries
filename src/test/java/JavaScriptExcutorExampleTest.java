import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExcutorExampleTest {

    WebDriver driver;

    @BeforeClass
    public void jsee(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecutorTests(){

    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000); // 🕒 Waits for 3 seconds before closing the browser
            driver.quit();      // ✅ Closes all browser windows and ends the session
        }
    }
}