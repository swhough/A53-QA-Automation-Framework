import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {

        //This test creates and deletes a randomly-named playlist.
        //It will only test deleting playlists that are empty of songs.

        //Login
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        checkLoggedIn();
        Thread.sleep(2000);

        String playlistName = generateRandomName();
        //String playlistName = "Playlist to Delete";
        clickNewPlaylistPlusBtn();
        Thread.sleep(2000);
        clickNewPlaylistBtn();
        Thread.sleep(2000);
        provideNewPlaylistName(playlistName);
        Thread.sleep(2000);

        choosePlaylistFromSidePanel(playlistName);
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(2000);
        checkDeletedPlaylistSuccessMsg(playlistName);
        Thread.sleep(2000);

        //Assert
        checkDeletedPlaylistSuccessMsg(playlistName);

    }

    //HELPER METHODS:
    public void choosePlaylistFromSidePanel(String playlistName) {
        WebElement chosenPlaylist = driver.findElement(By.xpath("//div[@id='mainWrapper']//a[contains(text(), '" + playlistName + "')]"));
        chosenPlaylist.click();

    }

    public void clickDeletePlaylistBtn() {
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deleteButton.click();
    }

    public void clickOkDeletePlaylistBtn() {
        WebElement okDeleteButton = driver.findElement(By.cssSelector("button[class='ok']"));
        okDeleteButton.click();
    }

    public void checkDeletedPlaylistSuccessMsg(String playlistName) {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        Assert.assertEquals("Deleted playlist \"" +playlistName+".\"",notificationMsg.getText());
    }
    public void provideNewPlaylistName(String newName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("input[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        //m.sendKeys("Java");
        profileNameField.sendKeys(Keys.ENTER);
    }
    public void clickNewPlaylistPlusBtn() {
        WebElement newPlaylistPlusBtn = driver.findElement(By.cssSelector("i[title='Create a new playlist']"));
        newPlaylistPlusBtn.click();
    }
    public void clickNewPlaylistBtn() {
        WebElement newPlaylistBtn = driver.findElement(By.cssSelector("li[data-testid=playlist-context-menu-create-simple]"));
        newPlaylistBtn.click();
    }

}



