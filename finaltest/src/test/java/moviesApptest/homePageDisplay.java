package moviesApptest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class homePageDisplay {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mushe\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        boolean isElementVisible = driver.findElement(By.className("login-website-logo")).isDisplayed();
        System.out.println(isElementVisible);


        WebElement headingEle = driver.findElement(By.className("sign-in-heading"));
        String expectedHeading = "Login";
        String actualHeading = headingEle.getText();
        if(expectedHeading.equals(actualHeading)) {
            System.out.println("Actual Heading Match with the Expected Heading");
        }
        else{
            System.out.println("Actual Heading is not Matched with the expected heading");
        }



        WebElement usernameEle = driver.findElement(By.className("input-label"));
        String expectedlabel = "USERNAME";
        String actuallabel = usernameEle.getText();
        if(expectedlabel.equals(actuallabel)) {
            System.out.println("Actual username label is matched with the expected username label");
        }
        else {
            System.out.println("Actual username label does not match");
        }


        WebElement passwordEle = driver.findElement(By.xpath("//label[text()='PASSWORD']"));
        String expectedpasswordlabel = "PASSWORD";
        String actualpasswordlabel = passwordEle.getText();
        if(expectedpasswordlabel.equals(actualpasswordlabel)) {
            System.out.println("Actual password label is matched with the expected password label");
        }
        else {
            System.out.println("Actual password label does not match");
        }


        WebElement buttonEle = driver.findElement(By.className("login-button"));
        boolean isEnabled = buttonEle.isDisplayed();
        System.out.println(isEnabled);

        driver.quit();


    }
}
