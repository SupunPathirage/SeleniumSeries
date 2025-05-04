import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

public class DownloadUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void openFileTestsPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
        Thread.sleep(3000);
        WebElement downloadBtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\Supun Pathirage\\Downloads"); // me path ekta downloard wee
        File[] totalFiles = file.listFiles();

        for (File findFile : totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")) {
                System.out.println("File is downloaded");
                break;
            }
        }
        driver.quit();

    }

    @Test
    public void fileUploardTest() throws AWTException, InterruptedException {
        driver.get("https://leafground.com/file.xhtml");

        // 1st way clipBorad case eka

//        WebElement uploadBtn =driver.findElement(By.id("j_idt88:j_idt89"));
//        uploadBtn.click();
//
//        // windows control beging heare
//        // WINDOWS WALA CLIPBOARD EKTA COMMAND EKA YAWEEMA
//
        String data = "C:\\Users\\Supun Pathirage\\Downloads\\TestLeaf Logo.png";
//        StringSelection selection = new StringSelection(data);  // FILE UPLOAD WALADI MAINLY USE WENA CLASS EKA
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null); // ToolKit method eka iuse new method
// Coping  path to clip board
//        Thread.sleep(4000);
//        Robot robot = new Robot();  // thwa alut class eka == ctrl + v eka ganna oni nisa
//        robot.keyPress(KeyEvent.VK_CONTROL); // vk - vitual key  --- WINDOWS + CTRL + 0  --- e ena eka thmai robot class eken access krnneh
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//        Thread.sleep(4000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        // 2nd Way -  Using Send Keys (Applicable only element type is file)
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingSendKeys.sendKeys(data);
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void anyFileUploardTest() throws AWTException, InterruptedException {
        driver.get("https://leafground.com/file.xhtml");
        String data = "C:\\Users\\Supun Pathirage\\Downloads\\TestLeaf Logo.png";
        WebElement uploadUsingSendKeys = driver.findElement(By.id("j_idt97:j_idt98_input"));
        uploadUsingSendKeys.sendKeys(data);
        Thread.sleep(2000);
        driver.quit();
    }
}


