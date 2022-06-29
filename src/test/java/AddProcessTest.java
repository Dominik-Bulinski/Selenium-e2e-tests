import config.Config;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.UUID;

public class AddProcessTest extends SeleniumBaseTest {

    /**
     * Test nr. 6 for correct addition of a process - check if it has been added to the Processes table.
     */
    @Test
    private void correctAddingProcessTest() {
        String processName = UUID.randomUUID().toString().substring(0, 10);
        String processDescription = Faker.instance().harryPotter().book();
        String processNotes = Faker.instance().funnyName().name();

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess()
                .typeProcessName(processName)
                .typeProcesDescription(processDescription)
                .typeProcessNotes(processNotes)
                .submitProcessCreation()
                .assertProcessesHeader()
                .assertProcess(processName, processDescription, processNotes);
    }

    /**
     * Test nr. 7 that the process has been added correctly - check that it displays on the Dashboard page.
     */
    @Test
    public void addingProcessToDashboard() {
        String processName = UUID.randomUUID().toString().substring(0, 10);
        String processDescription = Faker.instance().harryPotter().book();
        String processNotes = Faker.instance().funnyName().name();

        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess()
                .typeProcessName(processName)
                .typeProcesDescription(processDescription)
                .typeProcessNotes(processNotes)
                .submitProcessCreation()
                .goToDashBoard()
                .assertDashboardUrl("http://localhost:4444/")
                .assertNewProcessWasAdded(processName);
    }

    /**
     * Test nr. 8 for invalid process addition..
     */
    @Test
    public void invalidProcessAddingTest() {
        String tooShortProcessName = "xy";
        new LoginPage(driver)
                .typeEmail(config.getApplicationUser())
                .typePassword(config.getApplicationPassword())
                .submitLogin()
                .goToProcesses()
                .addNewProcess()
                .typeProcessName(tooShortProcessName)
                .goBackToProcessesList()
                .assertProcessIsNotShown(tooShortProcessName);
    }
}
