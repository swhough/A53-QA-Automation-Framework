/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        //Get to search bar and search
        provideSearchValue("Lament");

        //Click "View All"
        clickViewAll();

        //Click on first song in search results
        clickFirstSong();

        //Click on "ADD To..." button
        clickAddTo();

        //Choose playlist (Test Playlist)
        choosePlaylist();

        //Verify that a notification message appears and contains the text, "Added 1 song into {your playlist}".
        Assert.assertEquals(checkAddedToPlaylistSuccessMsg(), expectedAddedToPlaylistMessageText);

    }

    //HELPER METHODS:
    public void provideSearchValue(String search) {
        WebElement homeSearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=search]")));
        homeSearchField.clear();
        homeSearchField.sendKeys(search);

    }

    public void clickViewAll() {
        WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }

    public void clickFirstSong() {
        WebElement firstSongResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper .items tr:first-child")));
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
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show")));
        return notification.getText();
    }

}*/
