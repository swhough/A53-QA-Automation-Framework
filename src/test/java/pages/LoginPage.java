package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Element Locators
    //Another way to do it: String emailFieldCssSelector = "input[type='email']";
   private By emailField = By.cssSelector("input[type='email']");
   private By passwordField = By.cssSelector("input[type='password']");
   private By submitBtn = By.cssSelector("button[type='submit']");


    // Page Methods
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    /*void provideEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }*/

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    /*void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }*/

    public void clickSubmit() {
        click(submitBtn);
    }

    /*void clickSubmit() {
        //WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }*/

    public void login() {
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
    }
}