package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }


    // Element Locators
    //Another way to do it: String emailFieldCssSelector = "input[type='email']";
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");


    // Page Methods
    public void provideEmail(String email) {
        findElementUsingByLocator(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElementUsingByLocator(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElementUsingByLocator(submitBtn).click();
    }

    public void login() {
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
    }

}