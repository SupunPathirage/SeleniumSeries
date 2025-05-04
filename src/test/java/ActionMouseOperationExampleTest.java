import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationExampleTest {
    WebDriver driver;

    @BeforeMethod
    public void amoe() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://leafground.com/drag.xhtml");
    }

    @Test
    public void mouseOperationTest1() throws InterruptedException {
        driver.get("https://leafground.com/drag.xhtml");
        System.out.println(" 1) <<<<<<<<<<<<<<<<<<< Move To an Element Operation>>>>>>>>>>>>>>>>>>>");
        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt41"))).perform();
//        Thread.sleep(3000);
//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt42"))).perform();
//

// anik widiya   ------------------------------------

        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38")))
                .moveToElement(driver.findElement(By.id("menuform:j_idt39")))

                .moveToElement(driver.findElement(By.id("menuform:j_idt40")))

                .moveToElement(driver.findElement(By.id("menuform:j_idt41")))

                .moveToElement(driver.findElement(By.id("menuform:j_idt42"))).perform();


        System.out.println(" 1) <<<<<<<<<<<<<<<<<<< Drag and Drop Operation>>>>>>>>>>>>>>>>>>>");

        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        // actions.clickAndHold(from).moveToElement(to).release(to).perform();  // 1st way
        actions.dragAndDrop(from, to).perform(); // 2nd way

        System.out.println(" 1) <<<<<<<<<<<<<<<<<<< Slider  Operation>>>>>>>>>>>>>>>>>>>");

        WebElement sliderPoint1 = driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println(" Location of Slider Point 1 Before Moving : " + sliderPoint1.getLocation());
        actions.dragAndDropBy(sliderPoint1, 50, 0).perform(); // 923ta 50k + we - Slider range ekat change we
        System.out.println("Location Of Slider Point 1 After Moving : " + sliderPoint1.getLocation());
    }

    @Test()
    public void mouseOperationsTest2() throws InterruptedException {

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        System.out.println("4) <<<<<<<<<<<<<<<Right click>>>>>>>>>>>>>>>");

        WebElement rightClickButtonElemnt = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions1 = new Actions(driver);
        actions1.contextClick(rightClickButtonElemnt).perform();
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        Alert alertPop = driver.switchTo().alert();
        System.out.println("Alert shows the text as : " + alertPop.getText());
        Thread.sleep(3000);
        alertPop.accept();
    }

}