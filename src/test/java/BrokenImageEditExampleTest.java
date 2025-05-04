import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class BrokenImageEditExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void biee(){
        ChromeOptions chromeOptions = new ChromeOptions();
        File file = new File("C:\\Users\\Supun Pathirage\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        chromeOptions.addExtensions(file);
        driver = new ChromeDriver(chromeOptions);
        // 118 , 19 , 20 , 21 - ape Automated (run unama ena) Browser ekta Extention 1k dana widiya.. udin penwa eka..download krla path eka deela thmai krnna oni
        driver.manage().window().maximize();
    }

    @Test
    public void brokenImageTests(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // naturalwith  = 0 --  broken image ekka hangichcha value eka .

        int i = 1;
        for (WebElement image : images) {
            if (image.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Image " + i + " "+ "is Broken");
            }else {
                System.out.println("Image " + i + " " + " is Not Broken");
            }
            i++;
        }
    }

    @Test
    public void findBrokenImageTestekakvitrak(){
        driver.get("https://demoqa.com/broken");
        WebElement brokenImage = driver.findElement(By.xpath("//*[text()='Valid image']/parent::div/img[2]"));
        if (brokenImage.getAttribute("naturalWidth").equals("0")){
            System.out.println("image is broken");
        } else {
            System.out.println("image not broken");
        }
    }
}
