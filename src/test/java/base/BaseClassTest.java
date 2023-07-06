package base;

import Base.CustomDriver;
import PageClasses.HomePage;
import Utilities.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassTest {
    protected static final Logger log = LogManager.getLogger(CustomDriver.class.getName());
    public WebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void beforeSetUp() {
        driver = WebDriverFactory.getInstance().getDriver("chrome");
        String baseURL = Constants.BASE_URL;
        driver.get(baseURL);
        homePage = new HomePage(driver);
        homePage.clickAcupuntureLink();
    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }
    @AfterMethod
    public void methodAfterSetUp() {
        driver.navigate().refresh();
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
