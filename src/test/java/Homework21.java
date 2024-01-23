import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework21 extends BaseTest {

    String newPlaylistName = "Renamed Playlist";
    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"Renamed Playlist.\"";

        //Login
        loginToKoelApp();
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);


    }

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist:nth-child(3)")));
        actions.click(playlistElement).perform();
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //Clear() does not work since element has an attribute of "required"
        //Workaround is ctrl A (to select all) then backspace to clear, then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }

}
