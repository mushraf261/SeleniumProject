package moviesApptest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class accountsPageTest {
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


        WebElement accountsEle = driver.findElement(By.className("avatar-button"));
        accountsEle.click();

        String expectedaccountsUrl = "https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.urlToBe(expectedaccountsUrl));

        String currentaccountsUrl = driver.getCurrentUrl();

        if (currentaccountsUrl.equals(expectedaccountsUrl)) {
            System.out.println("Navigation to Accounts page was successful");
        }
        else {
            System.out.println("Navigation to Accounts page failed");
        }


        WebElement accountHeading = driver.findElement(By.xpath("//h1[text()='Account']"));
        boolean accountHeadingisEnabled = accountHeading.isDisplayed();
        System.out.println(accountHeadingisEnabled);

        WebElement membershipEle = driver.findElement(By.className("membership-heading"));
        boolean membershipisEnabled = membershipEle.isDisplayed();
        System.out.println(membershipisEnabled);


        WebElement membershipDetails = driver.findElement(By.className("membership-details-container"));
        boolean detailsIsEnabled = membershipDetails.isDisplayed();
        System.out.println(detailsIsEnabled);


        WebElement planEle = driver.findElement(By.xpath("//p[text()='Plan details']"));
        boolean planisEnabled = planEle.isDisplayed();
        System.out.println(planisEnabled);

        WebElement planDetails = driver.findElement(By.className("plan-details-container"));
        boolean plandetailsisEnabled = planDetails.isDisplayed();
        System.out.println(plandetailsisEnabled);



        WebElement logoutBtn = driver.findElement(By.className("logout-button"));
        logoutBtn.click();

        String expedtedlogoutUrl = "https://qamoviesapp.ccbp.tech/login";

        String currentlogoutUrl = driver.getCurrentUrl();

        if (currentlogoutUrl.equals(expedtedlogoutUrl)) {
            System.out.println("Logout button funtionality tested sucessfully");
        }
        else {
            System.out.println("Logout button funtionality was unsuccessful");
        }


        driver.quit();

    }
}
