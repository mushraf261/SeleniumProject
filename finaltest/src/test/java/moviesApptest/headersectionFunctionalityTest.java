package moviesApptest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;




public class headersectionFunctionalityTest {
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



        //Funtionality Test(Navigation to Home, popular and Accounts page)

        //Navigation to home page
        WebElement homePageEl = driver.findElement(By.xpath("//a[text()='Home']"));
        homePageEl.click();

        String expectedHomePage = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitElement.until(ExpectedConditions.urlToBe(expectedHomePage));

        String currentHomePageUrl = driver.getCurrentUrl();

        if (currentHomePageUrl.equals(expectedHomePage)) {
            System.out.println("Home Page Functionality was Successful");
        }
        else {
            System.out.println("Could not Navigate to the Home Page");
        }





        //Navigation to Popular Page

        WebElement popularPage = driver.findElement(By.xpath("//a[text()='Popular']"));
        popularPage.click();

        String expectedPopularpageUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait waitEl = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitEl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='movie-icon-item']")));

        String currentpopularpageUrl = driver.getCurrentUrl();

        if (currentpopularpageUrl.equals(expectedPopularpageUrl)) {
            System.out.println("Navigation to Popular Movies Page was Successful");
        }
        else {
            System.out.println("Could not Navigate to the Popular Movies Page");
        }




        //Navigation to the Accounts Page
        WebElement AccountsPage = driver.findElement(By.className("avatar-button"));
        AccountsPage.click();

        String expectedAccountspageUrl = "https://qamoviesapp.ccbp.tech/account";

        WebDriverWait waitEle = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitEle.until(ExpectedConditions.urlToBe(expectedAccountspageUrl));

        String currentAccountspageUrl = driver.getCurrentUrl();

        if (currentAccountspageUrl.equals(expectedAccountspageUrl)) {
            System.out.println("Navigation to Acccounts Page was Successful");
        }
        else {
            System.out.println("Could not Navigate to the Accounts Page");
        }

        driver.quit();





    }
}
