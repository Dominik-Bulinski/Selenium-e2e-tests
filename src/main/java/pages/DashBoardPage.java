package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class DashBoardPage extends HomePage{

    @FindBy(css = ".x_title>h2")
    private WebElement header;
    @FindBy(id = "button=[type=primary btn]")
    private WebElement reportBtn;

    @FindBy(css=".tile_info")
    private List<WebElement> characteristicsTable;

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public DashBoardPage clickReport() {
        reportBtn.click();
        return new DashBoardPage(driver);
    }

    public void goToDashboards() {
        new DashBoardPage(driver)
                .clickReport();
    }

//    public DashBoardPage assertCharacteristicWasAdded(String expName){
//        String GENERIC_CHARACTERISTIC_XPATH="//p[contains(text(), '%s')]";
//
//        String characteristicNameXpath=String.format(GENERIC_CHARACTERISTIC_XPATH,expName);
//        WebElement characteristic = driver.findElement(By.xpath(characteristicNameXpath));
//        Assert.assertEquals(characteristic.getText(),expName,"Characteristics Name does not match.");
//        return this;
//    }

    public DashBoardPage assertDashboardUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url, "adresy sie nie zgadzają");
        return this;
    }

//    public DashBoardPage assertDemoProjectIsShown() {
//        header.isDisplayed();
//        Assert.assertTrue(header.isDisplayed(), "Demo project is not shown");
//        return this;
//    }
    public DashBoardPage assertNewProcessWasAdded(String expName){
        String GENERIC_PROCESSNAME_XPATH="//h2[text()='%s']";

        String processNameXpath=String.format(GENERIC_PROCESSNAME_XPATH,expName);
        WebElement process = driver.findElement(By.xpath(processNameXpath));
        System.out.println("looking for element with name:"+expName);
        System.out.println("by xpath: "+processNameXpath);

        Assert.assertEquals(process.getText(),expName,"names of the processes does not match");
        return this;
    }
}
