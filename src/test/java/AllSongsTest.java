import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AllSongsTest extends BaseTest {

    @Test
    public void playSongByContextClick() throws InterruptedException {
        provideEmail("scott.hough@testpro.io");
        providePassword("NoUnsafeChar2");
        clickSubmit();
        chooseAllSongsList();
        contextClickFirstSong();
        choosePlayOption();
        //Assertions
        Assert.assertTrue(isSongPlaying());
        }


    @Test
    public void hoverOverPlayBtn() throws InterruptedException {
        loginToKoelApp();
        Thread.sleep(2000);
        //Assertions
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException{
        loginToKoelApp();
        choosePlaylistByName("Playlist to count songs");
        displayAllSongs();
        Thread.sleep(2000);
        //Assertions
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }

    //Helper Methods:
    public void chooseAllSongsList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongInTheList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSongInTheList).perform();
    }

    public void choosePlayOption() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@data-testid='song-context-menu']//ul//li[@class='playback']/span[1]"))).click();
    }

    public boolean isSongPlaying() throws InterruptedException {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }

    public WebElement hoverPlay(){
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public void choosePlaylistByName (String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs() throws InterruptedException{
        Thread.sleep(2000);
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Songs found: "+countSongs());
        for (WebElement e : songList){
            System.out.println(e.getText());
        }
    }

}
