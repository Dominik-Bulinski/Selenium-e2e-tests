package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(css = "#Password")
    private WebElement passwordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement loginBtn;

    @FindBy(css = "a[href*=Register]")
    private WebElement registerBtn;

    @FindBy(css = ".validation-summary-errors>ul>li")
    public List<WebElement> registerErrors;


    public LoginPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);
        return this;
    }


    public LoginPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);
        return this;
    }

    public HomePage submitLogin() {
        loginBtn.click();
        return new HomePage(driver);
    }


    public LoginPage assertLoginIsShown(String errorText) {
        boolean doesErrorExists = false;
        for (int i = 0; i < registerErrors.size(); i++) {
            if (registerErrors.get(i).getText().equals(errorText)) {
                doesErrorExists = true;
                break;
            }
        }
        Assert.assertTrue(doesErrorExists);
        return this;
    }

    public CreateAccountPage goToRegisterPage() {
        registerBtn.click();
        return new CreateAccountPage(driver);
    }

}
