import org.testng.annotations.Test;
import pages.LoginPage;

public class CorrectLoginTest extends SeleniumBaseTest{

    @Test //test scenerio: 4
    public void shouldLogSuccessfully(){

        new LoginPage(driver)
                .typeEmail(config.getLogin())
                .typePassword(config.getPassword())
                .submitLogin()
                .assertWelcomeElemetIsShown();
    }
}
