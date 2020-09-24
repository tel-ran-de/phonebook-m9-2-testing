package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    private static final String ERROR_START = "\n\nElement not found in: ";
    private static final String ERROR_MIDDLE = " within: ";
    private static final String ERROR_END = " seconds!\n\n";

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementIsDisplayed(int seconds, WebElement element) {

        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, seconds)
                .ignoring(StaleElementReferenceException.class);
        wait.withMessage(ERROR_START + element + ERROR_MIDDLE + seconds + ERROR_END);
        wait.until((ExpectedCondition<Boolean>) webDriver -> element.isDisplayed() == true);
    }

    //sets the MAXIMUM WAIT time for our conditional waits
    public static int WAIT_TIMEOUT() {
        return 5;
    }

    public void clickOnWebElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            waitForElementToBeVisible(driver, WAIT_TIMEOUT(), element);
            element.click();
        }
    }

    /**
     * conditional explicit wait for Element to be displayed
     *
     * @param seconds MAXIMUM amount of time to wait for condition to be true
     * @param element the element to wait for, it needs to be .isDisplayed() == true
     */
    public static void waitForElementToBeVisible(WebDriver driver, int seconds, WebElement element) {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, seconds)
                .ignoring(StaleElementReferenceException.class);
        wait.withMessage(ERROR_START + element + ERROR_MIDDLE + seconds + ERROR_END);
        wait.until((ExpectedCondition<Boolean>) webDriver -> element != null && element.isDisplayed());
    }

}
