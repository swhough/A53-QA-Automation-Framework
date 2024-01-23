import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

   @Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        //Assertion
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

        }

    @Test(dataProvider = "InvalidLoginData")
    @Parameters({"BaseUrl"})
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException {

        provideEmail(email);
        providePassword(password);
        clickSubmit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginInvalidPasswordValidEmail() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("invalidPassword");
        clickSubmit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

}

