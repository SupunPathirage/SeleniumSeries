import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxTest {
    WebDriver driver;

    @BeforeMethod
    public void RandCExa(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests(){
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
        }
    }

    @Test
    public void CheckboxTest(){
        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element:checkBoxList) {  // foreach loop
            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkBoxList.size(); i++){
            boolean checkBoxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+ "]")).isSelected();
            System.out.println("CheckBox " + i + "selected status is : " + checkBoxStatus);
        }
    }
}
