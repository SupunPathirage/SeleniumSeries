import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v133.dom.model.PseudoType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest {
    WebDriver driver;

    @BeforeMethod
    public void we() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/window.xhtml;jsessionid=node01hpo7f5fa521jweq52uiz3kgt347974.node0");
        Thread.sleep(3000);
    }

    @Test
    public void windowTests() throws InterruptedException {

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parents window : " +oldWindow); // meka window 2k open wena nisa parent , old recognized kragnna

        // Click and Confirm new Window Opens
        WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));  //-- x path eka gattama enneh java '' dana vidiya \" \" lesa eka nisa eka change krnna oni '' lesa..
        openButton.click();
        Thread.sleep(3000);

        Set<String> hadels = driver.getWindowHandles();  // kiyak thiynwad hoyageneema
        System.out.println("Hadels Size : " +hadels);

//        for (String newWindow : hadels) {   // for each hadel eke thiyana window ganna loopekak wage weda weema..mulin new window lesa run wenneh oldwindow eka 2 weniyata run weemedi new window run wee
//            System.out.println("Window Handle : " +newWindow);
//            driver.switchTo().window(newWindow);  // aluthin apu tab eke deyak action perfomance kenna anwaryen switch wenna oni nisa meka switch krnwa
        // if(driver.getTitle().equals("xyz"){
        //break;
//            System.out.println("page title is : "+ driver.getTitle());
//        }
//        driver.close();
//
//        driver.switchTo().window(oldWindow);


        // Second Method  -- using List
        List<String> list = new ArrayList<String>(hadels); // Converting set to the list
        if (list.size()>1){
            driver.switchTo().window(list.get(1)); // child tab ekta panna 0 noda 2kta
            System.out.println("child tab title is : "+ driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow); // ai old window ekta ema
        }

        WebElement openButton1 =driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openButtonVisibility = openButton1.isDisplayed();
        System.out.println("Open button visibility : " +openButtonVisibility);


        // Find the number of opened tabs
        WebElement multiWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
        multiWindow.click();
        Thread.sleep(3000);

        Set<String> multiWindows =driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("How many windows : " +howmanyWindows);


        // Close all windows except Primary

        WebElement donotDontCloseMe =  driver.findElement(By.id("j_idt88:j_idt93"));
        donotDontCloseMe.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandels = driver.getWindowHandles();
        for (String allldWindows : newWindowsHandels){
            if (!allldWindows.equals(oldWindow)){
                driver.switchTo().window(allldWindows);
                driver.close();
            }
        }

        // driver.switchTo().window(oldWindow); // parana old ekta ynna alut ewa colse wela ynna
        // driver.close();

        driver.quit();

        // interview qiz - --- driver.close() close single browser window driver which on focus
        //         driver .quit() --- close alll windows
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000); // 🕒 Waits for 3 seconds before closing the browser
            driver.quit();      // ✅ Closes all browser windows and ends the session
        }
    }
}
