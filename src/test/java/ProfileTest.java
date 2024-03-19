import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class ProfileTest extends BaseTest {

    //BasePage basePage = new BasePage(driver);
    //LoginPage loginPage = new LoginPage(driver);

    @Test
    public void changeProfileName() {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Login
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        //Navigate to Profile Page
        clickOnAvatar();

        //Random new Name
        String randomNewName = basePage.generateRandomName();

        //Provide Current Password
        provideCurrentPassword("te$t$tudent");

        //Provide new Random Name
        provideNewName(randomNewName);

        //Click on Save Button
        clickSave();

        //Assertion
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), '"+randomNewName+"')]")));
        Assert.assertEquals(actualProfileName.getText(), randomNewName);

    }

    //HELPER METHODS:

    //Navigate to Profile Page
    public void clickOnAvatar(){
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='current_password']")));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(password);
    }

    public void provideNewName(String newName){
        WebElement profileNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
    }

    public void clickSave(){
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }
}
