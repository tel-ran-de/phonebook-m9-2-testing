package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

// User Page is not finished yet
public class MainPage extends PageObject {
    public MainPage(WebDriver driver) { super(driver);
    }

    @FindBy(xpath = "")
    private WebElement menuBtn;

    @FindBy(xpath = "")
    private WebElement settingsBtn;

    @FindBy (xpath = "/html/body/app-root/app-user-page/app-header/nav/a[2]")
    private WebElement logout;


    private void clickCreatePage() {
        menuBtn.click();
        driver.findElement(By.xpath("")).click();
    }

    private Login logout(){
        logout.click();
        return new Login(driver);
    }


}
