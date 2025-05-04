import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CalanderExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void openCalendarTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
        Thread.sleep(3000);
    }

    @Test
    public void calendarTest() throws InterruptedException {

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //Method 1
//        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
//       datePicker.sendKeys("15/04/2025");

        //Method 2
        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.click();
        selectPastDate("2025", "April", "15");
        Thread.sleep(2000);
    }


    public void selectFutureDate(String year, String month, String day){
        while(true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            } else{
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElemnt : allDates) {
            if(dateElemnt.getText().equals(day)){
                dateElemnt.click();
                break;
            }
        }
    }


    public void selectPastDate(String year, String month, String day){
        while(true){
            String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            if (actualYear.equals(year) && actualMonth.equals(month)){
                break;
            } else{
                driver.findElement(By.xpath("//a[@title='Prev']")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));

        for (WebElement dateElemnt : allDates) {
            if(dateElemnt.getText().equals(day)){
                dateElemnt.click();
                break;
            }
        }
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000);
            driver.quit();  // ✅ Closes all browser windows and ends the session
        }
    }
}

