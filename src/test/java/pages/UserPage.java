package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class UserPage extends PageObject {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/app-root/app-user-page/app-header/nav/a[2]")
    private WebElement logout;

    public void logout() {
        clickOnWebElement(logout);
    }

}
