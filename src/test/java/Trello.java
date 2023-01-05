import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Trello {
    WebDriver wd;

    @BeforeMethod
    public void preConditions() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void login1() {
        initLogin();
        pause(2000);
        fillLoginForm();
        submitLogin();
        pause(2000);

        Assert.assertTrue(isLogged());

    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-test-id='header-member-menu-button']")).size() > 0;
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void fillLoginForm() {
        type(By.cssSelector("#user"), "juliakliot.jk@gmail.com");
        click(By.cssSelector("#login"));
        type(By.cssSelector("#password"), "misha240613");
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void logOut() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
        click(By.cssSelector("#logout-submit"));
    }

    @AfterMethod
    public void postConditions() {

        wd.close();
        wd.quit();

    }


}
