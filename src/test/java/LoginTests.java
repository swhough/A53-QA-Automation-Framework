import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000); //Sleep for 2 seconds

        //Assertion
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        provideEmail("invalid@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000); //Sleep for 2 seconds

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginInvalidPasswordValidEmail() throws InterruptedException {

        provideEmail("demo@class.com");
        providePassword("invalidPassword");
        clickSubmit();

        Thread.sleep(2000); //Sleep for 2 seconds

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }


}

