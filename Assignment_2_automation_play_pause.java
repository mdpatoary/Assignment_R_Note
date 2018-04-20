package com.java.automation;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;

public class Assignment_2_automation_play_pause {

	static WebDriver driver;
	protected static final String URL = "https://www.envrmnt.com/360-video/ ";

	@Parameters("browser")
	@BeforeTest
	public void beforeMethod(@Optional("firefox") String browsername) {

		if (browsername.equalsIgnoreCase("firefox")) {
			System.out.println("launching firefox browser");
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browsername.equalsIgnoreCase("chrome")) {
			System.out.println("launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "..\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		if (browsername.equalsIgnoreCase("ie")) {
			System.out.println("launching ie browser");
			System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		if (browsername.equalsIgnoreCase("htmlUnit")) {
			driver = new HtmlUnitDriver();
		}

		if (browsername.equalsIgnoreCase("htmlUnitWithJs")) {
			driver = new HtmlUnitDriver(true);

		}

		if (browsername.toLowerCase().contains("safari")) {
			driver = new SafariDriver();

		}
        /*
       Depends on Project Requirments .....
        It's just a matter of adding more browser specific dependencies and it should work fine :)
        if (browserName.toLowerCase().contains("opera")) {
            driver = new OperaDriver();
            return driver;
        }
        if (browsername.toLowerCase().contains("phantomjs")) {
            driver = new ();
            return driver;
        }
        if (browsername.toLowerCase().contains("android")) {
            driver = new ();
            return driver;
        }
        if (browsername.toLowerCase().contains("ipad")) {
            driver = new ();
            return driver;
        }
        if (bbrowsername.toLowerCase().contains("iphone")) {
            driver = new ();
            return driver;
        }
        */
		System.out.println("navigating application");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void paly_push() throws InterruptedException {

		// driver.switchTo().frame("envrmnt_0762559c-9f13-44d6-9de3-5d7b0feebc12");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		 * js.executeScript(
		 * "document.getElementByClassName('compass-reset').play()");
		 * Thread.sleep(15000); js.executeScript(
		 * "document.getElementByClassName('compass-reset').pause()");
		 * Thread.sleep(15000);
		 */
		js.executeScript("document.getElementById(\"play-pause-container\").play()");
		Thread.sleep(15000);
		js.executeScript("document.getElementById(\"play-pause-container\").pause()");
		Thread.sleep(15000);

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("quiting application!");
	}

}