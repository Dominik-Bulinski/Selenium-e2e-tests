import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RegisterNewUserTest extends SeleniumBaseTest{

    @DataProvider
    public static Object[][] wrongPasswords(){
        return new Object[][]{
                {"xyz","Password is too short."},
                {"wrongpassword1!","Passwords does not have capital letter"},
                {"Wrongpassword1","Passwords must consist one non alphanumeric character."}
        };
    }

    /**Test nr. 3 Incorrect user registration test - password does not meet requirements:
    a) does not contain a capital letter
    b) does not contain a digit
    c) does not contain a special character*/

    @Test(dataProvider = "wrongPasswords")
    public void shouldFail(String password, String errMsg){
        String email = "test@gmail.com";
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password)
                .submitRegisterWithFailure()
                .assertRegisterErrorIsShown(errMsg);
    }
}
