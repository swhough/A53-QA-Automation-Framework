import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.GenericDeclaration;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {


        String expectedDeletedPlaylistMessageText = "Deleted playlist \"Playlist to Delete.\"";
        String playlistName = "Playlist to Delete";

        //Login
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        checkLoggedIn();
        Thread.sleep(2000);

        choosePlaylistFromSidePanel("Playlist to Delete");
        Thread.sleep(2000);
        clickDeletePlaylistBtn();
        Thread.sleep(1000);

        /*if (driver.findElement(By.cssSelector("button[class='ok']")).isDisplayed()) {
            clickOkDeletePlaylistBtn();
            Thread.sleep(2000);}*/

        checkDeletedPlaylistSuccessMsg();

        //Assert
        Assert.assertEquals(checkDeletedPlaylistSuccessMsg(), expectedDeletedPlaylistMessageText);

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

    public String checkDeletedPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}



