import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement pauseButton = driver.findElement(By.cssSelector("span[title='Pause']"));
        Assert.assertTrue(pauseButton.isDisplayed());

    }

    //HELPER METHODS:
    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.cssSelector("i[title='Play next song']"));
        WebElement playButton = driver.findElement(By.cssSelector("span[title='Play or resume']"));

        playNextButton.click();
        playButton.click();
    }

}


