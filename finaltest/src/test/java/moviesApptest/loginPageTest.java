package moviesApptest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class loginPageTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mushe\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        WebElement usernameinputEle = driver.findElement(By.id("usernameInput"));
        boolean usernameisEnabled = usernameinputEle.isDisplayed();
        System.out.println(usernameisEnabled);


        WebElement passwordinputEle = driver.findElement(By.id("passwordInput"));
        boolean passwordisEnabled = passwordinputEle.isDisplayed();
        System.out.println(passwordisEnabled);


        usernameinputEle.sendKeys("rahul");
        passwordinputEle.sendKeys("rahul@2021");

        WebElement buttonEle = driver.findElement(By.className("login-button"));
        buttonEle.submit();

        driver.quit();




    }
}
