package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import java.util.List;

public class AddPhone extends PageObject {

    public AddPhone(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "my-select")
    private WebElement countryCode;

    @FindBy(xpath = "/html/body/app-root/app-add-phone/form/div/div[1]/select/option[5]")
    private WebElement countryCodeGermany;

    @FindBy(xpath = "/html/body/app-root/app-add-phone/form/div/div[1]/select/option[4]")
    private WebElement countryCodeEng;

    @FindBy(xpath = "/html/body/app-root/app-add-phone/form/div/div[1]/select/option[3]")
    private WebElement countryCodeItaly;

    @FindBy(xpath = "/html/body/app-root/app-add-phone/form/div/div[1]/select/option[2]")
    private WebElement countryCodeSpain;

    @FindBy(id = "phoneNumber")
    private WebElement phone;

    @FindBy(css = ".btn")
    private WebElement addPhoneButton;

    @FindBy(id = "minLength-phoneNumber")
    private WebElement errorMin;

    @FindBy(id = "maxLength-phoneNumber")
    private WebElement errorMax;

    @FindBy(id = "wrong-phoneNumber")
    private WebElement error;

    public void addPhone(String number) {
        chooseCountry();
        phone.sendKeys(number);
        addPhoneButton.isEnabled();
        addPhoneButton.click();
    }

    public void chooseCountry() {
        countryCode.click();
        List<WebElement> codes = driver.findElements(By.name("my-select"));
        driver.findElement(By.xpath("/html/body/app-root/app-add-phone/form/div/div[1]/select/option[5]")).click();
    }

    public String errorMin() {
        return errorMin.getText();
    }

    public String errorMax() {
        return errorMax.getText();
    }

    public String error() {
        return error.getText();
    }

}
