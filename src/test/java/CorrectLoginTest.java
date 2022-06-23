import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CorrectLoginTest extends SeleniumBaseTest{

    /**Test nr. 6 Correct login test.*/
    @Test
    public void shouldLogSuccessfully(){

        new LoginPage(driver)
                .typeEmail(config.getLogin())
                .typePassword(config.getPassword())
                .submitLogin()
                .assertWelcomeElemetIsShown();
    }
}
