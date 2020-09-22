package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class PassRecoveryActivationPage extends PageObject {
    public PassRecoveryActivationPage (WebDriver driver) {super(driver);}

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/section/div/h4")
    private WebElement confirmNewPassMessage;

    @FindBy(xpath = "/html/body/app-root/app-password-recovery/form/section/div/a")
    private WebElement loginBtn;

    public LoginPage login(){
        loginBtn.click();
        return new LoginPage(driver);
    }

}
