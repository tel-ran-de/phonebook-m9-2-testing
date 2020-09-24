package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class Activation extends PageObject {
    public Activation(WebDriver driver) { super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-activation/main/section/div/div/h4")
    private WebElement confirmMessage;

//    @FindBy(xpath = "/html/body/app-root/app-activation/main/section/div/div/a/button")
    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public boolean isMessageDisplayed() {
        return confirmMessage.isDisplayed();
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

}
