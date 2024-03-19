/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        //Login
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        clickPlay();

        //Assert
        WebElement pauseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Pause']")));
        Assert.assertTrue(pauseButton.isDisplayed());

        */
/*Other option:
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));*//*


    }

    //HELPER METHODS:
    public void clickPlay() {
        WebElement playNextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i[title='Play next song']")));
        WebElement playButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[title='Play or resume']")));

        */
/*Other options:
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));*//*


        playNextButton.click();
        playButton.click();
    }

}*/
