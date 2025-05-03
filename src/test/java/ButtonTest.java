import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ButtonTest {
    WebDriver driver;
    @BeforeClass
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }


// Click and Confirm title.
@Test
public void clickButtonTest() throws InterruptedException {
    WebElement cbt = driver.findElement(By.id("j_idt88:j_idt90"));
    cbt.click();
    driver.navigate().back();

    //Confirm if the button is disabled.
    WebElement button = driver.findElement(By.id("j_idt88:j_idt92"));

    if (!button.isEnabled()) {
        System.out.println("✅ Button is disabled.");
    } else {
        System.out.println("❌ Button is enabled.");
    }

    // Find the position of the Submit button
    WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
    Point xypoint = getPosition.getLocation();
    int x = xypoint.getX(); //x akshaya
    int y = xypoint.getY();  // akshaya
    System.out.println("X point is " + x + " and Y point is " + y);

    // Find the Save button color
    WebElement buttonColour = driver.findElement(By.id("j_idt88:j_idt96"));
    String colour = buttonColour.getCssValue("background-color"); // inspect wala style wla adala eke background - bg-colour walin link eka gatte
    System.out.println("colour is " + colour);

    // 4 Find the height and width of this button

    WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
    int hight = size.getSize().getHeight();  //Diamonsion class eka blanna ara element select -- ctri + click
    int width = size.getSize().getWidth();
    System.out.println("hight is " + hight + " and width is " + width);

 // 5. Mouse over and confirm the color changed
    WebElement changeColourElement = driver.findElement(By.id("j_idt88:j_idt100"));
               //Get the color before hover
    String colorBeforeHover = changeColourElement.getCssValue("background-color");
               // Hover over the element. catch change colour  ....

    Actions actions = new Actions(driver);
    actions.moveToElement(changeColourElement).perform();
               // Wait briefly to let hover effect apply (you can also use WebDriverWait if needed)
    Thread.sleep(1000);
               // Get the color after hover
    String colorAfterHover = changeColourElement.getCssValue("background-color");
               // Compare and print results
    if (!colorBeforeHover.equals(colorAfterHover)) {
        System.out.println("Color changed on hover. Before: " + colorBeforeHover + ", After: " + colorAfterHover);
    } else {
        System.out.println("Color did not change on hover.");
    }

     // Click Image Button and Click on any hidden button
    WebElement imageButton = driver.findElement(By.id("j_idt88:j_idt102:imageBtn"));
    imageButton.click();
                 // Wait until the hidden button becomes visible .....
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement hiddenButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("j_idt88:j_idt102:j_idt104")));


    // How many rounded buttons are there?
    List<WebElement> roundedButtons = driver.findElements(By.cssSelector("button[class*='rounded']"));
    System.out.println("Number of rounded buttons: " + roundedButtons.size());
    }
}