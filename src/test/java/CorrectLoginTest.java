import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class CorrectLoginTest extends SeleniumBaseTest {

    /**
     * Test nr. 4 Correct login test.
     */
    @Test
    public void correctLoginTest() {

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .assertWelcomeElemetIsShown();
    }
}
