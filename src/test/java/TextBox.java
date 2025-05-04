import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class TextBox {
    WebDriver driver;

    @BeforeMethod
    public void tb() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void TextTest() throws InterruptedException {

        // Type your Own on the TexBox
        WebElement enterYourOwn = driver.findElement(By.id("j_idt88:name"));
        enterYourOwn.sendKeys("Supun Pathirage");

        WebElement enterYourOwnEX2 = driver.findElement(By.id("j_idt88:j_idt91"));
        enterYourOwnEX2.clear();  // pre define text clean
        enterYourOwnEX2.sendKeys("Australia");

        // Verify The Enable or Disable
        boolean isDisabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println(" you can see the textBox is Disable (F) : " + isDisabled);

        // Retrieve Value From the TextBox to my Terminal
        WebElement getRetrieveValue = driver.findElement(By.id("j_idt88:j_idt97"));
        String storeValue = getRetrieveValue.getAttribute("value");
        System.out.println("Get the value from textbox : " + storeValue);

        // Type and moved to next element.
        WebElement enterThis = driver.findElement(By.id("j_idt88:j_idt99"));
        enterThis.sendKeys("SupunPathirage96@gmail.com");
        Thread.sleep(3000);
        enterThis.sendKeys(Keys.TAB); // Move to next input use (Keys.TAB)
        driver.switchTo().activeElement().sendKeys("Confirmed control moved to next element");
        Thread.sleep(4000);
        enterThis.clear();

        // How to find Error or not

        WebElement errorMassage = driver.findElement(By.id("j_idt106:thisform:age"));
        errorMassage.sendKeys(Keys.ENTER);
        WebElement getError = driver.findElement(By.id("j_idt106:thisform:j_idt110_error-detail"));
        if (getError.isDisplayed()) {
            System.out.println("Error message displayed : " + getError.getText());

        } else {
            System.out.println("Error message not displayed ");
        }

         //  Click and Confirm Label Position Changes

        WebElement clickLable = driver.findElement(By.id("j_idt106:float-input"));
        clickLable.click();
        Thread.sleep(3000);
        if (clickLable.isDisplayed()) {
            System.out.println("Label is Displayed");
        } else {
            System.out.println("Label is not Displayed");
        }

        //  ....... // .....        Type your name and choose the third option................................

        WebElement enterYName = driver.findElement(By.id("j_idt106:auto-complete_input"));
        enterYName.sendKeys("Supun");
        Thread.sleep(3000);

        // 1. Wait for the panel to appear (optional, based on your UI behavior)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement panel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("j_idt106:auto-complete_panel")));

        // 2. Get the list of <li> elements (options)
        List<WebElement> options = panel.findElements(By.tagName("li"));

        // 3. Click the third option (index 2)
        if (options.size() >= 3) {
            options.get(2).click();  // ✅ Clicks the third option
        } else {
            System.out.println("❌ Less than 3 options available.");
        }
        //  ....... // ..... ................................................................................

        // Type your DOB (mm/dd/yyyy) and confirm date chosen

        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt106:j_idt116_input")));
        dateField.click();

                                // 2. Choose the first clickable day (you can randomize this later if needed)
        List<WebElement> allDays = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//*[@id='j_idt106:j_idt116_panel']//table[contains(@class,'ui-datepicker-calendar')]//td/a")
        ));
                               // clickable day links
        if (!allDays.isEmpty()) {
            allDays.get(0).click(); // select the first day in the list
        } else {
            System.out.println("No selectable days found in the calendar.");
        }

                      // 3. Get the selected date from the input field
        String selectedDate = dateField.getAttribute("value");
        System.out.println("Selected Date: " + selectedDate);


      // Type number and spin to confirm value changed ..............................

        WebElement spinnerInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt106:j_idt118_input")));
        // Get initial value
        String initialValue = spinnerInput.getAttribute("value");
        spinnerInput.clear(); // api number type krot clear wenna
        spinnerInput.sendKeys("5");  // Set initial value

// Spinner up button
        WebElement upArrow = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt118']/a[1]"));

// Spinner down button
        WebElement downArrow = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt118']/a[2]"));

// Click up to increase value
        upArrow.click();
        Thread.sleep(2000);

// Click down to decrease value
        downArrow.click();
        Thread.sleep(2000);

// Confirm final value
        String finalValue = spinnerInput.getAttribute("value");

        if (!finalValue.equals(initialValue)) {
            System.out.println("Spinner value changed: " + finalValue);
        } else {
            System.out.println("Spinner value did not change.");
        }

         // Type random number (1-100) and confirm slider moves correctly ...................................

        WebDriverWait randomConf = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sliderInput = randomConf.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt106:slider")));

        // Generate a random number between 1 and 100
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) + 1; // (0-99) + 1 = 1-100
       // int chosenNumber = 42; // if your choice
        sliderInput.clear();
        sliderInput.sendKeys(String.valueOf(randomNumber));
        sliderInput.sendKeys(Keys.TAB);

        String updatedValue = sliderInput.getAttribute("value");

        if (Integer.parseInt(updatedValue) == randomNumber) {
            System.out.println("Slider moved correctly to: " + updatedValue);
        } else {
            System.out.println("Slider did not move as expected. Found: " + updatedValue);
        }
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000); // 🕒 Waits for 3 seconds before closing the browser
            driver.quit();      // ✅ Closes all browser windows and ends the session
        }
    }
    }

