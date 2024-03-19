import pages.HomePage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    /*This did not work for some reason. By putting the constructor methods up here, it caused a strange failure in the test below. The test
    worked when I returned the these methods to the actual test text.*/

    //Page Objects
    //LoginPage loginPage = new LoginPage(driver);
    //HomePage homePage = new HomePage(driver);

   @Test
    public void loginValidEmailPassword() throws InterruptedException {
       LoginPage loginPage = new LoginPage(driver);
        /*provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();*/
       loginPage.login();

        //Assertion
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

        }

    @Test(dataProvider = "InvalidLoginData")
    @Parameters({"BaseUrl"})
    public void loginInvalidEmailValidPassword(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    @Test
    public void loginInvalidPasswordValidEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("invalidPassword");
        loginPage.clickSubmit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Assertion
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }

    /*
    * Test Script using Page Object Model.
    * Locators used in these tests were located using By abstract class.
     */
    @Test
    public void loginWithCorrectCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        /*loginPage.provideEmail("scott.hough@testpro.io");
        loginPage.providePassword("NoUnsafeChar2");
        loginPage.clickSubmit();*/

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

    }

}

