import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionKeyBoardOperationExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void aboe(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void keybordoperationTests() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement googleSearchTextBox = driver.findElement(By.name("q"));
//        googleSearchTextBox.sendKeys("Welcome ");
//
        Actions actions = new Actions(driver);
//        // Select the Test  --- ctril + a = select  == eka meken krna hati
//       Action storingBuildOperation =  actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build(); // perfrome witrak pluwasn..eka noda
//        storingBuildOperation.perform(); // me tika noda perfome dala wede iwara krnna pluwan
//
//        Thread.sleep(5000);
//
//        actions.keyDown(Keys.SHIFT) // shift capital akurin type we
//                .sendKeys("Writing Capital Sentence").perform();
//        Thread.sleep(5000);
//              actions.keyUp(Keys.SHIFT)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("a")
//                .keyUp(Keys.CONTROL)
//                .keyDown(Keys.CONTROL)
//                .sendKeys("x")
//                .build().perform();  // Meka digtama code kratheki usesfrindly nisa line ekak pahalata aran mehema kra
        actions.keyDown(googleSearchTextBox, Keys.SHIFT)
                .sendKeys("Learn With Suppa").perform();
    }
    @Test
    public void keybordoperationTests2() throws InterruptedException {

        driver.get("https://leafground.com/list.xhtml");
        Thread.sleep(2000);

        List<WebElement>  selectable = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selectable.size();
        System.out.println("li count is : " +size);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selectable.get(0))
                .click(selectable.get(1))
                .click(selectable.get(2)).perform();


    }
}
