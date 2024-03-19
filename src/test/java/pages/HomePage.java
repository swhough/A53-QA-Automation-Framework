package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Locators
    private By firstPlaylist = By.cssSelector("li.playlist:nth-child(3)");
    private By playlistInputField = By.cssSelector("[name='name']");
    private By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    private By userAvatarIcon = By.cssSelector("img.avatar");


    //Page Methods
    public WebElement getUserAvatarIcon () {
        return findElement(userAvatarIcon);
    }

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName){
        //Clear() does not work since element has an attribute of "required"
        //Workaround is ctrl A (to select all) then backspace to clear, then replace with new playlist name
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistInputField).sendKeys(playlistName);
        findElement(playlistInputField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg() {
        return findElement(renamePlaylistSuccessMsg).getText();
    }

}
