import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumBaseTest {
    protected WebDriver driver;


    @BeforeMethod
    public void baseBeforeMethod() {
        WebDriverManager.chromedriver().driverVersion("100.0.4896.127").setup();
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost:4444/");
    }

    @AfterMethod
    public void baseAfterMethod() {
        driver.quit();
    }

}

}
