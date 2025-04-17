import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        WebElement enterYourOwnEX2   = driver.findElement(By.id("j_idt88:j_idt91"));
        enterYourOwnEX2.clear();  // pre define text clean
        enterYourOwnEX2.sendKeys("Australia");

        // Verify The Enable or Disable
       boolean isDisabled =  driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
       System.out.println( " you can see tha textBox is Disable (F) : "+isDisabled);

       // Retrieve Value From the TextBox to my Terminal
        WebElement getRetrieveValue =  driver.findElement(By.id("j_idt88:j_idt97"));
        String storeValue = getRetrieveValue.getAttribute("value");
        System.out.println(storeValue);

        // Type and moved to next element.

        WebElement  enterThis = driver.findElement(By.id("j_idt88:j_idt99"));
        enterThis.sendKeys("SupunPathirage96@gmail.com");
        Thread.sleep(3000);
        enterThis.sendKeys(Keys.TAB); // Moves to next input using (Keys.TAB)
        driver.switchTo().activeElement().sendKeys("Confirmed control moved to next element");
        Thread.sleep(4000);
        enterThis.clear();

    }
}
