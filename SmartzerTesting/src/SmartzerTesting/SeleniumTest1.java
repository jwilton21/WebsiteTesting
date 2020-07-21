// Relevant imports.
package SmartzerTesting;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class SeleniumTest1
{ // Declare webDriver object.
	private static WebDriver driver;
	
	private static boolean doesFileExist;

	// BeforeClass- method executed once before class Tests.
	// This method sets up the webDriver.
	@BeforeClass
	public static void setUpWebdriver() throws IOException
	{	
		try
		{
			// Set up path on local drive for chromedriver exe.
			File chromeDriverFile = new File(
					"C:\\Users\\jasmi\\OneDrive\\General Documents and Scans\\GitHub\\JasminGitHubRepo\\seleniumPackage\\chromedriver.exe");

			// Assign boolean to path
			doesFileExist= chromeDriverFile.exists();
			// If the file exists and it is not a directory.
			if(chromeDriverFile.exists() && chromeDriverFile.isFile())
			{
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\jasmi\\OneDrive\\General Documents and Scans\\GitHub\\JasminGitHubRepo\\seleniumPackage\\chromedriver.exe");
			}
			else
			{
				System.out.println("Chrome driver does not exist at " + chromeDriverFile.getPath() +" Check path.");
			}
		}

		// If IOException thrown then catch here, if file cannot be found.
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Instantiate WebDriver object.
		driver = new ChromeDriver();
	}
	// Test - test loading of page and title.
	@Test
	public void testWebPageTitle()
	{ // Try catch block to catch potential exception thrown
		// and print stackTrace errors to console if occurred.

		String baseUrl = "https://player.smartzer.com/v/5713309579870208";
		String expectedTitle = "Smartzer Player";
		String actualTitle = "";

		try
		{
			// Go to video url.
			driver.get(baseUrl);
			// Maximise window.
			driver.manage().window().maximize();
			// Driver waiting if webPage failing to load.
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Return webpage title.
			actualTitle = driver.getTitle();

			if (actualTitle.contentEquals(expectedTitle))
			{
				System.out.println("WebsiteTitle test passed");
			} else
			{
				System.out.println("WebsiteTitle test failed");
			}

			// If exception thrown, catch here.
		} catch (Exception e)
		{ // Call to print stack trace method so we can get the line that caused
			// exception.
			e.printStackTrace();
		}
	}

	// Test 2, test video playback.
	@Test
	public void testVideoPlayback() throws InterruptedException
	{
		// Click on html body to start video. Assign with xPath.
		WebElement videoPlayButton = driver.findElement(By.xpath("/html/body"));
		// Click html body.
		videoPlayButton.click();

		// Test replay/pause button.
		WebElement videoPauseButton = driver.findElement(By.className("style_triangle__Z_pSr"));
		// Delaying pushing pause until video has finished.

		try
		{
			Thread.sleep(16000);
		} catch (InterruptedException ie)
		{
			ie.printStackTrace();
		}
		// Press pause.
		videoPauseButton.click();

		// Volume testing - mute.
		WebElement videoVolumeButton = driver.findElement(By.cssSelector(
				"#container > div > div.flex._1C67iIFBCgVzrnVTEByxa > div._2RCtSgX_lepGRXfGysnGEU > div.styles_hoverArea__3wbmd.styles_transformationLeft__rDWOW.drawerPadding > div > div.flex.styles_row__2CAJb > div.flex.styles_rowSectionLeft__13KLi > div.playbarButtonWrapper.styles_buttonWrapperBaseStyling__2YWjV.styles_order2__29yEK > div > button > svg"));
		videoVolumeButton.click();

		// Fullscreen and windowed.
		final WebElement videoFullScreen = driver.findElement(By.cssSelector(
				"#container > div > div.flex._1C67iIFBCgVzrnVTEByxa > div._2RCtSgX_lepGRXfGysnGEU > div.styles_hoverArea__3wbmd.styles_transformationLeft__rDWOW.drawerPadding > div > div.flex.styles_row__2CAJb > div.flex.styles_rowSectionRight__1jL9q > div.playbarButtonWrapper.styles_buttonWrapperBaseStyling__2YWjV.styles_order3__34LB0 > button > svg"));
		videoFullScreen.click();

		System.out.println("VideoPlayBack test passed");

	}
	@Test
	public void testProducts() throws InterruptedException
	{	// Press play.
		WebElement videoPlays= driver.findElement(By.className("style_triangle__Z_pSr"));
		videoPlays.click();
		// Test Product 1.
		WebElement nikeKyrie5WebE = driver.findElement(By.cssSelector("#container > div > div._1RGbbf9oDmsNlC2afFYK9e > div > div > div.flex > div:nth-child(2) > div > div > div > div > ul > li:nth-child(1) > div > a > div > div > div.imageWrapper > picture > img"));
		try
		{	// Pause before clicking on image.
			Thread.sleep(16000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		// Click on first product.
		nikeKyrie5WebE.click();
		// Test link for Eng language.
		driver.navigate().to("https://www.footlocker.co.uk/INTERSHOP/web/FLE/Footlocker-Footlocker_GB-Site/en_GB/-/GBP/ViewHomepage-Start");
		// Pause after navigating to url before closing.

		System.out.println("testProducts test passed");
		try
		{
			Thread.sleep(16000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}	// Closing webDriver.
	@AfterClass
	public static void shutDownWebDriver() 
	{	 
		if(driver != null) 
			driver.close();
		driver.quit();	

	}
}


