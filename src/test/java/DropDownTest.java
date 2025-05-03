import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void dd(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void leafGroundPage() throws InterruptedException {

        //Which is your favorite UI Automation tool?
        driver.get("https://leafground.com/select.xhtml;jsessionid=node01owk8wgff9app8f9yuamx8hjn323965.node0");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown); // Drop down thiyeinm select kiyna class ekak selenium denwa
        select.selectByIndex(1);
        Thread.sleep(3000); //exception eka trow kre mekta -- time ekak excecute weema
        select.selectByVisibleText("Playwright"); // dropdown eke eka option ekak
        Thread.sleep(3000);

        // Get the number of dreop Down Option

        List<WebElement> ListofOption = select.getOptions();  // list krnwa dropdown eke dewal
        int size = ListofOption.size();
        System.out.println("Number of element in Dropdown : "+ size);

        for (WebElement option : ListofOption) {
            System.out.println(option.getText());
        }

        // Using sendkeys select dropdown value  ----------- akurak dekak type krma wachanema ena eka

        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        // selecting boostrap  (drop down ) --- developer hadapu ewa select keys na..
        driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown.click();

        List<WebElement> listofDropdownvalues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : listofDropdownvalues) {
            String dropDownvalues =  element.getText();
            if (dropDownvalues.equals("USA")){  // anthima for loop eke item eken allnwa okkoma wedad balanna
                element.click();
                break;
            }
        }

    }

    // Google Search  - pick a value from Suggetions

    @Test
    public void googleSearchDropDowen() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchList =driver.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class='wM6W7d']")); // lesson 7 eke meka terune naa
        System.out.println(googlesearchList.size());
        for (WebElement elemnt :googlesearchList) {
            System.out.println(elemnt.getText());
        }

    }
}
