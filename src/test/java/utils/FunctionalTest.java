package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {
    protected static WebDriver driver;
    protected final Logger logger = LogManager.getLogger(getClass());

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anna/Applications/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    // Method gets invoked if the test fails for any reason:
    @Rule
    public final TestRule watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            // Now you can do whatever you need to do with it, for example take a screenshot
            takeScreenShot(description.getDisplayName());
        }
    };

    // Create screenshot if an error exist(if test is failed)
    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/screenshots/" + LocalDateTime.now().toString().substring(0, 19).replace(":", "-") + "_" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

}
