import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        //The pre-existing playlist is called "Test Playlist"
        String expectedAddedToPlaylistMessageText = "Added 1 song into \"Test Playlist.\"";

        //Login
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        Thread.sleep(2000);

        //Get to search bar and search
        provideSearchValue("Lament");
        Thread.sleep(2000);

        //Click "View All"
        clickViewAll();
        Thread.sleep(2000);

        //Click on first song in search results
        clickFirstSong();
        Thread.sleep(2000);

        //Click on "ADD To..." button
        clickAddTo();
        Thread.sleep(2000);

        //Choose playlist (Test Playlist)
        choosePlaylist();
        Thread.sleep(2000);

        //Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
        Assert.assertEquals(checkAddedToPlaylistSuccessMsg(), expectedAddedToPlaylistMessageText);

    }

    //HELPER METHODS:
    public void provideSearchValue(String search) {
        WebElement homeSearchField = driver.findElement(By.cssSelector("input[type=search]"));
        homeSearchField.clear();
        homeSearchField.sendKeys(search);

    }

    public void clickViewAll() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    public void clickFirstSong() {
        WebElement firstSongResult = driver.findElement(By.cssSelector("#songResultsWrapper .items tr:first-child"));
        firstSongResult.click();
    }

    public void clickAddTo() {
        WebElement addToButton = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToButton.click();
    }

    public void choosePlaylist() {
        WebElement playlistName = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//li[contains(text(),'Test Playlist')]"));
        playlistName.click();
    }

    public String checkAddedToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector(".success.show"));
        return notification.getText();
    }

}
