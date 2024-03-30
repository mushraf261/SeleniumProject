package moviesApptest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class homePageTest {
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


        WebElement heading1 = driver.findElement(By.xpath("//h1[text()='Trending Now']"));
        String expectedheading1 = "Trending Now";
        String actualheading1 = heading1.getText();
        if(expectedheading1.equals(actualheading1)) {
            System.out.println("First Main Heading is Displayed correctely");
        }
        else {
            System.out.println("Heading mismatched");
        }


        WebElement heading2 = driver.findElement(By.xpath("//h1[text()='Originals']"));
        String expectedheading2 = "Originals";
        String actualheading2 = heading2.getText();
        if(expectedheading2.equals(actualheading2)) {
            System.out.println("Second Main Heading is Displayed correctely");
        }
        else {
            System.out.println("Heading mismatched");
        }


        WebElement playButton = driver.findElement(By.className("home-movie-play-button"));
        boolean playButtonisEnabled = playButton.isDisplayed();
        System.out.println(playButtonisEnabled);



        WebElement contactlogos = driver.findElement(By.className("footer-icons-container"));
        boolean contactlogosisEnabled = contactlogos.isDisplayed();
        System.out.println(contactlogosisEnabled);


        /*Testing the Logos separately Whether each logo is diplayed correctly or not

        WebElement googlelogo = driver.findElement(By.className("icon-element google-icon"));
        boolean goooglelogoisEnabled = googlelogo.isDisplayed();
        System.out.println(goooglelogoisEnabled);

        WebElement twitterlogo = driver.findElement(By.className("icon-element twitter-icon"));
        boolean twitterlogoisEnabled = twitterlogo.isDisplayed();
        System.out.println(twitterlogoisEnabled);

        WebElement instalogo = driver.findElement(By.className("icon-element instagram-icon"));
        boolean instalogoisEnabled = instalogo.isDisplayed();
        System.out.println(instalogoisEnabled);

        WebElement youtubelogo = driver.findElement(By.className("icon-element youtube-icon"));
        boolean youtubelogoisEnabled = youtubelogo.isDisplayed();
        System.out.println(youtubelogoisEnabled); */

        WebElement contactUsSection = driver.findElement(By.xpath("//p[@class='contact-us-paragraph']"));
        boolean contactUsSectionisEnabled = contactUsSection.isDisplayed();
        System.out.println(contactUsSectionisEnabled);


        //Checking whether the movies are displayed in the corresponding Section
        WebElement TrendingMoviesSibling = driver.findElement(By.xpath("//div[@class='App']/preceding-sibling::*"));
        String moviesList = TrendingMoviesSibling.getText();
        System.out.println(moviesList);



        WebElement originalsMovies = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div"));
        WebElement originalsMovieHeading = driver.findElement(By.xpath("//h1[text()='Originals']/following::*"));
        if(originalsMovies.equals(originalsMovieHeading)) {
            System.out.println("Movies are displayed under the corresponding Section");
        }
        else {
            System.out.println("Movies are are misplaced under the different section");
        }

        driver.quit();

    }

}
