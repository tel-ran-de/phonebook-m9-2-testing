package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ActivateEmail extends PageObject {

    public ActivateEmail(WebDriver driver) { super(driver); }

    @FindBy(xpath = "/html/body/app-root/app-activate-email/main/section/div/h4")
    private WebElement messageToCheckEmail;

    public boolean isMessageDisplayed() {
        return messageToCheckEmail.isDisplayed();
    }

    public String checkMessage() {
        return messageToCheckEmail.getText();
    };

}
