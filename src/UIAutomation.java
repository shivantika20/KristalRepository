import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UIAutomation {
    public static WebDriver driver = null;

    public static void main(String args[]) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/shivantika.t/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //disabling the warnings
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //open chrome app
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Search for something
        driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("dog");
        driver.findElement(By.xpath("//label[@class='search icon tooltip']")).click();

        //Changing the Language to hindi
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@href='/?setmkt=en-in&setlang=hi']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='vkeyIcon']")).click();
        Thread.sleep(1000);

        //Changing back to English
        driver.findElement(By.xpath("//a[@href='/?setlang=en']")).click();

        //Clicking on images in menu
        driver.findElement(By.xpath("//a[@href='/images?FORM=Z9LH']")).click();
        Thread.sleep(5000);
        driver.navigate().back();

        //Change the background
        driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div/div/div/div[1]/div/div[2]/div[2]/a[1]")).click();
        Thread.sleep(1000);

        //Removing the search history
        driver.findElement(By.xpath("//input[@id='sb_form_q']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sb_form_q']")).click();
        driver.findElement(By.xpath("//a[@href='#rm']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sb_form_q']")).click();
        driver.close();
        driver.quit();
    }
}
