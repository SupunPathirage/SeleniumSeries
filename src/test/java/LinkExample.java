import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkExample {

    WebDriver driver;

    @BeforeClass

    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void linkExampleTest(){

        // 1 Click The Link & Go to the Linked Page and Go Back Previous Page

        WebElement goToDashBoard = driver.findElement(By.linkText("Go to Dashboard"));
        goToDashBoard.click();
        driver.navigate().back();

        // 2  Get the Link to our Terminal without Clicking
        WebElement WhereToGo =  driver.findElement(By.partialLinkText("Find the URL"));
        String  path = WhereToGo.getAttribute("href");
        System.out.println("we got the link  here : " + path );

        // 3 Broken Link Findout this

        WebElement brokenLink=  driver.findElement(By.linkText("Broken?"));
        brokenLink.click(); // go to the broken link

       String title = driver.getTitle();
       if (title.contains("404")){
           System.out.println("This is a Broken Link");
       }else {
           System.out.println("This is a Real Link");
       }
        driver.navigate().back();
         // get the result that what is the link broken or real?


        //  4 How Many Links are there in this page
        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a"));
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Count of full page links : " + pageLinkCount);

        // Duplicate Link
//        WebElement duplicates =  driver.findElement(By.linkText("Go to Dashboard"));
//        duplicates.click();
//        List<WebElement> duplicatesLinks =  driver.findElements(By.linkText("Go to Dashboard"));
//        int duplicatesLinkCount = duplicatesLinks.size();
//        System.out.println("Count of duplicates links : " + duplicatesLinkCount);
//        driver.navigate().back();

// Duplicate Find Same Websites
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        Map<String, Integer> linkTextHrefCount = new HashMap<>();  // the point is store the link or text and interface gives to HashMap

        for (WebElement link : allLinks) {
            String text = link.getText().trim(); //  remove whitespace -- The beginning (leading) , The end (trailing)
            String hopeHref = link.getAttribute("href");

            if (hopeHref != null && !hopeHref.isEmpty() && !text.isEmpty()) {
                String key = text + " -> " + hopeHref;
                linkTextHrefCount.put(key, linkTextHrefCount.getOrDefault(key, 0) + 1);
            }
        }

        System.out.println("=== Duplicate Anchor Tags (Same Text & Href) ===");
        for (Map.Entry<String, Integer> entry : linkTextHrefCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
            }
        }

        // 6) -- Count of Layout Links -------------------------------------------------

        WebElement layoutElemnt = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutLinks = layoutElemnt.findElements(By.tagName("a"));
        System.out.println("Count of layout links : " + countOfLayoutLinks.size());

    }
}
