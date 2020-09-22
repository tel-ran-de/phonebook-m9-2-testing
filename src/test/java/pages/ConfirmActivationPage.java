package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ConfirmActivationPage extends PageObject {
    public ConfirmActivationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-activation/main/section/div/div/h4")
    private WebElement confirmMessage;

    @FindBy(xpath = "/html/body/app-root/app-activation/main/section/div/div/a/button")
    private WebElement loginBtn;

    public String getConfirmActivationMessage() {
        return confirmMessage.getText();
    }

    public LoginPage login() {
        loginBtn.click();
        return new LoginPage(driver);
    }

}
