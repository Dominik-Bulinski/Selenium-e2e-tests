import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RegisterNewUserTest extends SeleniumBaseTest {

    /**
     * Test nr. 2 Incorrect user registration test - passwords in "Password" and "Confirm Password" fields are inconsistent.
     */
    @Test
    public void incorrectRegistriationTest() {
        String email = Faker.instance().internet().emailAddress();
        String password = Faker.instance().regexify("[A-Z]{1}[a-z]{5,96}[0-9]{1}([@#!$%^&*])");

        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword("OtherPassword1!")
                .submitRegisterWithFailure()
                .submitRegisterWithFailure()
                .assertRegisterErrorIsShown("The password and confirmation password do not match.");
    }


    /**
     * Test nr. 3 Incorrect user registration test - password does not meet requirements:
     * a) does not contain a capital letter
     * b) does not contain a digit
     * c) does not contain a special character
     */

    @DataProvider
    public static Object[][] wrongPasswords() {
        return new Object[][]{
                {"xyz"},
                {"wrongpassword1!"},
                {"Wrongpassword1"}
        };
    }

    @Test(dataProvider = "wrongPasswords")
    public void wrongPasswordTest(String password, String errMsg) {
        String email = "test@test.com";
        new LoginPage(driver)
                .goToRegisterPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password)
                .submitRegisterWithFailure()
                .assertRegisterErrorIsShown(errMsg);
    }
}
