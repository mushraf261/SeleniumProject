package moviesApptest;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class headerSectionUItest {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mushe\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");

        WebElement usernameinputEle = driver.findElement(By.id("usernameInput"));
        WebElement passwordinputEle = driver.findElement(By.id("passwordInput"));

        usernameinputEle.sendKeys("rahul");
        passwordinputEle.sendKeys("rahul@2021");

        WebElement buttonEle = driver.findElement(By.className("login-button"));
        buttonEle.submit();


        String expectedUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));



        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Navigation to home page was succesful! ");
        }
        else {
            System.out.println("Navigation to home page was unsuccessful");
        }

        //UserInterface Test(Websire logo, Navbar Elements)
        WebElement homelogoEl = driver.findElement(By.className("website-logo"));
        boolean homelogoisEnabled = homelogoEl.isDisplayed();
        System.out.println(homelogoisEnabled);

        WebElement homeButtonEl = driver.findElement(By.xpath("//a[text()='Home']"));
        boolean homeButtonisEnabled = homeButtonEl.isDisplayed();
        System.out.println(homeButtonisEnabled);

        WebElement popularButtonEl = driver.findElement(By.xpath("//a[text()='Popular']"));
        boolean popularButtonisEnabled = popularButtonEl.isDisplayed();
        System.out.println(popularButtonisEnabled);

        WebElement searchButtonEl = driver.findElement(By.className("search-empty-button"));
        boolean searchButtonisEnabled = searchButtonEl.isDisplayed();
        System.out.println(searchButtonisEnabled);

        WebElement avatarButtonEl = driver.findElement(By.className("avatar-button"));
        boolean avatarButtonisEnabled = avatarButtonEl.isDisplayed();
        System.out.println(avatarButtonisEnabled);

        driver.quit();

    }
}
