package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage {
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver driver;

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public CreateAccountPage registerWithFailure() {
        registerBtn.click();
        return this;
    }

    public CreateAccountPage assertErrorIsShown(String errorText) {
        boolean doesErrorExists = false;
        for (int i = 0; i < loginErrors.size(); i++) {
            if (loginErrors.get(i).getText().equals(errorText)) {
                doesErrorExists = true;
                break;
            }
        }
        Assert.assertTrue(doesErrorExists);
        return this;
    }

}
