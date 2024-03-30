package moviesApptest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class tmoviesDetailspage {

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


        WebElement homepageMovie = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img"));
        homepageMovie.click();

        String moviepageUrl = "https://qamoviesapp.ccbp.tech/movies/92c2cde7-d740-443d-8929-010b46cb0305";
        wait.until(ExpectedConditions.urlToBe(moviepageUrl));


        WebElement titleEle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]"));
        boolean titleisEnabled = titleEle.isDisplayed();
        System.out.println(titleisEnabled);

        driver.quit();

    }
}
