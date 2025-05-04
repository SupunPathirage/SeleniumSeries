import org.openqa.selenium.Alert;
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

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void alertTestsPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");

    }

    @Test
    public void alertTests() throws InterruptedException {
        //1)Alert (Simple Dialog)

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();
        Alert alert =driver.switchTo().alert(); // dot dot . . . thyala krna ekta kiynneh METHOD CHANING
        Thread.sleep(3000);
        alert.accept();

        //2)Alert (Confirm Dialog)

        WebElement confirmBox = driver.findElement(By.id("j_idt88:j_idt93"));
        confirmBox.click();
        Alert alert1 =driver.switchTo().alert();   // e dapu ewa enter krnma inspect walat wetenna nm accept krnna oni.. search wenat accept wemnna oni
        Thread.sleep(3000);
        alert1.dismiss();

        //3)Alert (Prompt Dialog)
        WebElement promtBox = driver.findElement(By.id("j_idt88:j_idt104"));  // arete ekata swich weemata
        promtBox.click();
        Alert alert2 =driver.switchTo().alert(); // arete ekata swich weemata
        Thread.sleep(3000);
        String alertText = alert2.getText();
        System.out.println("Alert text is : " + alertText);
        alert2.sendKeys("My name is Suppa"); // api dana alert box ekta values
        alert2.accept();  // e dapu ewa enter krnma inspect walat wetenna nm accept krnna oni.. search wenat accept wemnna oni


        WebElement alertBox4 = driver.findElement(By.id("j_idt88:j_idt100"));
        alertBox4.click();

        }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null)
            Thread.sleep(3000);{
            driver.quit();  // ✅ Closes all browser windows and ends the session
        }
    }

    }

