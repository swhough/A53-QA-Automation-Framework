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

        /*Other option:
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));*/

        Assert.assertTrue(pauseButton.isDisplayed());

    }

    //HELPER METHODS:
    public void clickPlay() {
        WebElement playNextButton = driver.findElement(By.cssSelector("i[title='Play next song']"));
        WebElement playButton = driver.findElement(By.cssSelector("span[title='Play or resume']"));

        /*Other options:
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));*/

        playNextButton.click();
        playButton.click();
    }

}


