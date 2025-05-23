import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void RandCExa(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests() throws InterruptedException{
        // 1. Find the default select radio button
        driver.get("https://leafground.com/radio.xhtml");
        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected(); // 2.1 , 2.2  ,  2.3 thama e browser wala path wenasweema
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgerRadioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeRadioOption) {
            String chromeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button : "+chromeTest);
        }else if (firefoxRadioOption) {
            String firefoxTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button : "+firefoxTest);
        }else if (safariRadioOption) {
            String safariTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button : "+ safariTest);
        }else if (edgerRadioOption) {
            String edgeTest = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button : "+ edgeTest);
            Thread.sleep(2000);
        }


//        List<WebElement> radioElements =  driver.findElements(By.xpath("//table[@id='j_idt87:console2']//td//input"));
//        int radioElementCount = radioElements.size();
//        System.out.println("radioElementCount : "+radioElementCount);
//
//        int index = -1;
//        for (WebElement radioElement : radioElements) {
//            index++;
//            if (radioElement.isSelected()){
//                WebElement defaultSelectedRadioButton = driver.findElement(By.xpath("//label[@for='j_idt87:console2: " + index + "']"));
//                // labale eka dapu vidiya supiri .... uda thiyana coman vidiyta xpath eka hadagannna oni podu wena widiyta 2:0 ain kra 2: widiyta..
//                String defaultSelectedRadioButtonText = defaultSelectedRadioButton.getText();
//                System.out.println("Default selected radio button : "+defaultSelectedRadioButtonText);
//                break;
//            }
//        }
        // me ara uda eke lesi widiya

        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isCheck = myAgeGroup.isSelected();
        if (!isCheck) {
            // myAgeGroup.click();
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
            Thread.sleep(2000);
        }
    }


    @Test
    public void CheckboxTest() throws InterruptedException{
        driver.get("https://www.leafground.com/checkbox.xhtml");

        // Basic TestBox

        WebElement basicCheckBox = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']/div[2]"));
        basicCheckBox.click();

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkBoxList) {  // foreach loop
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkBoxList.size(); i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("CheckBox " + i + "selected status is : " + checkBoxStatus);
            Thread.sleep(2000);
        }

        // Notification pop up
        driver.findElement(By.id("j_idt87:j_idt91")).click();  // click the button that triggers alert
        // Wait for the popup to appear in DOM and become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("ui-growl-message")) // or your popup's class/id
        );

        System.out.println("Popup text: " + popupMessage.getText());

        // Toggle Switch .....................................................................
        WebElement toggleSwitch = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt100']/div[2]"));
        toggleSwitch.click();
        Thread.sleep(1000);

        // Get state from class attribute
        String toggleClass = toggleSwitch.getAttribute("class");
        if (toggleClass.contains("ui-toggleswitch-checked")) {
            System.out.println("Toggle is ON");
        } else {
            System.out.println("Toggle is OFF");
        }
        // Click again to toggle back
        toggleSwitch.click();
        Thread.sleep(1000);
        toggleClass = toggleSwitch.getAttribute("class");
        if (toggleClass.contains("ui-toggleswitch-checked")) {
            System.out.println("Toggle is ON");
        } else {
            System.out.println("Toggle is OFF");
        }
// Verify if check box is disabled ..
        WebElement checkbox = driver.findElement(By.id("j_idt87:j_idt102_input"));

        if (!checkbox.isEnabled()) {
            System.out.println("Checkbox is disabled");
        } else {
            System.out.println("Checkbox is enabled");
        }
        
        driver.quit();
    }
}
