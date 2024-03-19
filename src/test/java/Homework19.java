import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import pages.BasePage;
import pages.LoginPage;

public class Homework19 extends BaseTest {

    //BasePage basePage = new BasePage(driver);
    //LoginPage loginPage = new LoginPage(driver);

    @Test
    public void deletePlaylist() {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //This test creates and deletes a randomly-named playlist.
        //It will only test deleting playlists that are empty of songs.

        String playlistName = basePage.generateRandomName();

        //Login
        /*provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        checkLoggedIn();*/

        loginPage.login();

        clickNewPlaylistPlusBtn();
        clickNewPlaylistBtn();
        provideNewPlaylistName(playlistName);

        choosePlaylistFromSidePanel(playlistName);
        clickDeletePlaylistBtn();

        //Assert
        checkDeletedPlaylistSuccessMsg(playlistName);

    }

    //HELPER METHODS:
    public void clickNewPlaylistPlusBtn() {
        WebElement newPlaylistPlusBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[title='Create a new playlist']")));
        newPlaylistPlusBtn.click();
    }
    public void clickNewPlaylistBtn() {
        WebElement newPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid=playlist-context-menu-create-simple]")));
        newPlaylistBtn.click();
    }

    public void provideNewPlaylistName(String newName) {
        WebElement profileNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        profileNameField.sendKeys(Keys.ENTER);
    }

    public void choosePlaylistFromSidePanel(String playlistName) {
        WebElement chosenPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='mainWrapper']//a[contains(text(), '" + playlistName + "')]")));
        chosenPlaylist.click();
    }

    public void clickDeletePlaylistBtn() {
        WebElement deleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        deleteButton.click();
    }

    public void checkDeletedPlaylistSuccessMsg(String playlistName) {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Deleted')]")));
        Assert.assertEquals("Deleted playlist \"" +playlistName+".\"",notificationMsg.getText());
    }

}